/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gameobjects.interfaces;

import com.metel.goldman.gameobjects.impl.Coordinate;
import com.metel.goldman.enums.GameObjectType;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Поведение для всех статичных объектов
 */

public interface StaticObject {
 
    // объект должен иметь иконку
    ImageIcon getIcon();

    // координаты
    Coordinate getCoordinate();

    // тип объекта
    GameObjectType getType();
}