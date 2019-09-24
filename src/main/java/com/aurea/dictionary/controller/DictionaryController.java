package com.aurea.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurea.dictionary.service.DictionaryService;

import io.swagger.annotations.ApiOperation;


/**
 * The Class consists of User related rest end-points.
 * 
 * @author KotilingeswararaoR
 *
 */
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {
 
    @Autowired
    private DictionaryService dictionaryService;
 
    @ApiOperation(value = "Fetch User by userId", 
			notes = "This service Fetch User by userId", 
			response = String.class
	)
    @GetMapping("/{word}")
    public List<String> fetchUserById(@PathVariable String word) {
        return dictionaryService.getSimilarWods(word);
    }
    
}
