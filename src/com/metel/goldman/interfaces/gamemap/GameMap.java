/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gamemap;

/**
 *
 * @author Metel
 * Интерфейс для создания игровой карты
 */
public interface GameMap {
    
    int getHeight();
    int getWidth();
    int getTimeLimit();
    boolean loadMap(Object source);
    boolean saveMap(Object source);

}
