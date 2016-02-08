/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;

/**
 *
 * @author Metel
 * Класс отвечает за работу объекта GOLDMAN - главный персонаж игры
 */

public class GoldMan extends AbstractMovingObject {
    
    private int totalScore = 0; //кол-во очков, собранных игроком
    private int turnsNumber = 0; //кол-во сделанных ходов
    
    public GoldMan(Coordinate coordinate) {
        
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);
        
        super.setIconDown(getImageIcon("/com/metel/goldman/images/goldman_down.png"));
        super.setIconLeft(getImageIcon("/com/metel/goldman/images/goldman_left.png"));
        super.setIconUp(getImageIcon("/com/metel/goldman/images/goldman_up.png"));
        super.setIconRight(getImageIcon("/com/metel/goldman/images/goldman_right.png"));
        
        super.setIcon(super.getIconUp());
    }
    
    public void addTotalScore(int score) {
        this.totalScore += score;
    }
    
    public int getTotalScore() {
        return totalScore;
    }
    
    public int getTurnsNumber() {
        return turnsNumber;
    }
    
    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
