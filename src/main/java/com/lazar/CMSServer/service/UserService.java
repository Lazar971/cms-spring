/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.service;

import com.lazar.CMSServer.dto.UnregisteredUser;
import com.lazar.CMSServer.dto.UserDTO;
import com.lazar.CMSServer.model.User;
import com.lazar.CMSServer.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lazar Milosavljević
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User login(String username, String password) {
        
        User user=repository.login(username, password);
        System.out.println(user);
        return user;
    }

    public User reqister(UnregisteredUser unregisteredUser) {
        
        User existing=repository.login(unregisteredUser.getUsername(), unregisteredUser.getPassword());
        if(existing!=null){
            return null;
        }
        User user=new User(null, unregisteredUser.getFirstName(), unregisteredUser.getLastName(), unregisteredUser.getAge(), unregisteredUser.getUsername(), unregisteredUser.getPassword());
        user=repository.save(user);
        
        return user;
    }

    public List<UserDTO> getAll() {
        return repository.findAll().stream().map((User e)->{
            return new UserDTO(e);
        }).collect(Collectors.toList());
    }

}
