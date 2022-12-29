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

				users[i] = userService.createUser(userData[0], userData[1], userData[2]);
				i++;

				System.out.println("Enter Username:");
				username = scan.nextLine();
				System.out.println("Enter Password");
				password = scan.nextLine();

				if (username.equals(userData[0]) && password.equals(userData[1])) {
					System.out.println("Welcome " + userData[2]);
					i++;
					break;
				} else {
					System.out.println("Invalid login. Please try again.");
				}

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
	}
}

//i'm only getting a valid input for a username and password from the first line of my file
//if i type a user and password from any other line, i get an invalid login message 