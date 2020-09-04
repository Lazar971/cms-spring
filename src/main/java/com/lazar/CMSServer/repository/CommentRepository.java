/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.repository;

import com.lazar.CMSServer.model.Comment;
import com.lazar.CMSServer.model.CommentPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lazar Milosavljević
 */
public interface CommentRepository extends JpaRepository<Comment, CommentPK> {
    
    
}
