/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

/**
 *
 * @author Lazar Milosavljević
 */
public class NewCommentDTO {
    
    private String content;

    public NewCommentDTO() {
    }

    public NewCommentDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
