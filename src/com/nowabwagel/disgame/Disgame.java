package com.nowabwagel.disgame;

import com.jme3.app.SimpleApplication;
import com.nowabwagel.disengine.entitysystem.DefaultEntityData;
import com.nowabwagel.disengine.entitysystem.EntitySystem;

/**
 *
 * @author Noah Bergl
 */
public class Disgame extends SimpleApplication {

    private EntitySystem entitySystem;
    
    public static void main(String[] args){
        Disgame game = new Disgame();
        game.start();
    }
    
    @Override
    public void simpleInitApp() {
        entitySystem = new EntitySystem(new DefaultEntityData());
        
        
    }
    
    public EntitySystem getEntitySystem(){
        return entitySystem;
    }
}
