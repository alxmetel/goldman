/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.abstracts;

import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.MovingObject;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Класс, который отвечает за любой движущийся объект, наследуется от класса
 * AbstractGameObject с добавлением функций движения
 */

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject{
    
    
    private ImageIcon iconLeft;
    private ImageIcon iconUp;
    private ImageIcon iconDown;
    private ImageIcon iconRight;
    

    @Override
    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    public void setIconLeft(ImageIcon iconLeft) {
        this.iconLeft = iconLeft;
    }

    @Override
    public ImageIcon getIconUp() {
        return iconUp;
    }

    public void setIconUp(ImageIcon iconUp) {
        this.iconUp = iconUp;
    }

    @Override
    public ImageIcon getIconDown() {
        return iconDown;
    }

    public void setIconDown(ImageIcon iconDown) {
        this.iconDown = iconDown;
    }

    @Override
    public ImageIcon getIconRight() {
        return iconRight;
    }

    public void setIconRight(ImageIcon iconRight) {
        this.iconRight = iconRight;
    }
}
