/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.movestrategies;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.gamemap.collections.GameCollection;
import java.util.Random;

/**
 *
 * @author Metel
 */
public class AgressiveMoving implements MoveStrategy {
    
    private MovingDirection[] directions = MovingDirection.values();
    private AbstractMovingObject movingObject;
    private GameCollection gameCollection;

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection) {

        this.movingObject = movingObject;
        this.gameCollection = gameCollection;

        // сначала ищем вокруг, можно ли съесть игрока
        MovingDirection direction = searchAction(ActionResult.DIE, false);

        // если нет рядом персонажа - просто двигаемся в случайном направлении
        if (direction == null) {
            direction = searchAction(ActionResult.MOVE, true);
        }

        return direction;
    }

    private MovingDirection getRandomDirection() {
        return directions[new Random().nextInt(directions.length)];
    }

    private MovingDirection searchAction(ActionResult actionResult, boolean random) {
        MovingDirection direction = null;

        if (random) {
            do {
                direction = getRandomDirection();
            } while (!checkActionResult(actionResult, direction));// случайно подбирать сторону пока не найдем нужный ActionResult
        }else{
            for (MovingDirection movingDirection : directions) {// искать по всем 4 сторонам
                if (checkActionResult(actionResult, movingDirection)){
                    direction = movingDirection;
                    break;
                }
            }
        }
        return direction;
    }
    
    private boolean checkActionResult(ActionResult actionResult, MovingDirection direction){
        AbstractGameObject objectInNewCoordinate = gameCollection.getObjectByCoordinate(movingObject.getDirectionCoordinate(direction));     
        return movingObject.doAction(objectInNewCoordinate).equals(actionResult);
    }
}
