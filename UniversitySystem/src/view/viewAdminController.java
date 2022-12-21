package view;

import universitySystem.Admin;

public class viewAdminController {
	public static void showAdminMenu(Admin admin) {
		viewUserController.showUserMenu(admin);
		System.out.println("3. View all users");
		System.out.println("4. Create user");
		System.out.println("5. Delete user");
		System.out.println("6. Logout");
	}
}
