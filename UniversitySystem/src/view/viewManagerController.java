package view;

import users.Manager;

public class viewManagerController {
	public static void showManagerMenu(Manager manager) {
		viewUserController.showUserMenu(manager);
		System.out.println("2. View all students");
		System.out.println("3. View student");
		System.out.println("4. View news");
		System.out.println("5. Create news");
		System.out.println("6. Delete news");
		System.out.println("7. View courses");
		System.out.println("8. Create course");
		System.out.println("9. Edit course");
		System.out.println("10. Delete course");
		System.out.println("11. Register for course");
		System.out.println("12. Delete from course");
		System.out.println("13. Logout");
	}
}
