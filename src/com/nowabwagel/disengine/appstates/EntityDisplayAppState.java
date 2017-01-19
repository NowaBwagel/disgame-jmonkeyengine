/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowabwagel.disengine.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;

/**
 *
 * @author Noah Bergl
 */
public class EntityDisplayAppState extends AbstractAppState {
    
    private Node rootNode;
    
    public EntityDisplayAppState(Node node){
        rootNode = node;
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app){
        super.initialize(stateManager, app);
        
        
    }
    
    @Override
    public void update(float tpf){
        
    }
}
