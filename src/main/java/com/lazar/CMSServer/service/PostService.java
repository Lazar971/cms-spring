/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.service;

import com.lazar.CMSServer.dto.CommentDTO;
import com.lazar.CMSServer.dto.DeleteStatus;
import com.lazar.CMSServer.dto.PostDTO;
import com.lazar.CMSServer.model.Comment;
import com.lazar.CMSServer.model.CommentPK;
import com.lazar.CMSServer.model.Post;
import com.lazar.CMSServer.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lazar.CMSServer.repository.PostRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Lazar Milosavljević
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<PostDTO> getAll() {

        List<Post> posts = postRepository.findAll();
        System.out.println(posts.size());
        return posts.stream().map((Post p) -> {
            return new PostDTO(p);
        }).collect(Collectors.toList());

    }

    public PostDTO getOne(int id) {
        return new PostDTO(postRepository.getOne(id));

    }

    public PostDTO create(Post post) {

        post.setPostId(null);
        post = postRepository.save(post);
        return new PostDTO(post);
    }

    public PostDTO update(int id, Post post) {

        Post oldPost = postRepository.getOne(id);
        if (oldPost == null) {
            return null;
        }
        post.setPostId(id);
        post.setAuthor(oldPost.getAuthor());
        Post newPost = postRepository.save(post);

        return new PostDTO(newPost);
    }

    public DeleteStatus delete(int id) {
        Post oldPost = postRepository.getOne(id);
        if (oldPost == null) {
            return new DeleteStatus("post doesn't exist");
        }
        postRepository.delete(oldPost);
        return new DeleteStatus("success");
    }

    public List<CommentDTO> getAllComments(Integer id) {
        Post oldPost = postRepository.getOne(id);
        if (oldPost == null) {
            return null;
        }
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> cdtos = new ArrayList<>();

        for (Comment comment : comments) {
            if (comment.getCommentPK().getPost() == id) {

                cdtos.add(new CommentDTO(comment));
            }
        }
        System.out.println("Done");
        System.out.println(cdtos.size());
        return cdtos;

    }

    public CommentDTO createComment(int id, Comment comment) {
        Post oldPost = postRepository.getOne(id);
        if (oldPost == null) {
            return null;
        }
       
        
        comment.setPost1(oldPost);
        comment.setCommentPK(new CommentPK(0, id));
        System.out.println("Updated");
        System.out.println(comment);
        Comment newComment=commentRepository.save(comment);
        List<Comment> comments=commentRepository.findAll(Sort.sort(Comment.class));
        System.out.println(comments.get(0));
        System.out.println(comments.get(comments.size()-1));
        newComment=comments.get(comments.size()-1);
        if(newComment==null){
            return null;
        }
        return new CommentDTO(newComment);

    }

    public DeleteStatus deleteComment(int id, int commentId) {
        CommentPK commentPK = new CommentPK(commentId, id);
        Post oldPost = postRepository.getOne(id);
        if (oldPost == null) {
            return new DeleteStatus("Post doesn't exist");
        }
        Comment comment = commentRepository.getOne(commentPK);
        if (comment == null) {
            return new DeleteStatus("Comment doesn't exist");
        }
        commentRepository.delete(comment);
        return new DeleteStatus("deleted");

    }

    
}
