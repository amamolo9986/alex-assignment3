package com.coderscampus;

//User information 
//This will hold my buffered reader to read my external file and my array of users

public class UserService {

	public User createUser(String username, String password, String name) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		return user;
	}
}
