/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gamemap.collections;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.movestrategies.MoveStrategy;
import com.metel.goldman.objects.Coordinate;
import com.metel.goldman.objects.listeners.MoveResultNotifier;
import java.util.List;

/**
 *
 * @author Metel
 */
public interface GameCollection extends MoveResultNotifier{
    
    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);
    
    AbstractGameObject getObjectByCoordinate(int x, int y);
    
    void addGameObject(AbstractGameObject gameObject);
    
    List<AbstractGameObject> getAllGameObjects();
    
    List<AbstractGameObject> getGameObjects(GameObjectType type);
    
    void moveObject(MovingDirection direction, GameObjectType gameObjectType);
    
    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);
}
