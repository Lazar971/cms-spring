/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.model.Post;
import com.lazar.CMSServer.model.PostCategory;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class PostDTO implements Serializable{

    private Integer id;
    private String title;
    private String description;
    private UserDTO author;
    private PostCategoryDTO category;

    public PostDTO(Integer postId, String title, String description, UserDTO author, PostCategory category) {
        this.id = postId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = new PostCategoryDTO(category);
    }

    public PostDTO() {
    }

    public PostDTO(Post post) {
        this.id=post.getPostId();
        this.author=new UserDTO(post.getAuthor());
        this.title=post.getTitle();
        this.description=post.getDescription();
        this.category=new PostCategoryDTO(post.getCategory());
    }
    public Post fromDTO(){
        Post post= new Post(id, title, description);
        post.setAuthor(author.fromDTO());
        post.setCategory(category.fromDTO());
        return post;
        
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public PostCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(PostCategoryDTO category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
