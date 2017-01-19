package com.nowabwagel.disengine.entitysystem;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Noah Bergl
 */
public class EntitySystem {
    
    private List<EntityEventListener> entityChangeListeners;
    private EntityData entityData;
    
    public EntitySystem(EntityData entityData){
        this.entityData = entityData;
        // To make sure the list is thread-safe
        entityChangeListeners = new CopyOnWriteArrayList<EntityEventListener>();
    }
}
