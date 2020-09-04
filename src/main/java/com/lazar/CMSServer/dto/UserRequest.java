/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.dto.UnregisteredUser;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class UserRequest implements Serializable{
    private String action;
    
    private UnregisteredUser user;

    public UserRequest(String action, UnregisteredUser user) {
        this.action = action;
        this.user = user;
    }

    public UserRequest() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public UnregisteredUser getUser() {
        return user;
    }

    public void setUser(UnregisteredUser user) {
        this.user = user;
    }
    
    
}
