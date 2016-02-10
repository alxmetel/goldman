/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.sound;

/**
 *
 * @author Metel
 */
public interface SoundPlayer {
    
    void startBackgroundMusic(String soundName);

    void stopBackgoundMusic();

    void playSound(String name, final boolean loop);
    
}
