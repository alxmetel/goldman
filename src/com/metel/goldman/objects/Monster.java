/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;

/**
 *
 * @author Metel
 * Класс отвечает за работу объекта MONSTER
 */

public class Monster extends AbstractMovingObject {
    
    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);
        
        super.setIconDown(getImageIcon("/com/metel/goldman/images/monster_down.jpg"));
        super.setIconUp(getImageIcon("/com/metel/goldman/images/monster_up.jpg"));
        super.setIconLeft(getImageIcon("/com/metel/goldman/images/monster_left.jpg"));
        super.setIconRight(getImageIcon("/com/metel/goldman/images/monster_right.jpg"));
        
        super.setIcon(getIconLeft()); //по умолчанию будет использоваться эта иконка
    }

    @Override
    public void move(MovingDirection direction) {
        
    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {
        
    }
    
}
