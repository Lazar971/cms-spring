/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lazar Milosavljević
 */
@Entity
@Table(name = "post_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostCategory.findAll", query = "SELECT p FROM PostCategory p"),
    @NamedQuery(name = "PostCategory.findByPostCategoryId", query = "SELECT p FROM PostCategory p WHERE p.postCategoryId = :postCategoryId"),
    @NamedQuery(name = "PostCategory.findByValue", query = "SELECT p FROM PostCategory p WHERE p.value = :value")})
public class PostCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_category_id")
    private Integer postCategoryId;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    

    public PostCategory() {
    }

    public PostCategory(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public PostCategory(Integer postCategoryId, String value) {
        this.postCategoryId = postCategoryId;
        this.value = value;
    }

    public Integer getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postCategoryId != null ? postCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostCategory)) {
            return false;
        }
        PostCategory other = (PostCategory) object;
        if ((this.postCategoryId == null && other.postCategoryId != null) || (this.postCategoryId != null && !this.postCategoryId.equals(other.postCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lazar.CMSServer.model.PostCategory[ postCategoryId=" + postCategoryId + " ]";
    }
    
}
