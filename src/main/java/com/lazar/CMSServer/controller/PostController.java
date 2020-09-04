/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.controller;

import com.lazar.CMSServer.constants.Constants;
import com.lazar.CMSServer.dto.CommentDTO;
import com.lazar.CMSServer.dto.DeleteStatus;
import com.lazar.CMSServer.dto.NewCommentDTO;
import com.lazar.CMSServer.dto.PostDTO;
import com.lazar.CMSServer.dto.NewPostDTO;
import com.lazar.CMSServer.model.Comment;
import com.lazar.CMSServer.model.Post;
import com.lazar.CMSServer.model.User;
import com.lazar.CMSServer.service.PostService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Lazar Milosavljević
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    HttpSession httpSession;

    @GetMapping
    public List<PostDTO> loadPosts() {
        return postService.getAll();
    }

    @GetMapping("{id}")
    public PostDTO loadOne(@PathVariable(value = "id") int id) {
        return postService.getOne(id);
    }

    @PostMapping
    public PostDTO create(@RequestBody NewPostDTO post) {
        System.out.println(post);
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if (user == null) {
            throw new RuntimeException("asfd");
        }
        System.out.println("Before create");
        Post p=post.fromDTO();
        p.setAuthor(user);
        return postService.create(p);
    }

    @PatchMapping("{id}")
    public DeleteStatus update(@PathVariable(value = "id") int id, @RequestBody NewPostDTO post) {
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if (user == null) {
            throw new RuntimeException("asfd");
        }
         PostDTO p= postService.update(id, post.fromDTO());

        return new DeleteStatus("ok");
        
    }
       
    @DeleteMapping("{id}")
    public DeleteStatus delete(@PathVariable(value = "id") int id) {
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if (user == null) {
            throw new RuntimeException("asfd");
        }
        return postService.delete(id);
    }

    @GetMapping(path = "/{id}/comments")
    public List<CommentDTO> getAllComments(@PathVariable("id") Integer id) {
        
        List<CommentDTO> comments= postService.getAllComments(id);
        System.out.println("Returned comments");
        System.out.println(comments.size());
        return comments;
    }

    @PostMapping(path = "/{id}/comments")
    public CommentDTO createComment(@PathVariable("id") int id, @RequestBody NewCommentDTO comment) {
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if (user == null) {
            throw new RuntimeException("asfd");
        }
        Comment com=new Comment();
        com.setUser(user);
        com.setContent(comment.getContent());
        return postService.createComment(id,com);
    }

    /**
     *
     * @param id
     * @param commentId
     * @return
     */
    @DeleteMapping(path = "{id}/comments/{comment}")
    public DeleteStatus deleteComment(@PathVariable("id") int id, @PathVariable("comment") int commentId) {
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if (user == null) {
            throw new RuntimeException("asfd");
        }
        return postService.deleteComment(id, commentId);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Object handleError(HttpServletRequest req, Exception ex) {
        System.out.println(ex.getMessage());
        return "{status:\"" + ex.getMessage() + "\"}";
    }

}
