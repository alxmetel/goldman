/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gameobjects.abstracts;

import com.metel.goldman.gameobjects.impl.Coordinate;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.gameobjects.interfaces.StaticObject;
import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Класс, который отвечает за любой объект, созданный в игре. Задает все общие
 * характеристики объектов в игре
 */

public abstract class AbstractGameObject implements StaticObject, Serializable {
    
    private GameObjectType type;// все объекты будут иметь тип
    private Coordinate coordinate;// все объекты будут иметь координаты положения
    
    private ImageIcon icon = getImageIcon("/com/metel/goldman/images/noicon.png");// изображение по-умолчанию

    protected AbstractGameObject() {
    }

    public void setIcon(ImageIcon currentIcon) {
        this.icon = currentIcon;
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    
    protected ImageIcon getImageIcon(String path){
        return new ImageIcon(getClass().getResource(path));
    }
    
    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.type);
        hash = 43 * hash + Objects.hashCode(this.coordinate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractGameObject other = (AbstractGameObject) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.coordinate, other.coordinate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
