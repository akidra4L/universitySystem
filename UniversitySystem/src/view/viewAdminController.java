package view;

import universitySystem.Admin;

public class viewAdminController {
	public static void showAdminMenu(Admin admin) {
		viewUserController.showUserMenu(admin);
		System.out.println("2. View all users.");
		System.out.println("3. Create user.");
		System.out.println("4. Delete user.");
		System.out.println("5. Logout.");
	}
}
