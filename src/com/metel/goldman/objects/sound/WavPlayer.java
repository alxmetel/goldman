/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.sound;

import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.objects.listeners.MoveResultListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Metel
 */
public class WavPlayer implements MoveResultListener {
    
    public static final String WAV_DIE = "die.wav";

    @Override
    public void notifyActionResult(ActionResult actionResult, final AbstractMovingObject abstractMovingObject) {
        
        if (!(abstractMovingObject instanceof SoundObject)) {
            return;
        }


        SoundObject soundObject = (SoundObject) abstractMovingObject;

        playSound(soundObject.getSoundName(actionResult), false, true);

    }
    
    public void playSound(String name, final boolean loop) {
        playSound(name, loop, false);
    }
    
    public void playSound(String name, final boolean loop, final boolean stopPrev) {

        try {

            if (name == null) {
                return;
            }

            URL sound = this.getClass().getResource("/com/metel/goldman/sounds/" + name);

            final AudioInputStream ais = AudioSystem.getAudioInputStream(sound);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {

                        Clip clip = AudioSystem.getClip();

                        clip.open(ais);

                        if (loop) {
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else {
                            clip.start();
                        }
                        
                        clip.stop();
                    } catch (IOException ex) {
                        Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (ais != null) {
                            try {
                                ais.close();
                            } catch (IOException ex) {
                                Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                }
            });


        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
