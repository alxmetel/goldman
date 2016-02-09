/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.interfaces.gameobjects;

import com.metel.goldman.abstracts.AbstractGameMap;
import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.MovingDirection;

/**
 *
 * @author Metel
 * Поведение для всех движущихся объектов
 */

public interface MovingObject extends StaticObject{
    
    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject);
    
    int getStep();
   
}