/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowabwagel.disengine.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.nowabwagel.disengine.components.InSceneComponent;
import com.nowabwagel.disengine.components.PositionComponent;
import com.nowabwagel.disengine.components.VisualRepComponent;
import com.nowabwagel.disengine.entitysystem.Entity;
import com.nowabwagel.disengine.entitysystem.EntitySet;
import com.nowabwagel.disengine.entitysystem.EntitySystem;
import com.nowabwagel.disgame.Disgame;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Noah Bergl
 */
public class EntityDisplayAppState extends AbstractAppState {

    private EntitySet entitySet;
    private AssetManager assetManager;
    private Node rootNode;

    public EntityDisplayAppState(Node node) {
        rootNode = node;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        EntitySystem entitySystem = ((Disgame) app).getEntitySystem();
        this.assetManager = app.getAssetManager();

        entitySet = entitySystem.getEntitySet(InSceneComponent.class, PositionComponent.class, VisualRepComponent.class);
    }

    @Override
    public void update(float tpf) {
        if(entitySet.shouldApplySetChanges()){
            
        }
    }
    
    private void add(Set<Entity> set){
        Iterator<Entity> iterator = set.iterator();
        
        while(iterator.hasNext()){
            Entity entity = iterator.next();
            
        }
    }
}
