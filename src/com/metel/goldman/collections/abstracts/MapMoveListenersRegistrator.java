/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.collections.abstracts;

import com.metel.goldman.collections.interfaces.GameCollection;
import com.metel.goldman.listeners.interfaces.MoveResultListener;
import com.metel.goldman.listeners.interfaces.MoveResultNotifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Metel
 */
public abstract class MapMoveListenersRegistrator implements GameCollection, MoveResultNotifier{

    private ArrayList<MoveResultListener> listeners = new ArrayList<>();

    @Override
    public List<MoveResultListener> getMoveListeners() {
        return listeners;
    }

    @Override
    public void addMoveListener(MoveResultListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeMoveListener(MoveResultListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeAllLMoveisteners() {
        listeners.clear();
    }
}