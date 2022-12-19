package view;

import universitySystem.UniversitySystem;
import users.User;

public class viewUserController {
	public static void showUserMenu() {
		System.out.println("\nWelcome to " + UniversitySystem.name);
		System.out.println("Menu: choose your option");
		System.out.println("1. Login");
		System.out.println("2. Exit");
	}
	
	public static void showUserMenu(User user) {
		System.out.println("\nWelcome " + user.getName() + " to " + UniversitySystem.name);
		System.out.println("Menu: choose your option");
		System.out.println("1. Change password.");
	}
}
