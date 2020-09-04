/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Lazar Milosavljević
 */
@Embeddable
public class CommentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "comment_id")
    
    private int commentId;
    @Basic(optional = false)
    @Column(name = "post")
    private int post;

    public CommentPK() {
    }

    public CommentPK(int commentId, int post) {
        this.commentId = commentId;
        this.post = post;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) commentId;
        hash += (int) post;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (this.post != other.post) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lazar.CMSServer.model.CommentPK[ commentId=" + commentId + ", post=" + post + " ]";
    }

}
