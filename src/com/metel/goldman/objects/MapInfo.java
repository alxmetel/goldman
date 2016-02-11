/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects;

/**
 *
 * @author Metel
 */
public class MapInfo {
    
    private User user = new User();

    private int id;
    private String mapName;
    private String value;
    private int levelId;
    private int turnsLimit;
    private int height;
    private int width;
    private boolean exitExist;
    private boolean goldManExist;

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getTurnsLimit() {
        return turnsLimit;
    }

    public void setTurnsLimit(int turnsLimit) {
        this.turnsLimit = turnsLimit;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isExitExist() {
        return exitExist;
    }

    public void setExitExist(boolean exitExist) {
        this.exitExist = exitExist;
    }

    public boolean isGoldManExist() {
        return goldManExist;
    }

    public void setGoldManExist(boolean goldManExist) {
        this.goldManExist = goldManExist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}