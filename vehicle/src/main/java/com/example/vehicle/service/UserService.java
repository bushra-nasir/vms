package com.example.vehicle.service;



import com.example.vehicle.model.User;

public interface UserService {
	User createUser(User user);
	String validateUser (String username, String password);
	
}
