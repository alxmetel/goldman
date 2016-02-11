/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gamemap.abstracts;

import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;
import com.metel.goldman.collections.interfaces.GameCollection;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.metel.goldman.gamemap.interfaces.TimeMap;
import com.metel.goldman.objects.MapInfo;

/**
 *
 * @author Metel
 * Базовая карта без конкретного отображения
 */
public abstract class AbstractGameMap implements TimeMap, Serializable {

    private static final long serialVersionUID = 1L;
    protected GameCollection gameCollection;
    protected MapInfo mapInfo = new MapInfo();

    public AbstractGameMap() {
    }

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public MapInfo getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(MapInfo mapInfo) {
        this.mapInfo = mapInfo;
    }

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        // приоритет объекта зависит от номера индекса объекта enum
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject;
    }

    public boolean isValidMap() {
        return mapInfo.isGoldManExist() && mapInfo.isExitExist(); // если есть и вход и выход - карта валидна
    }

    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }
}