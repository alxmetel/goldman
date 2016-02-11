/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gamemap.loader.interfaces;

import com.metel.goldman.objects.MapInfo;
import com.metel.goldman.objects.SavedMapInfo;
import com.metel.goldman.objects.User;
import java.util.ArrayList;

/**
 *
 * @author Metel
 */
public interface MapLoader{
    
    boolean saveMap(SavedMapInfo mapInfo);
    
    boolean loadMap(MapInfo mapInfo);

    ArrayList<SavedMapInfo> getSavedMapList(User user);   
    
    boolean deleteSavedMap(MapInfo mapInfo);
}