/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.model.User;

/**
 *
 * @author Lazar Milosavljević
 */
public class UnregisteredUser extends UserDTO{
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User fromDTO() {
        User user= super.fromDTO(); //To change body of generated methods, choose Tools | Templates.
        user.setPassword(password);
        return user;
    }
    
    
    
}
