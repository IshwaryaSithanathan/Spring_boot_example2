package com.userpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.userpage.entity.User;
import com.userpage.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//@PostMapping("user")
	@RequestMapping(value="/user", produces={"application/json","application/x-www-form-urlencoded"}, consumes={"application/json","application/x-www-form-urlencoded"})
	public ResponseEntity<Void> addUser(@RequestBody User User, UriComponentsBuilder builder) {
        boolean flag = userService.addUser(User);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(User.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}	
} 