/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.repository;

import com.lazar.CMSServer.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lazar Milosavljević
 */
@Repository
public interface PostCategorRepository extends JpaRepository<PostCategory, Integer> {
    
}
