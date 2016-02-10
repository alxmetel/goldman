 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gamemap.collections;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.movestrategies.MoveStrategy;
import com.metel.goldman.objects.Coordinate;
import com.metel.goldman.objects.GoldMan;
import com.metel.goldman.objects.Nothing;
import com.metel.goldman.objects.Wall;
import com.metel.goldman.objects.listeners.MapListenersRegistrator;
import com.metel.goldman.objects.listeners.MoveResultListener;
import com.metel.goldman.objects.sound.WavPlayer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Metel
 */
public class MapCollection extends MapListenersRegistrator {// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа    

    public MapCollection() {
        addMoveListener(new WavPlayer());
    }
    
    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());// ! узкое место - каждый раз создается новая коллекция
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        AbstractGameObject gameObject = gameObjects.get(coordinate);
        if (gameObject == null){// край карты
            gameObject = new Wall(coordinate);
        }
        return gameObject;
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

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);// движение по направлению (без стратегии)
    }
    
    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);// движение по стратегии
    }
    
    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy){
          GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;

        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                        
                if (moveStrategy!=null){// если указана стратегия движения - то берем наравления оттуда
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
                        swapObjects(movingObject, new Nothing(newCoordinate));
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }

            }

            notifyMoveListeners(actionResult, goldMan);
        }
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        swapCoordinates(obj1, obj2);

        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);
    }

    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

    @Override
    public void notifyMoveListeners(ActionResult actionResult, AbstractMovingObject movingObject) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, movingObject);
        }
    }
}
