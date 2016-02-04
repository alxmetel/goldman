/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.game.enums;

import java.io.Serializable;

/**
 *
 * @author Metel
 */

//Типы объектов, которые участвуют в игре

public enum GameObjectType implements Serializable {
    
    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDMAN(1),
    NOTHING(-1);
    
    private GameObjectType(int indexPriority) {
        this.indexPriority = indexPriority;
    }
private int indexPriority; //индекс для приоритета показа на карте, если несколько объектов окажутся в одном квадрате

    public int getIndexPriority() {
        return indexPriority;
    }
}
