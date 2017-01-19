/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowabwagel.disengine.entitysystem;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Noah Bergl
 */
public class DefaultEntityData implements EntityData {

    private ConcurrentMap<Class, ConcurrentMap<EntityId, ? extends Component>> componentsMap;
    private EntityIdGenerator idGenerator;

    public DefaultEntityData() {
        componentsMap = new ConcurrentHashMap<Class, ConcurrentMap<EntityId, ? extends Component>>();
        idGenerator = new EntityIdGenerator();
    }

    public EntityId newEntity() {
        return new EntityId(idGenerator.getNextId());
    }

    public void removeEntity(EntityId entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addComponent(EntityId entity, Component component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T extends Component> void removeComponent(EntityId entity, Class<T> componentClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T extends Component> T getComponent(EntityId entity, Class<T> componentClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T extends Component> boolean hasComponent(EntityId entity, Class<T> componentClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<EntityId> getAllEntityWithComponents(Class<? extends Component>... components) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
