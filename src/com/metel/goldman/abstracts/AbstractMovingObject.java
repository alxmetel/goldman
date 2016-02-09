/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.abstracts;

import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.gameobjects.MovingObject;
import com.metel.goldman.objects.Coordinate;

/**
 *
 * @author Metel
 * Класс, который отвечает за любой движущийся объект, наследуется от класса
 * AbstractGameObject с добавлением функций движения
 */

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {

    public abstract void changeIcon(MovingDirection direction);
    
    private int step = 1;// по-умолчанию у всех объектов шаг равен 1

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    
    protected void actionBeforeMove(MovingDirection direction) {

        // при движении объект должен сменить иконку и произвести звук
        changeIcon(direction);
        // playSound(); на будушее
    }

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        actionBeforeMove(direction);
        return doAction(gameObject);
    }

    public ActionResult doAction(AbstractGameObject gameObject) {

        if (gameObject == null) { // край карты
            return ActionResult.NO_ACTION;
        }

        switch (gameObject.getType()) {

            case NOTHING: {
                return ActionResult.MOVE;
            }
        }

        return ActionResult.NO_ACTION;
    }
}