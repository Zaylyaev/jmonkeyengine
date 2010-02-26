package com.jme3.scene.control;

/**
 * The type of control.
 *
 * @author Kirill Vainer.
 */
public enum ControlType {

    /**
     * Manages the level of detail for the model.
     */
    LevelOfDetail,

    /**
     * Provides methods to manipulate the skeleton and bones.
     */
    BoneControl,

    /**
     * Handles the bone animation and skeleton updates.
     */
    BoneAnimation,

    /**
     * Handles attachments to bones
     */
    Attachment,

    /**
     * Handles vertex/morph animation.
     */
    VertexAnimation,

    /**
     * Handles poses or morph keys.
     */
    Pose,

}
