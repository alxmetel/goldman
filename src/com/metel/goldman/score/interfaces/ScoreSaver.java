/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.score.interfaces;

import com.metel.goldman.objects.UserScore;
import java.util.ArrayList;

/**
 *
 * @author Metel
 */
public interface ScoreSaver{
    
    boolean saveScore(UserScore userScore);

    ArrayList<UserScore> getScoreList();   
}