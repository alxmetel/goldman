/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.score.impl;

import com.metel.goldman.objects.UserScore;
import com.metel.goldman.score.interfaces.ScoreSaver;
import java.util.ArrayList;

/**
 *
 * @author Metel
 */
public class FSScoreSaver implements ScoreSaver{

    @Override
    public boolean saveScore(UserScore userScore) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<UserScore> getScoreList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}