package com.assignment.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.main.model.User;
import com.assignment.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.getUsersFromDataSource();
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.getUser(userName);
	}

	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		boolean insertionStatus= userRepository.save(user);
		if (insertionStatus) {
			return "User added successfully!!!!!";
		} else {
			return "Failed!!!!!....User Not possible..Database error";
		}
	}

	@Override
	public String updateUser(String userName, int count) {
		// TODO Auto-generated method stub
		
		return userRepository.update(userName, count);
	}

	@Override
	public String deleteUserByName(String userName) {
		// TODO Auto-generated method stub
		List<User> userListRightNow = userRepository.getUsersFromDataSource();
		boolean deleteResponse = false;
		for (User user : userListRightNow) {
			if (user.getUserName().equals(userName)) {
				deleteResponse = userRepository.remove(user);
				if (deleteResponse) {
					return "User with userName: " + userName + " was deleted!!!";
				} else {
					return "User with userName: " + userName + " was not deleted!!!...Database error";
				}
				
			}
		}

		return "User with userName: " + userName + " does not exist!!!";
	}

}
