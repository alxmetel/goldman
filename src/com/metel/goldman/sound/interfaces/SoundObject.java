/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.sound.interfaces;

import com.metel.goldman.enums.ActionResult;
import javax.sound.sampled.Clip;

/**
 *
 * @author Metel
 */
public interface SoundObject {

    Clip getSoundClip(ActionResult actionResult);
    
}
