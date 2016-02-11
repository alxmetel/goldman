/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.listeners.interfaces;

import com.metel.goldman.gameobjects.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;

/**
 *
 * @author Metel
 */
public interface MoveResultListener {
    
     public void notifyActionResult(ActionResult actionResult, AbstractMovingObject abstractMovingObject);

}
