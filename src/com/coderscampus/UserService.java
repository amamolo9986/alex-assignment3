package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

	public User[] getUserArray() {
		User[] users = new User[4];

		BufferedReader fileReader = null;
		try {

			fileReader = new BufferedReader(new FileReader("user.data.txt"));
			String line;

			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] userData = line.split(",");
				String username = userData[0];
				String password = userData[1];
				String name = userData[2];

				users[i] = createUser(username, password, name);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
