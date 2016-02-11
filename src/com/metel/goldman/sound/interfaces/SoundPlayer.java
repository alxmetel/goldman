/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.sound.interfaces;

import javax.sound.sampled.Clip;

/**
 *
 * @author Metel
 */
public interface SoundPlayer {

    void startBackgroundMusic(String soundName);

    void stopBackgoundMusic();

    void playSound(Clip clip, boolean loop);
   
}
