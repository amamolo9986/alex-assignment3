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

		System.out.println("Enter Username: ");
		String username = scan.next();
		System.out.println("Enter Password: ");
		String password = scan.next();

		int i = 0;
		for (User user : users) {
			i++;
			if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
				System.out.println("Welcome " + users[i].getName());
				break;
			} else {
				System.out.println("Invalid login. Please try again.");
			}

		}
	}
	}

