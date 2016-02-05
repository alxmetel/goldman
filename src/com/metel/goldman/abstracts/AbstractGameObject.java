/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.abstracts;

import com.metel.goldman.objects.Coordinate;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.interfaces.StaticObject;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Класс, который отвечает за любой объект, созданный в игре. Задает все общие
 * характеристики объектов в игре
 */

public abstract class AbstractGameObject implements StaticObject {
    
    private GameObjectType type; // все объекты будут иметь тип
    private Coordinate coordinate; // все объекты будут иметь координаты положения
    
    private ImageIcon icon = getImageIcon("/com/metel/goldman/images/noicon.png"); //изображение по умолчанию

    public AbstractGameObject() {
    }

    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon currentIcon) {
        this.icon = currentIcon;
    }
    
    

    protected ImageIcon getImageIcon(String path){
        return new ImageIcon(getClass().getResource(path));
    }
}
