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
@Table(name = "user_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserCategory.findAll", query = "SELECT u FROM UserCategory u"),
    @NamedQuery(name = "UserCategory.findByUserCategoryId", query = "SELECT u FROM UserCategory u WHERE u.userCategoryId = :userCategoryId"),
    @NamedQuery(name = "UserCategory.findByValue", query = "SELECT u FROM UserCategory u WHERE u.value = :value")})
public class UserCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_category_id")
    private Integer userCategoryId;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    

    public UserCategory() {
    }

    public UserCategory(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public UserCategory(Integer userCategoryId, String value) {
        this.userCategoryId = userCategoryId;
        this.value = value;
    }

    public Integer getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
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
        hash += (userCategoryId != null ? userCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCategory)) {
            return false;
        }
        UserCategory other = (UserCategory) object;
        if ((this.userCategoryId == null && other.userCategoryId != null) || (this.userCategoryId != null && !this.userCategoryId.equals(other.userCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lazar.CMSServer.model.UserCategory[ userCategoryId=" + userCategoryId + " ]";
    }
    
}
