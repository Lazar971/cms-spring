/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.dto.PostCategoryDTO;
import com.lazar.CMSServer.model.Post;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class NewPostDTO implements Serializable{
    
    private String title;
    private PostCategoryDTO category;
    private String description;

    public NewPostDTO() {
    }

    public NewPostDTO(String title, PostCategoryDTO cat, String desc) {
        this.title = title;
        this.category = cat;
        this.description = desc;
    }
    public Post fromDTO(){
        Post p= new Post(null, title, description);
        p.setCategory(category.fromDTO());
        return p;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(PostCategoryDTO category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public String toString() {
        return "NewPostDTO{" + "title=" + title + ", cat=" + category.getId() + ", desc=" + description + '}';
    }
    
    
}
