/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.objects;

import java.io.Serializable;

/**
 *
 * @author Metel
 */
public class User implements Serializable{
    protected int id;
    protected String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
