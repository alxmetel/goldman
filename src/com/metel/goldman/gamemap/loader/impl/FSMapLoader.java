/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gamemap.loader.impl;

import com.metel.goldman.gamemap.abstracts.AbstractGameMap;
import com.metel.goldman.gamemap.loader.abstracts.AbstractMapLoader;
import com.metel.goldman.gameobjects.impl.Coordinate;
import com.metel.goldman.objects.MapInfo;
import com.metel.goldman.objects.SavedMapInfo;
import com.metel.goldman.objects.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Metel
 */
public class FSMapLoader extends AbstractMapLoader {
    private static final String SAVE_EXTENSION = ".sav";

    public FSMapLoader(AbstractGameMap gameMap) {
        super(gameMap);
    }


    @Override
    public boolean loadMap(MapInfo mapInfo) {
        File file = new File("game.map");
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty!");
        }

        try {
            gameMap.getGameCollection().clear();
            
            gameMap.getMapInfo().setExitExist(false);
            gameMap.getMapInfo().setGoldManExist(false);

            gameMap.getMapInfo().setHeight(getLineCount(file));

            BufferedReader br = new BufferedReader(new FileReader(file));

            String strLine = br.readLine().trim(); // считываем первую строку для определения имени, длины, ширины карты. убираем пробела по краям

            // разбиваем первую строку на токены, разделенные запятой.            
            gameMap.getMapInfo().setMapName(strLine.split(",")[0]);

            gameMap.getMapInfo().setTurnsLimit(Integer.valueOf(strLine.split(",")[1]).intValue());
            gameMap.getMapInfo().setWidth(Integer.valueOf(strLine.split(",")[2]).intValue());

            int y = 0; // номер строки в массиве
            int x = 0; // номер столбца в массиве

            while ((strLine = br.readLine()) != null) {
                x = 0; // чтобы каждый раз с первого столбца начинал

                for (String str : strLine.split(",")) {
                    // вытаскивать все значения в строке между запятыми, чтобы заполнить карту элементами

                    createGameObject(str, new Coordinate(x, y));
                    x++;
                }
                y++;
            }

            if (!gameMap.isValidMap()) {
                throw new Exception("The map is not valid!");
            }

        } catch (Exception ex) {
            Logger.getLogger(FSMapLoader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


        return true;

    }

  

    @Override
    public boolean saveMap(SavedMapInfo mapInfo) {

        File f = new File("save");

        if (!f.exists()) {
            f.mkdir();
        }

        try {
            FileOutputStream fos = new FileOutputStream(f.getAbsoluteFile() + "/" + mapInfo.getUser().getUsername()+"_"+new Date().getTime()+SAVE_EXTENSION);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(FSMapLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;
        try {
            reader = new BufferedReader(new FileReader(file));

            while (reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1;// lineNumber-1 потому что первая строка из файла не входит в карту
        } catch (IOException ex) {
            Logger.getLogger(FSMapLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FSMapLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lineCount;

    }

    @Override
    public ArrayList<SavedMapInfo> getSavedMapList(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteSavedMap(MapInfo mapInfo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
   
}
