/*
 * Copyright (c) 2003, jMonkeyEngine - Mojo Monkey Coding
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this 
 * list of conditions and the following disclaimer. 
 * 
 * Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution. 
 * 
 * Neither the name of the Mojo Monkey Coding, jME, jMonkey Engine, nor the 
 * names of its contributors may be used to endorse or promote products derived 
 * from this software without specific prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package jme.geometry.primitive;

import java.util.logging.Level;

import jme.exception.MonkeyGLException;
import jme.exception.MonkeyRuntimeException;
import jme.math.Vector;
import jme.texture.TextureManager;
import jme.utility.LoggingSystem;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.Window;

/**
 * <code>Pyramid</code> defines a primitive object of a pyramid shape. The
 * pyramid is a four sided pyramid. The pyramid is defined by the size of the
 * base and the height.
 * 
 * @author Mark Powell
 * @version $Id: Pyramid.java,v 1.1.1.1 2003-10-29 10:58:08 Anakan Exp $
 */
public class Pyramid extends Primitive {
    private boolean usingDisplay;
    private int listId;
    private float base;
    private float height;
    private GL gl;
    private Vector[] points;

    /**
     * Constructor instantiates a new <code>Pyramid</code> object with 
     * the given attributes.
     * @param base The size of the base of the pyramid, where the size is
     * 		one side of the base.
     * @param height the height of the pyramid at it's peak.
     * @throws MonkeyRuntimeException if base and/or height is negative.
     * @throws MonkeyGLException if OpenGL has not been set up yet.
     */
    public Pyramid(float base, float height) {
        if (base < 0 || height < 0) {
            throw new MonkeyRuntimeException(
                "Neither base nor height can be " + "negative.");
        }

        if (!Window.isCreated()) {
            throw new MonkeyGLException(
                "Window must be created before Pyramid.");
        }
        this.base = base;
        this.height = height;
        initialize();
        LoggingSystem.getLoggingSystem().getLogger().log(
            Level.INFO,
            "Created Pyramid.");
    }

    /**
     * <code>setBase</code> sets the base size for the pyramid. The base is
     * the size of a single size of the base.
     * @param base the new size of the pyramid base.
     * @throws MonkeyRuntimeException if the base is negative.
     */
    public void setBase(float base) {
        if (base < 0) {
            throw new MonkeyRuntimeException("Base may not be negative.");
        }
        this.base = base;
    }

    /**
     * <code>setHeight</code> sets the new peak height of the pyramid.
     * @param height the new peak height of the pyramid.
     * @throws MonkeyRuntimeException if the height is negative.
     */
    public void setHeight(float height) {
        if (height < 0) {
            throw new MonkeyRuntimeException("Height may not be negative.");
        }
        this.height = height;
    }

    /**
     * <code>useDisplayList</code> sets the pyramid as a display list for
     * possibly faster rendering.
     * @param value true will use the display list, false will not.
     */
    public void useDisplayList(boolean value) {
        if (value) {
            listId = GL.glGenLists(1);
            GL.glNewList(listId, GL.GL_COMPILE);
            renderPyramid();
            GL.glEndList();
            usingDisplay = true;
        } else {
            usingDisplay = false;
        }
    }

    /**
     * <code>render</code> displays the pyramid with the current parameters.
     */
    public void render() {
        if (usingDisplay) {
            GL.glCallList(listId);
        } else {
            renderPyramid();
        }
    }

    /**
     * <code>initialize</code> sets up the bounding volumes of the 
     * pyramid.
     */
    public void initialize() {
        float boundry;
        if (height > base) {
            boundry = height;
        } else {
            boundry = base;
        }
        
        points = new Vector[5];
        points[0] = new Vector(-base / 2, -height / 2, -base / 2);
        points[1] = new Vector(base / 2, -height / 2, -base / 2);
        points[2] = new Vector(base / 2, -height / 2, base / 2);
        points[3] = new Vector(-base / 2, -height / 2, base / 2);
        points[4] = new Vector(0, height / 2, 0);
    }

    /**
     * <code>preRender</code> does not do anything within Pyramid.
     */
    public void preRender() {
        //nothing to do

    }

    /**
        * <code>renderPyramid</code> renders the pyramid.
        *
        */
    private void renderPyramid() {
        if (getTextureId() > 0) {
            TextureManager.getTextureManager().bind(getTextureId());
            GL.glEnable(GL.GL_TEXTURE_2D);
        }

        GL.glColor4f(red, green, blue, alpha);
        GL.glBegin(GL.GL_TRIANGLES);

        //front
        GL.glTexCoord2f(1, 0);
        GL.glVertex3f(points[0].x, points[0].y, points[0].z);
        GL.glTexCoord2f(0.5f, 1);
        GL.glVertex3f(points[4].x, points[4].y, points[4].z); //top
        GL.glTexCoord2f(0.75f, 0);
        GL.glVertex3f(points[1].x, points[1].y, points[1].z); //f2

        //right
        GL.glTexCoord2f(0.75f, 0);
        GL.glVertex3f(points[1].x, points[1].y, points[1].z); //f2
        GL.glTexCoord2f(0.5f, 1);
        GL.glVertex3f(points[4].x, points[4].y, points[4].z); //top
        GL.glTexCoord2f(0.5f, 0);
        GL.glVertex3f(points[2].x, points[2].y, points[2].z); //b2

        //back
        GL.glTexCoord2f(0.5f, 0);
        GL.glVertex3f(points[2].x, points[2].y, points[2].z); //b2
        GL.glTexCoord2f(0.5f, 1);
        GL.glVertex3f(points[4].x, points[4].y, points[4].z); //top
        GL.glTexCoord2f(0.25f, 0);
        GL.glVertex3f(points[3].x, points[3].y, points[3].z); //b1

        //left
        GL.glTexCoord2f(0.25f, 0);
        GL.glVertex3f(points[3].x, points[3].y, points[3].z); //b1
        GL.glTexCoord2f(0.5f, 1);
        GL.glVertex3f(points[4].x, points[4].y, points[4].z); //top
        GL.glTexCoord2f(0, 0);
        GL.glVertex3f(points[0].x, points[0].y, points[0].z);

        //bottom
        GL.glTexCoord2f(0, 0);
        GL.glVertex3f(points[0].x, points[0].y, points[0].z); //f1
        GL.glTexCoord2f(1, 1);
        GL.glVertex3f(points[2].x, points[2].y, points[2].z); //b2
        GL.glTexCoord2f(0, 1);
        GL.glVertex3f(points[3].x, points[3].y, points[3].z); //b1
        GL.glTexCoord2f(0, 0);
        GL.glVertex3f(points[0].x, points[0].y, points[0].z); //f1
        GL.glTexCoord2f(1, 0);
        GL.glVertex3f(points[1].x, points[1].y, points[1].z); //f2
        GL.glTexCoord2f(1, 1);
        GL.glVertex3f(points[2].x, points[2].y, points[2].z); //b2

        GL.glEnd();

        if (getTextureId() > 0) {
            GL.glDisable(GL.GL_TEXTURE_2D);
        }
    }
    
    public Vector[] getPoints() {
        return points;
    }

}
