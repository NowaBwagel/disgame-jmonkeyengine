/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowabwagel.disgameengine.entitysystem;

import java.util.Set;

/**
 *
 * @author Karsten
 */
public interface EntityData {
    
    public EntityId newEntity();
    public void removeEntity(EntityId entity);
    
    public void addComponent(EntityId entity,Component component);
    public <T extends Component> void removeComponent(EntityId entity, Class<T> componentClass);
    public <T extends Component> T getComponent(EntityId entity, Class<T> componentClass);
    public <T extends Component> boolean hasComponent(EntityId entity, Class<T> componentClass);
    //public <T extends Component> List<T> getAllComponentsOfEntity(long entity);
    
    public Set<EntityId> getAllEntitysWithComponents(Class<? extends Component> ... components);
}
