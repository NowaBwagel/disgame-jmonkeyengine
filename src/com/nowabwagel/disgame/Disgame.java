package com.nowabwagel.disgame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
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
    private TerrainQuad terrain;

    public static void main(String[] args) {
        Disgame game = new Disgame();
        game.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(50);
        cam.setLocation(new Vector3f(0f, 5f, 0f));

        entitySystem = new EntitySystem(new DefaultEntityData());

        EntityFactory.init(entitySystem);

        this.stateManager.attach(new EntityDisplayAppState(this.rootNode));
        this.stateManager.attach(new CubeMovementAppState());


        for (int x = -64; x < 64; x++) {
            for (int z = -64; z < 64; z++) {
                double ran = Math.random() * 100;
                System.out.println(ran);
                if (ran < 2) {
                    EntityFactory.createTree(new Vector3f(x, 0, z), Quaternion.ZERO);
                }
            }
        }
        EntityFactory.createTree(Vector3f.ZERO, Quaternion.ZERO);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        viewPort.setBackgroundColor(ColorRGBA.DarkGray);
        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat.setBoolean("UseMaterialColors", true);
        mat.setColor("Ambient", ColorRGBA.Green);
        mat.setColor("Diffuse", ColorRGBA.Green);


        flyCam.setEnabled(true);

        AbstractHeightMap heightMap = null;
        Texture heightMapImage = assetManager.loadTexture("Textures/TerrainTestFlat.png");
        heightMap = new ImageBasedHeightMap(heightMapImage.getImage());
        heightMap.load();
        heightMap.erodeTerrain();

        int patchSize = 65;
        terrain = new TerrainQuad("my terrain", patchSize, 513, heightMap.getHeightMap());

        terrain.setMaterial(mat);
        terrain.setLocalTranslation(0, 0, 0);
        terrain.setLocalScale(0.25f, 1f, 0.25f);

        rootNode.attachChild(terrain);

        TerrainLodControl terrainControl = new TerrainLodControl(terrain, getCamera());
        terrain.addControl(terrainControl);
    }

    public EntitySystem getEntitySystem() {
        return entitySystem;
    }
}
