package view;

import users.Manager;

public class viewManagerController {
	public static void showManagerMenu(Manager manager) {
		viewUserController.showUserMenu(manager);
		System.out.println("3. Requests");
		System.out.println("4. Change user information");
		System.out.println("5. View all teachers");
		System.out.println("6. View all students");
		System.out.println("7. View student");
		System.out.println("8. View news");
		System.out.println("9. Create news");
		System.out.println("10. Delete news");
		System.out.println("11. View courses");
		System.out.println("12. Create course");
		System.out.println("13. Edit course");
		System.out.println("14. Delete course");
		System.out.println("15. Register for course");
		System.out.println("16. Delete from course");
		System.out.println("17. Logout");
	}
	
	public static void showFinancialManagerMenu(Manager manager) {
		viewUserController.showUserMenu(manager);
		System.out.println("3. View all employees");
		System.out.println("4. Edit employees's salary");
		System.out.println("5. Logout");
	}
	
	public static void showRequestsManagerMenu() {
		System.out.println("--- 1. View all requests");
		System.out.println("--- 2. Manage request");
	}
	
	public static void showRequestsOptions() {
		System.out.println("----- 1. Approve: ");
		System.out.println("----- 2. Deny: ");
	}
}
