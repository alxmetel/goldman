/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.creators;

import com.metel.goldman.gamemap.abstracts.AbstractGameMap;
import com.metel.goldman.enums.LocationType;
import com.metel.goldman.gamemap.loader.impl.DBMapLoader;
import com.metel.goldman.gamemap.loader.impl.FSMapLoader;
import com.metel.goldman.gamemap.loader.interfaces.MapLoader;

/**
 *
 * @author Metel
 */
public class MapLoaderCreator {

    private static MapLoaderCreator instance;

    public static MapLoaderCreator getInstance() {
        if (instance == null) {
            instance = new MapLoaderCreator();
        }
        return instance;
    }

    public MapLoader createMapLoader(LocationType type, AbstractGameMap gameMap) {
        MapLoader obj = null;

        switch (type) {
            case FS: {
                obj = new FSMapLoader(gameMap);
                break;
            }
            case DB: {
                obj = new DBMapLoader(gameMap);
                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);
        }
        return obj;
    }
}