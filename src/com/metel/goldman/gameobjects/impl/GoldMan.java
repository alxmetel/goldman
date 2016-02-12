/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gameobjects.impl;

import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.gameobjects.abstracts.AbstractSoundObject;
import com.metel.goldman.sound.impl.WavPlayer;
import javax.sound.sampled.Clip;

/**
 *
 * @author Metel
 * Класс отвечает за работу объекта GOLDMAN - главный персонаж игры
 */

public class GoldMan extends AbstractSoundObject {

    private int totalScore = 0;// кол-во очков, собранных игроком
    private int turnsNumber = 0;// кол-во сделанных ходов
    
    private transient Clip moveClip;
    private transient Clip treasureClip;
    private transient Clip winClip;
    private transient Clip treeClip;

    public GoldMan(Coordinate coordinate) {
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/com/metel/goldman/images/goldman_right.png"));
        
        movingImages.put(MovingDirection.UP, getImageIcon("/com/metel/goldman/images/goldman_up.png"));
        movingImages.put(MovingDirection.DOWN, getImageIcon("/com/metel/goldman/images/goldman_down.png"));
        movingImages.put(MovingDirection.LEFT, getImageIcon("/com/metel/goldman/images/goldman_left.png"));
        movingImages.put(MovingDirection.RIGHT, getImageIcon("/com/metel/goldman/images/goldman_right.png"));
    }

    public void addSTotalcore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        turnsNumber++;

        switch (gameObject.getType()) {

            case TREASURE: {
                totalScore += ((Treasure) gameObject).getScore();
                return ActionResult.COLLECT_TREASURE;
            }

            case MONSTER: {
                return ActionResult.DIE;
            }

            case EXIT: {
                totalScore *= 2;
                return ActionResult.WIN;
            }
                
            case TREE:{
                return ActionResult.HIDE_IN_TREE;
            }
        }

        return super.doAction(gameObject);
    }

    @Override
    public Clip getSoundClip(ActionResult actionResult) {

        if (moveClip ==null) {
            moveClip = openClip(WavPlayer.SOUND_MOVE);
        }
        
        if (treasureClip ==null) {
             treasureClip = openClip(WavPlayer.SOUND_TREASURE);
        }
        
        if (winClip ==null) {
            winClip = openClip(WavPlayer.SOUND_WIN);
        }
        
          if (treeClip ==null) {
            treeClip = openClip(WavPlayer.SOUND_TREE);
        }

        switch (actionResult) {
            case MOVE: {
                return moveClip;
            }                
            case HIDE_IN_TREE:{
                return treeClip;
            }
            case COLLECT_TREASURE: {
                return treasureClip;
            }
            case DIE: {
                return super.getDieClip();
            }
            case WIN: {
                return winClip;
            }
        }
        return null;
    }
}
