/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces;

/**
 *
 * @author Metel
 * Интерфейс для игровой карты
 */
public interface GameMap {
    
    int getHeight();
    int getWidth();
    boolean loadMap();
    boolean saveMap();
    boolean drawMap();
    int getTimeLimit();
}
