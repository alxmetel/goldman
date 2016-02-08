/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.abstracts;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.interfaces.gamemap.GameMap;
import com.metel.goldman.objects.Coordinate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 * @author Metel
 * Базовая карта без конкретного отображения
 */
public abstract class AbstractGameMap implements GameMap, Serializable { //Serializable нужен для сериализации (сохранения)объекта карты, чтобы можно было сохранять игру и восстанавливать
    
    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private int timeLimit;
    private String name;
    private boolean exitExist;
    private boolean goldManExist;
    
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>(); //хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); //хранит список объектов для каждоготипа

    public void addGameObject(AbstractGameObject gameObject) {
        
        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());
        
        if(tmpList == null) {
            tmpList = new ArrayList();
        }
        
        tmpList.add(gameObject);
        
        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);
    }
    
    public boolean isExitExist() {
        return exitExist;
    }

    public void setExitExist(boolean isExitExist) {
        this.exitExist = isExitExist;
    }
    
    public boolean isGoldManExist() {
        return goldManExist;
    }

    public void setGoldManExist(boolean isGoldManExist) {
        this.goldManExist = isGoldManExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
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
        return goldManExist && exitExist; //если есть и входи выход, карта валидна
    }
    
    public ArrayList<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }
    
    public Collection<AbstractGameObject> getAllGameObjects() {
        return gameObjects.values();
    }
    
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }
    
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate (x, y));
    }
}

