/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gamemap;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.interfaces.collections.GameCollection;
import com.metel.goldman.objects.Coordinate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Metel
 */
public class MapCollection implements GameCollection {

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа    

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());
    }
    
    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);
    }
}