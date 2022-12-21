package view;

import users.Manager;

public class viewManagerController {
	public static void showManagerMenu(Manager manager) {
		viewUserController.showUserMenu(manager);
		System.out.println("2. Change user information");
		System.out.println("3. View all teachers");
		System.out.println("4. View all students");
		System.out.println("5. View student");
		System.out.println("6. View news");
		System.out.println("7. Create news");
		System.out.println("8. Delete news");
		System.out.println("9. View courses");
		System.out.println("10. Create course");
		System.out.println("11. Edit course");
		System.out.println("12. Delete course");
		System.out.println("13. Register for course");
		System.out.println("14. Delete from course");
		System.out.println("15. Logout");
	}
	
	public static void showFinancialManagerMenu(Manager manager) {
		viewUserController.showUserMenu(manager);
		System.out.println("2. View all employees");
		System.out.println("3. Edit employees's salary");
		System.out.println("4. Logout");
	}
}
