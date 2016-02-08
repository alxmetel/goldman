/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.creators;

import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.objects.Coordinate;
import com.metel.goldman.objects.Exit;
import com.metel.goldman.objects.GoldMan;
import com.metel.goldman.objects.Monster;
import com.metel.goldman.objects.Nothing;
import com.metel.goldman.objects.Treasure;
import com.metel.goldman.objects.Wall;

/**
 *
 * @author Metel
 */

public class GameObjectCreator {
    
    private static GameObjectCreator instance;
    
    public static GameObjectCreator getInstance() {
        if(instance == null) {
            instance = new GameObjectCreator();
        }
        return instance;
    }

    private GameObjectCreator() {
    }
    
    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        
        AbstractGameObject obj = null;
        
        switch (type) {
                case NOTHING: {
                    obj = new Nothing(coordinate);
                    break;
                }
                
                case EXIT: {
                    obj = new Exit(coordinate);
                    break;
                }
                
                case GOLDMAN: {
                    obj = new GoldMan(coordinate);
                    break;
                }
                
                case MONSTER: {
                    obj = new Monster(coordinate);
                    break;
                }
                
                case TREASURE: {
                    obj = new Treasure(coordinate);
                    break;
                }
                
                case WALL: {
                    obj = new Wall(coordinate);
                    break;
                }
                
                default:
                    throw new IllegalArgumentException("Can't create object type: " + type);
            }
        return obj;
    }
}
