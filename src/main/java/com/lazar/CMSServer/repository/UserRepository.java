/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.repository;

import com.lazar.CMSServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lazar Milosavljević
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u WHERE u.username=?1 and u.password=?2")
    User login(String username,String password);
}
