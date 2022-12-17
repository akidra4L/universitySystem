package classes;

import java.util.HashMap;
import java.util.Vector;

import enums.Faculty;
import users.Student;

public class CourseTeacher extends Course {
	private static final long serialVersionUID = 1L;
	private HashMap<Course, Student> students;

	public CourseTeacher(ID id, String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite) {
		super(id, code, title, faculty, credits, prerequisite);
	}

	public HashMap<Course, Student> getStudents() {
		return students;
	}

	public void setStudents(HashMap<Course, Student> students) {
		this.students = students;
	}
	
	public String toString() {
		return super.toString() + " " + this.students;
 	}
}
