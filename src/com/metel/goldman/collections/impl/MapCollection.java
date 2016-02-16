 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.collections.impl;

import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;
import com.metel.goldman.gameobjects.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.movestrategies.interfaces.MoveStrategy;
import com.metel.goldman.gameobjects.impl.Coordinate;
import com.metel.goldman.gameobjects.impl.GoldMan;
import com.metel.goldman.gameobjects.impl.Nothing;
import com.metel.goldman.gameobjects.impl.Wall;
import com.metel.goldman.collections.abstracts.MapMoveListenersRegistrator;
import com.metel.goldman.listeners.interfaces.MoveResultListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Metel
 */
public class MapCollection extends MapMoveListenersRegistrator implements Serializable{// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

    private HashMap<Coordinate, ArrayList<AbstractGameObject>> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа    

    public MapCollection() {

    }

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        
        ArrayList<AbstractGameObject> list = new ArrayList<>();
        
        for(List<AbstractGameObject> tmpList : gameObjects.values()) {
            for(AbstractGameObject obj : tmpList) {
                list.add(obj);
            }
        }
        return list;
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
  
        AbstractGameObject gameObject = null;
 
        ArrayList<AbstractGameObject> list = gameObjects.get(coordinate);
        
        if (list == null) {// край карты
            return new Wall(coordinate);
        }

        for (AbstractGameObject obj : list) {
            if (gameObject == null) {
                gameObject = obj;
                continue;
            }
            if (obj.getType().getIndexPriority() > gameObject.getType().getIndexPriority()) {
                gameObject = obj;
            }
        }
        return gameObject;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return getObjectByCoordinate(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> typeList = typeObjects.get(gameObject.getType());
        ArrayList<AbstractGameObject> objList = gameObjects.get(gameObject.getCoordinate());

        if (typeList == null) {
            typeList = new ArrayList<>();
        }

        if (objList == null) {
            objList = new ArrayList<>();
        }

        typeList.add(gameObject);
        objList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), objList);
        typeObjects.put(gameObject.getType(), typeList);
    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);// движение по направлению (без стратегии)
    }

    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);// движение по стратегии
    }

    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy) {
        GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;

        if (this.getGameObjects(gameObjectType) == null) {
            return;
        }

        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                if (moveStrategy != null) {// если указана стратегия движения - то берем направления оттуда
                    direction = moveStrategy.getDirection(movingObject, goldMan, this);
                }

                Coordinate newCoordinate = movingObject.getDirectionCoordinate(direction);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);

                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        Nothing nothing = new Nothing(newCoordinate);
                        swapObjects(movingObject, nothing);
                        removeObject(objectInNewCoordinate);
                        objectInNewCoordinate = nothing;
                        break;
                    }
                    case HIDE_IN_TREE: {
                        Nothing nothing = new Nothing(newCoordinate);
                        swapObjects(movingObject, nothing);
                        objectInNewCoordinate = nothing;
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }
                if (actionResult != ActionResult.NO_ACTION) {
                    notifyMoveListeners(actionResult, movingObject, objectInNewCoordinate);
                }
            }
        }
    }
    
    private void removeObject(AbstractGameObject obj){
        gameObjects.get(obj.getCoordinate()).remove(obj);
        typeObjects.get(obj.getType()).remove(obj);
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        gameObjects.get(obj1.getCoordinate()).remove(obj1);
        gameObjects.get(obj2.getCoordinate()).remove(obj2);

        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);

        gameObjects.get(obj1.getCoordinate()).add(obj1);
        gameObjects.get(obj2.getCoordinate()).add(obj2);
    }

    @Override
    public void notifyMoveListeners(ActionResult actionResult, AbstractGameObject movingObject, AbstractGameObject targetObject) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, movingObject, targetObject);
        }
    }

    @Override
    public void clear() {
        gameObjects.clear();
        typeObjects.clear();
    }
}