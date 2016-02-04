/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.game.interfaces;

import com.metel.goldman.objects.game.common.AbstractGameObject;
import com.metel.goldman.objects.game.enums.MovingDirection;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 */

// Поведение для всех движущихся объектов

public interface MovingObject extends StaticObject {
    
    void move(MovingDirection direction);
    void getMoveResult(AbstractGameObject objectInNewCoordinate);
    
    // иконки при движении в разные стороны
    ImageIcon getIconLeft();
    ImageIcon getIconUp();
    ImageIcon getIconDown();
    ImageIcon getIconRight();

   
    
}
