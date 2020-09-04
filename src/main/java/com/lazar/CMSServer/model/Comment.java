/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lazar Milosavljević
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentPK.commentId = :commentId"),
    @NamedQuery(name = "Comment.findByPost", query = "SELECT c FROM Comment c WHERE c.commentPK.post = :post")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentPK commentPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    
    @JoinColumn(name = "post", referencedColumnName = "post_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Post post1;
    
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public Comment(CommentPK commentPK, String content) {
        this.commentPK = commentPK;
        this.content = content;
    }

   
    
    public Comment(int commentId, int post) {
        this.commentPK = new CommentPK(commentId, post);
    }

    public CommentPK getCommentPK() {
        return commentPK;
    }

    public void setCommentPK(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost1() {
        return post1;
    }

    public void setPost1(Post post1) {
        this.post1 = post1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentPK != null ? commentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentPK == null && other.commentPK != null) || (this.commentPK != null && !this.commentPK.equals(other.commentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lazar.CMSServer.model.Comment[ commentPK=" + commentPK + " ]";
    }
    
}
