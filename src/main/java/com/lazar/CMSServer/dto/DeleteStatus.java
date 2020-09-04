/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class DeleteStatus implements  Serializable{
    
    private String status;

    public DeleteStatus() {
    }

    public DeleteStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
