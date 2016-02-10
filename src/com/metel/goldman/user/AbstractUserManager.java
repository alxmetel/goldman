/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.user;

/**
 *
 * @author Metel
 */
public abstract class AbstractUserManager implements UserManager {
    
    protected User user;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void createNewUser(String name) {
        user = new User(name);
    }
}