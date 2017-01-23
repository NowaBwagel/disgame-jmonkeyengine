package com.nowabwagel.disgame;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.nowabwagel.disengine.components.InSceneComponent;
import com.nowabwagel.disengine.components.PositionComponent;
import com.nowabwagel.disengine.components.TagComponent;
import com.nowabwagel.disengine.components.VisualRepComponent;
import com.nowabwagel.disengine.entitysystem.Component;
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
    
    public static void createTree(Vector3f v3f, Quaternion quat){
        Component[] components = new Component[3];
        components[0] = new VisualRepComponent("/Models/PineTree/PineTree.j3o");
        
        components[1] = new InSceneComponent(true);
        components[2] = new PositionComponent(v3f, quat);
        //components[3] = new TagComponent("cube");
        
        entitySystem.newEntity(components);
    }
    
    
}
