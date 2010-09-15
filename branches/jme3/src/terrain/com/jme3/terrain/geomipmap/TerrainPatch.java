package com.jme3.terrain.geomipmap;


import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import com.jme3.math.FastMath;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.terrain.LodThreshold;
import com.jme3.util.BufferUtils;


/**
 * A terrain patch is a leaf in the terrain quad tree. It has a mesh that can change levels of detail (LOD)
 * whenever the view point, or camera, changes. The actual terrain mesh is created by the LODGeomap class.
 * That uses a geo mip mapping algorithm to change the index buffer of the mesh.
 * The mesh is a triangle strip. In wireframe mode you might notice some strange lines, these are degenerate
 * triangles generated by the geoMipMap algorithm and can be ignored. The video card removes them at almost no cost.
 * 
 * Each patch needs to know its neighbour's LOD so it can seam its edges with them, in case the neighbour has a different
 * LOD. If this doesn't happen, you will see gaps.
 * 
 * The LOD value is most detailed at zero. It gets less detailed the heigher the LOD value until you reach maxLod, which
 * is a mathimatical limit on the number of times the 'size' of the patch can be divided by two. However there is a -1 to that
 * for now until I add in a custom index buffer calculation for that max level, the current algorithm does not go that far.
 * 
 * You can supply a LodThresholdCalculator for use in determining when the LOD should change. It's API will no doubt change 
 * in the near future. Right now it defaults to just changing LOD every two patch sizes. So if a patch has a size of 65, 
 * then the LOD changes every 130 units away.
 * 
 * @author Brent Owens
 */
public class TerrainPatch extends Geometry {

	protected LODGeomap geomap;
	protected int lod = -1; // this terrain patch's LOD
	private int maxLod = -1;
	//protected boolean reIndexNeeded = false;
	//protected boolean fixEdges = false;
	protected int previousLod = -1;
	//private boolean firstLoad = true; // so we can reset the lod based on where the camera starts, or else the far away tiles can be full detail
	protected int lodLeft, lodTop, lodRight, lodBottom; // it's neighbour's LODs
	
	protected int size;

	protected int totalSize;

	protected short quadrant = 1;

	// x/z step
	protected Vector3f stepScale;

	// center of the block in relation to (0,0,0)
	protected Vector2f offset;

	// amount the block has been shifted.
	protected float offsetAmount;
	
	protected LodThreshold lodThresholdCalculator = new SimpleLodThreshold(size);
		
	public TerrainPatch(String name) {
		super(name);
	}
	
	public TerrainPatch(String name, int size) {
		this(name, size, new Vector3f(1,1,1), null, new Vector3f(0,0,0));
		
	}
	
	/**
	 * Constructor instantiates a new <code>TerrainPatch</code> object. The
	 * parameters and heightmap data are then processed to generate a
	 * <code>TriMesh</code> object for rendering.
	 * 
	 * @param name
	 *			the name of the terrain block.
	 * @param size
	 *			the size of the heightmap.
	 * @param stepScale
	 *			the scale for the axes.
	 * @param heightMap
	 *			the height data.
	 * @param origin
	 *			the origin offset of the block.
	 */
	public TerrainPatch(String name, int size, Vector3f stepScale,
			float[] heightMap, Vector3f origin) {
		this(name, size, stepScale, heightMap, origin, size, new Vector2f(), 0);
	}

