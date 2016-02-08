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

        super.setIcon(getImageIcon("/com/metel/goldman/images/monster_up.jpg"));
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/com/metel/goldman/images/monster_down.jpg"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/com/metel/goldman/images/monster_right.jpg"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/com/metel/goldman/images/monster_right.jpg"));
                break;
            case UP:
                super.setIcon(getImageIcon("/com/metel/goldman/images/monster_up.jpg"));
                break;
        }
    }
}
