package view;

import users.User;

public class viewUserController {
	public static void showUserMenu() {
		System.out.println("Welcome to University System.");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Exit");
	}
	
	public static void showUserMenu(User user) {
		System.out.println("\nWelcome, " + user.getName() + " to University System.");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Change password");
	}
}
