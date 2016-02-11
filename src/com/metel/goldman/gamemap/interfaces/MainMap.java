/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gamemap.interfaces;

import com.metel.goldman.collections.interfaces.GameCollection;
import com.metel.goldman.objects.MapInfo;

/**
 *
 * @author Metel
 * Интерфейс для игровой карты
 */
public interface MainMap {

    MapInfo getMapInfo();
    
    GameCollection getGameCollection();// все карты должн хранить коллекцию объектов
   
}
