/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.abstracts;

import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.gameobjects.MovingObject;
import com.metel.goldman.objects.Coordinate;
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
    
    @Override
    public void move(MovingDirection direction) {
        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// определяем, в каком направлении нужно двигаться по массиву
            case UP: {
                super.setIcon(getIconUp());
                newCoordinate.setXY(x, y - 1);
                break;
            }
            case DOWN: {
                super.setIcon(getIconDown());
                newCoordinate.setXY(x, y + 1);
                break;
            }
            case LEFT: {
                super.setIcon(getIconLeft());
                newCoordinate.setXY(x - 1, y);
                break;
            }
            case RIGHT: {
                super.setIcon(getIconRight());
                newCoordinate.setXY(x + 1, y);
                break;
            }
        }

        setCoordinate(newCoordinate);
    }
}
