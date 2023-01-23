package com.example.vehicle.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vehicle.exception.CustomException;
import com.example.vehicle.model.User;
import com.example.vehicle.repo.UserRepository;
//import com.example.vehicle.service.CustomUserDetails;
import com.example.vehicle.service.UserService;

@Service
public class UserServiceImpl implements UserService {
//,UserDetailsService {
	@Autowired
	UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	
	//@Override
//	public User loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepo.findById(username).orElseThrow(() -> new CustomException("Username not found!"));
//		return user;
//	}
	@Override
	public String validateUser(String username, String password) {
		User existingUser = userRepo.findById(username).orElseThrow(() -> new CustomException("Username not found! Access denied."));
		if(existingUser.getUsername().equals(username)) {
			if(existingUser.getPassword().equals(password))
				return existingUser.toString();	
			}

		return ("User not authorized");
	}

}
