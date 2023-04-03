package com.cg.ems.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.User;
import com.cg.ems.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	
	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) throws Exception {
		return userService.registerNewUser(user);
	}

	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only Accessible for Admin";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only Accessible for User";
	}
	
	@GetMapping({"/avanthika"})
	//@PreAuthorize("hasRole('User')")
	public String avanthika() {
		return "This URL is only Accessible for avanthika";
	}
	
}
