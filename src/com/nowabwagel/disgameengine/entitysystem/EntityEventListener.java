/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowabwagel.disgameengine.entitysystem;

/**
 *
 * @author Karsten
 */
public interface EntityEventListener {
    public void receiveEntityEvent(EntityEvent changeEvent);
    public Class<? extends Component>[] componentsIntrestedIn();
}
