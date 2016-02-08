/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.maps;

import com.metel.goldman.abstracts.AbstractGameMap;
import com.metel.goldman.abstracts.AbstractGameObject;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.objects.Coordinate;
import com.metel.goldman.objects.creators.GameObjectCreator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Metel
 */
public class FSGameMap extends AbstractGameMap {

    @Override
    public boolean loadMap(Object source) {
        
        File file = new File(source.toString());
        
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty!");
        }
        
        try {
            setExitExist(false);
            setGoldManExist(false);
            
            setHeight(getLineCount(file)); //высота карты. Вычисляется из количества строк внутри файла
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String strLine = br.readLine().trim(); //считываем первую строку для определения имени, длины, ширины карты, убираем пробелы по краям
            
            //разбиваем первую строку на токены, разделенные запятой
            setName(strLine.split(",") [0]);
            
            setTimeLimit(Integer.valueOf(strLine.split(",")[1]).intValue());
            setWidth(Integer.valueOf(strLine.split(",")[2]).intValue());
            
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
            
            if (!isValidMap()) {
                throw new Exception("The map is not valid!");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
    private void createGameObject(String str, Coordinate coordinate) {
        
        GameObjectType type = GameObjectType.valueOf(str.toUpperCase()); //определяем тип объекта

        AbstractGameObject newObj = GameObjectCreator.getInstance().createObject(type, coordinate); //создаем объект

        addGameObject(newObj); // добавляем созданный объект

        if (newObj.getType() == GameObjectType.EXIT) {
            setExitExist(true);
        } else if (newObj.getType() == GameObjectType.GOLDMAN) {
            setGoldManExist(true);
        }
    }
    
    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;
        try{
            reader = new BufferedReader(new FileReader(file));
            
            while(reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1; // lineCount-1 потому что первая строка из файла не входит в карту
        }catch(IOException ex) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                reader.close();
            }catch(IOException ex) {
                Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lineCount;
    }

    @Override
    public boolean saveMap(Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