	/**
	 * Constructor instantiates a new <code>TerrainPatch</code> object. The
	 * parameters and heightmap data are then processed to generate a
	 * <code>TriMesh</code> object for renderering.
	 * 
	 * @param name
	 *			the name of the terrain block.
	 * @param size
	 *			the size of the block.
	 * @param stepScale
	 *			the scale for the axes.
	 * @param heightMap
	 *			the height data.
	 * @param origin
	 *			the origin offset of the block.
	 * @param totalSize
	 *			the total size of the terrain. (Higher if the block is part of
	 *			a <code>TerrainPage</code> tree.
	 * @param offset
	 *			the offset for texture coordinates.
	 * @param offsetAmount
	 *			the total offset amount. Used for texture coordinates.
	 */
	public TerrainPatch(String name, int size, Vector3f stepScale,
			float[] heightMap, Vector3f origin, int totalSize,
			Vector2f offset, float offsetAmount) {
		super(name);
		this.size = size;
		this.stepScale = stepScale;
		this.totalSize = totalSize;
		this.offsetAmount = offsetAmount;
		this.offset = offset;

		setLocalTranslation(origin);
		
		//int[] height = new int[heightMap.length];
		//for (int i=0; i<heightMap.length; i++)
		//	height[i] = (int) heightMap[i];
		
		FloatBuffer heightBuffer = BufferUtils.createFloatBuffer(size*size);
		heightBuffer.put(heightMap);
		
		geomap = new LODGeomap(size, heightBuffer);
		Mesh mesh = geomap.createMesh(stepScale, new Vector2f(1,1), offset, offsetAmount, totalSize, false);
		setMesh(mesh);
		
	}
	
	/**
	 * The maximum lod supported by this terrain patch.
	 * If the patch size is 32 then the returned value would be log2(32)-2 = 3
	 * You can then use that value, 3, to see how many times you can divide 32 by 2 
	 * before the terrain gets too un-detailed (can't stitch it any further).
	 * @return
	 */
	public int getMaxLod() {
		if (maxLod < 0)
			maxLod = Math.max(1, (int) (FastMath.log(size-1)/FastMath.log(2)) -1); // -2 forces our minimum of 4 triangles wide
		//System.out.println("max lod = "+lod);
		return maxLod;
	}
	
	public Vector3f getCenterLocation() {
		Vector3f loc = getWorldTranslation().clone();
		loc.x += size/2;
		loc.z += size/2;
		return loc;
	}
	
	protected boolean calculateLod(Vector3f location, HashMap<String,UpdatedTerrainPatch> updates) {
		
		float distance = getCenterLocation().distance(location);
		
		// go through each lod level to find the one we are in
		for (int i=0; i<=getMaxLod(); i++) {
			if (distance < lodThresholdCalculator.getLodDistanceThreshold()*(i+1)) {
				boolean reIndexNeeded = false;
				if (i != lod) {
					reIndexNeeded = true;
					//System.out.println("lod change: "+lod+" > "+i+"    dist: "+distance);
				}
				int prevLOD = lod;
				//previousLod = lod;
				//lod = i;
				UpdatedTerrainPatch utp = updates.get(this.getName());
				if (utp == null) {
					utp = new UpdatedTerrainPatch(this, i);//save in here, do not update actual variables
					updates.put(utp.getName(), utp);
				}
				utp.setPreviousLod(prevLOD);
				utp.setReIndexNeeded(reIndexNeeded);
				return reIndexNeeded;
			}
		}
		
		int newLOD = lod;
		int prevLOD = previousLod;
		
		if (newLOD != getMaxLod())
			prevLOD = newLOD;
		
		// max lod (least detailed)
		newLOD = getMaxLod();
		
		boolean reIndexNeeded = false;
		
		if (prevLOD != newLOD)
			reIndexNeeded = true;
		
		UpdatedTerrainPatch utp = updates.get(this.getName());
		if (utp == null) {
			utp = new UpdatedTerrainPatch(this, newLOD);// save in here, do not update actual variables
			updates.put(utp.getName(), utp);
		}
		utp.setPreviousLod(prevLOD);
		utp.setReIndexNeeded(reIndexNeeded);
		
		return reIndexNeeded;
	}
	
