/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gamemap.interfaces;

import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;
import java.awt.Component;

/**
 *
 * @author Metel
 * Интерфейс для отображения игровой карты
 */
public interface DrawableMap extends MainMap{
    
    Component getMapComponent();
    
    boolean updateMap();
    
    void updateMapObjects(AbstractGameObject obj1, AbstractGameObject obj2);
}
