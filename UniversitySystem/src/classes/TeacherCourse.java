package classes;

import java.util.HashMap;
import java.util.Vector;

import enums.Faculty;
import users.*;

public class TeacherCourse extends Course {
	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	private HashMap<Course, Student> students;

	public TeacherCourse(String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite) {
		super(code, title, faculty, credits, prerequisite);
		this.setTeacher(null);
		this.students = null;
	}

	public HashMap<Course, Student> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Course, Student> students) {
		this.students = students;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String toString() {
		return super.toString() + " " + this.teacher + " " + this.students;
 	}
}
