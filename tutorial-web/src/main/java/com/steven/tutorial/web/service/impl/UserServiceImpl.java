package com.steven.tutorial.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.steven.tutorial.web.domain.User;
import com.steven.tutorial.web.service.UserService;

public class UserServiceImpl implements UserService {

	static List<User> users = new ArrayList<User>();

	static {

		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("liu");
		users.add(user1);

		User user2 = new User();
		user2.setUserId(2);
		user2.setUserName("yang");
		users.add(user2);

	}

	public List<User> getAllUsers() {
		return users;
	}

}