	protected void reIndexGeometry(HashMap<String,UpdatedTerrainPatch> updated) {
		
		UpdatedTerrainPatch utp = updated.get(getName());
		
		if (utp != null && (utp.isReIndexNeeded() || utp.isFixEdges()) ) {
			int pow = (int) Math.pow(2, utp.getNewLod());
			boolean left = utp.getLeftLod() > utp.getNewLod();
			boolean top = utp.getTopLod() > utp.getNewLod();
			boolean right = utp.getRightLod() > utp.getNewLod();
			boolean bottom = utp.getBottomLod() > utp.getNewLod();
			IntBuffer ib = geomap.writeIndexArrayLodDiff(null, pow, right, top, left, bottom);
			utp.setNewIndexBuffer(ib);
			//getMesh().clearBuffer(Type.Index);
			//getMesh().setBuffer(Type.Index, 3, ib);
		}
		
		/*
		if (reIndexNeeded || fixEdges) {
			int pow = (int) Math.pow(2, lod);
			IntBuffer ib = geomap.writeIndexArrayLodDiff(null, pow, lodRight>lod, lodTop>lod, lodLeft>lod, lodBottom>lod);
			getMesh().clearBuffer(Type.Index);
			getMesh().setBuffer(Type.Index, 3, ib);
			// reset:
			reIndexNeeded = false;
			fixEdges = false;
		}
		*/
	}

	
	/**
	 * Find what the other neighbour's LODs are.
	 * Stored in the lodLeft, lodTop, LodRight, lodBottom variables
	 */
	/*protected void findNeighboursLod() {
		
	}*/
	
	public float getHeight(Vector2f position) {
		return getHeight(position.x, position.y);
	}

	public float getHeight(Vector3f position) {
		return getHeight(position.x, position.z);
	}

	/**
	 * <code>getHeight</code> returns the height of an arbitrary point on the
	 * terrain. If the point is between height point values, the height is
	 * linearly interpolated. This provides smooth height calculations. If the
	 * point provided is not within the bounds of the height map, the NaN float
	 * value is returned (Float.NaN).
	 * 
	 * @param x
	 *			the x coordinate to check.
	 * @param z
	 *			the z coordinate to check.
	 * @return the height at the provided location.
	 */
	public float getHeight(float x, float z) {
		
		return 0; //TODO!!!
		
		/*x /= stepScale.x;
		z /= stepScale.z;
		float col = FastMath.floor(x);
		float row = FastMath.floor(z);

		if (col < 0 || row < 0 || col >= size - 1 || row >= size - 1) {
			return Float.NaN;
		}
		float intOnX = x - col, intOnZ = z - row;

		float topLeft, topRight, bottomLeft, bottomRight;

		int focalSpot = (int) (col + row * size);

		// find the heightmap point closest to this position (but will always
		// be to the left ( < x) and above (< z) of the spot.
		topLeft = heightMap[focalSpot] * stepScale.y;

		// now find the next point to the right of topLeft's position...
		topRight = heightMap[focalSpot + 1] * stepScale.y;

		// now find the next point below topLeft's position...
		bottomLeft = heightMap[focalSpot + size] * stepScale.y;

		// now find the next point below and to the right of topLeft's
		// position...
		bottomRight = heightMap[focalSpot + size + 1] * stepScale.y;
		
		// Use linear interpolation to find the height.
		if(intOnX>intOnZ)
			return (1-intOnX)*topLeft + (intOnX-intOnZ)*topRight + (intOnZ)*bottomRight;
		else 
			return (1-intOnZ)*topLeft + (intOnZ-intOnX)*bottomLeft + (intOnX)*bottomRight;
		*/
	}
	
	/**
	 * Returns the offset amount this terrain block uses for textures.
	 * 
	 * @return The current offset amount.
	 */
	public float getOffsetAmount() {
		return offsetAmount;
	}

	/**
	 * Returns the step scale that stretches the height map.
	 * 
	 * @return The current step scale.
	 */
	public Vector3f getStepScale() {
		return stepScale;
	}

