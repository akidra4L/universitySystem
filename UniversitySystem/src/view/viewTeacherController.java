package view;

import users.Teacher;

public class viewTeacherController {
	public static void showStudentMenu(Teacher teacher) {
		viewUserController.showUserMenu(teacher);
		System.out.println("3. Teacher's schedule.");
		System.out.println("4. Set marks.");
		System.out.println("5. Logout.");
	}
}
