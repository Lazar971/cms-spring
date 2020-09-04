/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.dto;

import com.lazar.CMSServer.model.User;
import java.io.Serializable;

/**
 *
 * @author Lazar Milosavljević
 */
public class UserDTO implements Serializable{

    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String category;
    public UserDTO() {
    }

    public UserDTO(User user) {
        this.age=user.getAge();
        id=user.getUserId();
        firstName=user.getFirstName();
        lastName=user.getLastName();
        category=user.getCategory().getValue();
        username=user.getUsername();
    }

    public User fromDTO(){
        return new User(id, firstName, lastName, age, username, null);
    }
    public UserDTO(Integer id, String firstName, String lastName, int age, String username,String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.category=category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
