package classes;

import java.util.HashMap;
import java.util.Vector;

import enums.Faculty;
import users.Student;

public class CourseTeacher extends Course {
	private HashMap<Course, Student> students;

	public CourseTeacher(ID id, String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite) {
		super(id, code, title, faculty, credits, prerequisite);
	}

}
