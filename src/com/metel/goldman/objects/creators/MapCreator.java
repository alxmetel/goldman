/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.creators;

import com.metel.goldman.abstracts.AbstractGameMap;
import com.metel.goldman.enums.LocationType;
import com.metel.goldman.interfaces.collections.GameCollection;
import com.metel.goldman.objects.maps.FSGameMap;

/**
 *
 * @author Metel
 */
public class MapCreator {

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type, GameCollection collection) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap(collection);
                break;
            }
            case DB: {
                
                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);
        }

        return obj;
    }
}