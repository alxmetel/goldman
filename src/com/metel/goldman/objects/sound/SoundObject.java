/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.sound;

import com.metel.goldman.enums.ActionResult;

/**
 *
 * @author Metel
 */
public interface SoundObject {
    
    String getSoundPath(ActionResult actionResult);
    
}