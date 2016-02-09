/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.listeners;

import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.objects.GoldMan;

/**
 *
 * @author Metel
 */
public interface MoveResultListener {
    
    public void notifyActionResult(ActionResult actionResult, GoldMan goldMan);
    
}
