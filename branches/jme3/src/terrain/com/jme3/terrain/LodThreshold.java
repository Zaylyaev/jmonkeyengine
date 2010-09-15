package com.jme3.terrain;


/**
 * Calculates the LOD value based on where the camera is.
 * This is pluged into the Terrain system and any terrain
 * using LOD will use this to determine when a patch of the 
 * terrain should switch Levels of Detail.
 * 
 * @author bowens
 */
public interface LodThreshold {

	/**
	 * A distance of how far between each LOD threshold.
	 */
	public float getLodDistanceThreshold();
}
