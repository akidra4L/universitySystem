package view;

import users.Teacher;

public class viewTeacherController {
	public static void showTeacherMenu(Teacher teacher) {
		viewUserController.showUserMenu(teacher);
		System.out.println("2. Teacher's schedule.");
		System.out.println("3. Set marks.");
		System.out.println("4. Logout.");
	}
}
