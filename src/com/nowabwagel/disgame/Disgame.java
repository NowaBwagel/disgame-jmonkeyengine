package com.nowabwagel.disgame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.nowabwagel.disengine.appstates.CubeMovementAppState;
import com.nowabwagel.disengine.appstates.EntityDisplayAppState;
import com.nowabwagel.disengine.entitysystem.DefaultEntityData;
import com.nowabwagel.disengine.entitysystem.EntitySystem;

/**
 *
 * @author Noah Bergl
 */
public class Disgame extends SimpleApplication {

    private EntitySystem entitySystem;

    public static void main(String[] args) {
        Disgame game = new Disgame();
        game.start();
    }

    @Override
    public void simpleInitApp() {
        entitySystem = new EntitySystem(new DefaultEntityData());

        EntityFactory.init(entitySystem);

        this.stateManager.attach(new EntityDisplayAppState(this.rootNode));
        this.stateManager.attach(new CubeMovementAppState());

        EntityFactory.createCube(Vector3f.ZERO, Quaternion.ZERO);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        viewPort.setBackgroundColor(ColorRGBA.DarkGray);

        //Setting the camera
        //this.cam.setLocation(new Vector3f(0, 96, 0));
        //this.cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);

        flyCam.setEnabled(true);
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        //rootNode.attachChild(geom);
    }

    public EntitySystem getEntitySystem() {
        return entitySystem;
    }
}
