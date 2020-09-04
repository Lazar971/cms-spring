/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazar.CMSServer.service;

import com.lazar.CMSServer.dto.PostCategoryDTO;
import com.lazar.CMSServer.model.PostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lazar.CMSServer.repository.PostCategorRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Lazar Milosavljević
 */
@Service
public class PostCategoryService {
    
    @Autowired
    private PostCategorRepository categorRepository;

    public List<PostCategoryDTO> findAll() {
        return categorRepository.findAll().stream().map((PostCategory postCat)->{return new PostCategoryDTO(postCat);}).collect(Collectors.toList());
    }
    
    
}
