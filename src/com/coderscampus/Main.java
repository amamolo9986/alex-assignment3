package com.coderscampus;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserService();
		User[] users = userService.getUserArray();

		int numberOfTries = 0;
// you can create a boolean variable here for successful login so you can use that in your loop to break out. 
		Scanner scan = new Scanner(System.in);

		while (numberOfTries < 5) {
			System.out.println("Enter Username: ");
			String username = scan.next();
			System.out.println("Enter Password: ");
			String password = scan.next();
			if (validUser(users, username, password) != true) {
				// this is where you start to write what happens if they DON'T validate
			}
		}//then you will just write an else statement here that will break and have your cose for too many failed attempts. 
	}

	private static boolean validUser(User[] users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getName());
				return true;

			}
		}
		return false;

	}
}
