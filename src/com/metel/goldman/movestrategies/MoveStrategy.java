/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.movestrategies;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.gamemap.collections.GameCollection;

/**
 *
 * @author Metel
 */
public interface MoveStrategy {
    
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection);
    
}
