package classes;

import java.util.HashMap;
import java.util.Vector;

import enums.Faculty;
import users.*;

public class TeacherCourse extends Course {
	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	private String room;
	private HashMap<Course, Student> students;

	public TeacherCourse(String code, String title, Faculty faculty, int credits) {
		super(code, title, faculty, credits);
		this.students = null;
	}

	public HashMap<Course, Student> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Course, Student> students) {
		this.students = students;
	}

	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String toString() {
		return this.room + " " + this.teacher + " " + this.students;
	}
}
