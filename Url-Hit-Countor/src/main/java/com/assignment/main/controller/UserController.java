package com.assignment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.main.model.User;
import com.assignment.main.service.UserService;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/getUser/{userName}")
	public User getUserbyUserName(@PathVariable String userName) {
		return userService.getUserByName(userName);
	}

	@PutMapping("/updateUser/{userName}/{count}")
	public String updateUser(@PathVariable("userName") String userName, @PathVariable("count") int count) {

		return userService.updateUser(userName, count);
	}
	
	@DeleteMapping("/deleteUser/{userName}")
	public String deleteUser(@PathVariable String userName) {
		return userService.deleteUserByName(userName);
	}
}
