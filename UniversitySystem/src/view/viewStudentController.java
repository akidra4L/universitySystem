package view;

import users.Student;

public class viewStudentController {
	public static void showStudentMenu(Student student) {
		viewUserController.showUserMenu(student);
		System.out.println("2. Student's schedule.");
		System.out.println("3. Student's marks.");
		System.out.println("4. Student's transcript.");
		System.out.println("5. Logout.");
	}
}
