/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.controller;

import com.lazar.CMSServer.constants.Constants;
import com.lazar.CMSServer.dto.LoginUser;
import com.lazar.CMSServer.dto.UnregisteredUser;
import com.lazar.CMSServer.dto.UserDTO;
import com.lazar.CMSServer.model.User;
import com.lazar.CMSServer.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Lazar Milosavljević
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    private UserService service;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Object handleError(HttpServletRequest req, Exception ex) {
        System.out.println(ex.getMessage());
        return "{status:\"" + ex.getMessage() + "\"}";
    }

    @GetMapping("")
    public UserDTO getUser() {
        System.out.println("User access");
        User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE);
        if(user==null)
            return null;
        return new UserDTO(user);
    }
    @GetMapping("/all")
    public List<UserDTO> getAll(){
        return service.getAll();
    }
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginUser loginUser){
        System.out.println(loginUser.getUsername());
        System.out.println(loginUser.getPassword());
        User user=service.login(loginUser.getUsername(),loginUser.getPassword());
        if(user==null){
            return null;
        }
        httpSession.setAttribute(Constants.USER_ATTRIBUTE, user);
        
        return new UserDTO(user);
    }
    @PostMapping("/register")
    public Object register(@RequestBody UnregisteredUser unregisteredUser){
        User user=service.reqister(unregisteredUser);
        httpSession.setAttribute(Constants.USER_ATTRIBUTE, user);
        return new UserDTO(user);
    }
    @PostMapping("/logout")
    public Object logout(){
        httpSession.setAttribute(Constants.USER_ATTRIBUTE, null);
        return true;
    }
}