	/**
	 * Returns the total size of the terrain.
	 * 
	 * @return The terrain's total size.
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * Returns the size of this terrain block.
	 * 
	 * @return The current block size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the current offset amount. This is used when building texture
	 * coordinates.
	 * 
	 * @return The current offset amount.
	 */
	public Vector2f getOffset() {
		return offset;
	}

	/**
	 * Sets the value for the current offset amount to use when building texture
	 * coordinates. Note that this does <b>NOT </b> rebuild the terrain at all.
	 * This is mostly used for outside constructors of terrain blocks.
	 * 
	 * @param offset
	 *			The new texture offset.
	 */
	public void setOffset(Vector2f offset) {
		this.offset = offset;
	}

	/**
	 * Sets the size of this terrain block. Note that this does <b>NOT </b>
	 * rebuild the terrain at all. This is mostly used for outside constructors
	 * of terrain blocks.
	 * 
	 * @param size
	 *			The new size.
	 */
	public void setSize(int size) {
		this.size = size;
		
		maxLod = -1; // reset it
	}

	/**
	 * Sets the total size of the terrain . Note that this does <b>NOT </b>
	 * rebuild the terrain at all. This is mostly used for outside constructors
	 * of terrain blocks.
	 * 
	 * @param totalSize
	 *			The new total size.
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * Sets the step scale of this terrain block's height map. Note that this
	 * does <b>NOT </b> rebuild the terrain at all. This is mostly used for
	 * outside constructors of terrain blocks.
	 * 
	 * @param stepScale
	 *			The new step scale.
	 */
	public void setStepScale(Vector3f stepScale) {
		this.stepScale = stepScale;
	}

	/**
	 * Sets the offset of this terrain texture map. Note that this does <b>NOT
	 * </b> rebuild the terrain at all. This is mostly used for outside
	 * constructors of terrain blocks.
	 * 
	 * @param offsetAmount
	 *			The new texture offset.
	 */
	public void setOffsetAmount(float offsetAmount) {
		this.offsetAmount = offsetAmount;
	}
	
	/**
	 * @return Returns the quadrant.
	 */
	public short getQuadrant() {
		return quadrant;
	}

	/**
	 * @param quadrant
	 *			The quadrant to set.
	 */
	public void setQuadrant(short quadrant) {
		this.quadrant = quadrant;
	}

	/*protected boolean isReIndexNeeded() {
		return reIndexNeeded;
	}*/

	/**
	 * geometry should re-index and fix its edges since a neighbour's lod changed even though
	 * this one's lod did not.
	 * @param fixEdges
	 */
	/*protected void setFixEdges(boolean fixEdges) {
		this.fixEdges = fixEdges;
	}*/
	
	/*protected boolean lodChanged() {
		if (reIndexNeeded && previousLod != lod)
			return true;
		else
			return false;
	}*/

	protected LodThreshold getLodThreshold() {
		return lodThresholdCalculator;
	}

	protected void setLodThreshold(LodThreshold lodThresholdCalculator) {
		this.lodThresholdCalculator = lodThresholdCalculator;
	}

	protected int getLod() {
		return lod;
	}

	protected void setLod(int lod) {
		this.lod = lod;
	}

	protected int getPreviousLod() {
		return previousLod;
	}

	protected void setPreviousLod(int previousLod) {
		this.previousLod = previousLod;
	}

	protected int getLodLeft() {
		return lodLeft;
	}

	protected void setLodLeft(int lodLeft) {
		this.lodLeft = lodLeft;
	}

	protected int getLodTop() {
		return lodTop;
	}

	protected void setLodTop(int lodTop) {
		this.lodTop = lodTop;
	}

	protected int getLodRight() {
		return lodRight;
	}

	protected void setLodRight(int lodRight) {
		this.lodRight = lodRight;
	}

	protected int getLodBottom() {
		return lodBottom;
	}

	protected void setLodBottom(int lodBottom) {
		this.lodBottom = lodBottom;
	}
	
}
