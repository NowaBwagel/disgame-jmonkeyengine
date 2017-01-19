package com.nowabwagel.disgame;

import com.jme3.math.Vector3f;
import com.nowabwagel.disengine.entitysystem.EntitySystem;

/**
 *
 * @author Noah Bergl
 */
public class EntityFactory {
    private static EntitySystem entitySystem;
    
    public static void init(EntitySystem eS){
        entitySystem = eS;
    }
    
    public static void createCube(Vector3f v3f){
        
    }
}
