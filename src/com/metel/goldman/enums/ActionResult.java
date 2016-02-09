/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.enums;

/**
 *
 * @author Metel
 * типы действий, которые могут произойти после движения игрока по карте
 */
public enum ActionResult {
    
    NO_ACTION,// ничего не происходит
    DIE,// игрок умирает
    WIN,// игрок выиграл
    MOVE,// движение игрока
    COLLECT_TREASURE// собрал золото
    
}
