package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserService();
		Scanner scan = new Scanner(System.in);
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

				users[i] = userService.createUser(username, password, name);
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
		User successfulLogin = null;

		int attempts = 0;
		while (attempts < 5) {
			attempts++;
			System.out.println("Enter Username: ");
			String username = scan.next();
			System.out.println("Enter Password: ");
			String password = scan.next();
			successfulLogin = validateUser(users, username, password);

			if (successfulLogin != null && attempts <= 5) {
				break;
			} else {
				if (attempts < 5){
					System.out.println("Invalid login, please try again");
				}
			}
			if (attempts == 5) {
				System.out.println("Too many failed login attempts, your account is locked.");

			}
		}
		scan.close();
	}

	public static User validateUser(User[] users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getName());
				return user;
			}

		}
		return null;
	}
}
