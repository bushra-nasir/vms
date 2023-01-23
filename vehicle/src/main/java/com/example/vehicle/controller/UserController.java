package com.example.vehicle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.model.User;
import com.example.vehicle.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@RequestMapping("/validateUser/{username}/{password}")
	public String validateUser(@PathVariable String username, @PathVariable String password) {
		return userService.validateUser(username, password);
	//	return "validate-user";
		//User user = new User();
		//return user.toString();
	}
}
