package com.assignment.main.service;

import java.util.List;

import com.assignment.main.model.User;

public interface UserService {

	public List<User> getAllUser();

	public User getUserByName(String userName);

	public String saveUser(User user);

	public String updateUser(String userName, int count);

	public String deleteUserByName(String userName);

}
