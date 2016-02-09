/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.listeners;

import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.objects.GoldMan;
import java.util.List;

/**
 *
 * @author Metel
 */
public interface MoveResultNotifier {
    
    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    public void removeMoveListener(MoveResultListener listener);

    public void removeAllLMoveisteners();

    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan);
}
