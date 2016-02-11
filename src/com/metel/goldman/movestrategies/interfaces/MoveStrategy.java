/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.movestrategies.interfaces;

import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;
import com.metel.goldman.gameobjects.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.collections.interfaces.GameCollection;

/**
 *
 * @author Metel
 */
public interface MoveStrategy {
    
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection);
    
}
