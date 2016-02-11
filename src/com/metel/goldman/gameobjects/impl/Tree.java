/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gameobjects.impl;

import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.gameobjects.abstracts.AbstractGameObject;

/**
 *
 * @author Metel
 */
public class Tree extends AbstractGameObject {
    
    public Tree(Coordinate coordinate) {
        super.setType(GameObjectType.TREE);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/com/metel/goldman/images/tree.jpg"));
    }
}
