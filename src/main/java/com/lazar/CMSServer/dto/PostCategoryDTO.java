/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.model.PostCategory;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class PostCategoryDTO implements Serializable{

    private Integer id;
    private String value;

    public PostCategoryDTO() {
    }

    public PostCategoryDTO(PostCategory postCategory) {
        id=postCategory.getPostCategoryId();
        value=postCategory.getValue();
    }

    public PostCategoryDTO(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
    public PostCategory fromDTO(){
        return new PostCategory(id, value);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
