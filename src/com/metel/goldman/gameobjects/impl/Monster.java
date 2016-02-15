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
import java.util.EnumMap;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 *
 * @author Metel
 * Класс отвечает за работу объекта MONSTER
 */

public class Monster extends AbstractSoundObject {

    protected static EnumMap<MovingDirection, ImageIcon> monsterImages = new EnumMap<>(MovingDirection.class);// карта иконок для всех направлений монстра

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/com/metel/goldman/images/monster_right.jpg"));// иконку по-умолчанию (можно сделать реализацию случайного выбора иконки)

        if (monsterImages.isEmpty()) {// для всех монстров будут одинаковые картики, поэтому нет смысла создавать для каждого объекта отдельный map
            monsterImages.put(MovingDirection.UP, getImageIcon("/com/metel/goldman/images/monster_up.jpg"));
            monsterImages.put(MovingDirection.DOWN, getImageIcon("/com/metel/goldman/images/monster_down.jpg"));
            monsterImages.put(MovingDirection.LEFT, getImageIcon("/com/metel/goldman/images/monster_left.jpg"));
            monsterImages.put(MovingDirection.RIGHT, getImageIcon("/com/metel/goldman/images/monster_right.jpg"));
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {
        
        if (gameObject == null){
            return ActionResult.NO_ACTION;
        }

        switch (gameObject.getType()) {

            case TREASURE:
            case MONSTER:
            case TREE: { // монстр не может наступать на сокровище, дерево и на других монстров
                return ActionResult.NO_ACTION;
            }

            case GOLDMAN: {
                return ActionResult.DIE;
            }
        }
        return super.doAction(gameObject);
    }

    @Override
    public Clip getSoundClip(ActionResult actionResult) {
        switch (actionResult) {
            case DIE:
                return super.getDieClip();
        }
        return null;
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        super.setIcon(monsterImages.get(direction));
    }
}