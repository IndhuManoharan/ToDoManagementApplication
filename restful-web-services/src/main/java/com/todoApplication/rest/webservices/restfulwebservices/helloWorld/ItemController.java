package com.todoApplication.rest.webservices.restfulwebservices.helloWorld;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;

import services.ItemService;

//@RestController
public class ItemController {
//	 @Autowired
	 private ItemService itemService;
	    
	 
	 @GetMapping(path="/titles")
	    public List<String> getTitles(Double rating) {
	        //TODO
	      List<String> titleList = itemService.getTitlesWithAverageRatingLowerThan(rating);
	        return new ArrayList();
	    }
}
