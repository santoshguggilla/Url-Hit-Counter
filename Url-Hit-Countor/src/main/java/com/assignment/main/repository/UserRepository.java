package com.assignment.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment.main.model.User;

@Repository
public class UserRepository {

	private List<User> userList;

	public UserRepository() {
		userList = new ArrayList<>();
		// not needed ...done for testing
		userList.add(new User("Santosh", 25));

	}

	public List<User> getUsersFromDataSource() {
		return userList;
	}

	public boolean save(User user) {
		userList.add(user);
		return true;
	}

	public String update(String userName, int count) {
		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				remove(user);
				user.setCount(count);
				save(user);
				return "Restaurant with userName: " + userName + " was updated!!!";
			}
		}
		return "Restaurant with userName: " + userName + " does not exist!!!";
	}

	public boolean remove(User user) {
		userList.remove(user);// mock a database
		return true;
	}

	public User getUser(String userName) {
		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				return user;
			}
		}

		return null;
	}
}
