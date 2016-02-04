/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects.game.common;

import java.io.Serializable;

/**
 *
 * @author Metel
 */

// Класс работает с координатами объекта. Каждый объект в игре имеет свои
// координаты

public class Coordinate implements Serializable {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate objCoord = (Coordinate) obj;
        return (x == objCoord.getX() && y == objCoord.getY());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}