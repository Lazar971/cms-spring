/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.controller;

import com.lazar.CMSServer.dto.PostCategoryDTO;
import com.lazar.CMSServer.model.PostCategory;
import com.lazar.CMSServer.service.PostCategoryService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Lazar Milosavljević
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/postCategory")
public class PostCategoryController {
    
    @Autowired
    private PostCategoryService categoryService;
    
   @GetMapping
   public List<PostCategoryDTO> getAll(){
       return categoryService.findAll();
   }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Object handleError(HttpServletRequest req, Exception ex) {
        return "{status:\""+ex.getMessage()+"\"}";
    }
}
