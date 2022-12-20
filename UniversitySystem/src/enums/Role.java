package enums;

public enum Role {
	Admin, Student, Teacher, Manager, Employee, Librarian;
	
	public static Role of (final String role) {
		switch(role) {
		case "admin":
			return Admin;
		case "student":
			return Student;
		case "teacher":
			return Teacher;
		case "manager":
			return Manager;
		case "employee":
			return Employee;
		case "librarian":
			return Librarian;
		default:
			return null;
		}
	}
}
