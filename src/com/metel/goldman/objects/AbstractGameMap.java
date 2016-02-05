/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.interfaces.GameMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 * @author Metel
 * Базовая карта без конкретного отображения
 */
public abstract class AbstractGameMap implements GameMap, Serializable { //Serializable нужен для сериализации (сохранения)объекта карты, чтобы можно было сохранять игру и восстанавливать
    
    private static final long serialVersioUID = 1L;
    private int width;
    private int height;
    private int timeLimit;
    private boolean isExitExist;
    private boolean isGoldManExist;
    
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>(); //хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); //хранит список объектов для каждоготипа

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
    
    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        //приоритет объекта зависит от номера индекса объекта enum
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject;
    }
    
    public boolean isValidMap() {
        return isGoldManExist && isExitExist; //если есть и входи выход, карта валидна
    }
    
    public ArrayList<AbstractGameObject> getList(GameObjectType type) {
        return typeObjects.get(type);
    }
    
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }
    
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate (x, y));
    }
}

