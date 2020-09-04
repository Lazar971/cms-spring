/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.model.CommentPK;
import com.lazar.CMSServer.model.Comment;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class CommentDTO implements Serializable{

    private String content;
    private int id;
    private PostDTO post;
    private UserDTO user;

    public CommentDTO() {
    }

    public CommentDTO(Comment comment) {
        id=comment.getCommentPK().getCommentId();
        content=comment.getContent();
        post=new PostDTO(comment.getPost1());
        user=new UserDTO(comment.getUser());
    }

    public CommentDTO(String content, int id, PostDTO post, UserDTO user) {
        this.content = content;
        this.id = id;
        this.post = post;
        this.user = user;
    }
 public Comment fromDTO(){
        Comment comment=new Comment(new CommentPK(id, post.getId()), content);
        comment.setUser(user.fromDTO());
        
        return comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

   
 
 
}
