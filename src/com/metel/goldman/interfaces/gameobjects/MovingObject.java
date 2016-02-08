/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gameobjects;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.MovingDirection;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Поведение для всех движущихся объектов
 */

public interface MovingObject extends StaticObject {
    
    void move(MovingDirection direction);
    void getMoveResult(AbstractGameObject objectInNewCoordinate);
    
    // иконки при движении в разные стороны
    ImageIcon getIconLeft();
    ImageIcon getIconUp();
    ImageIcon getIconDown();
    ImageIcon getIconRight();

   
    
}
