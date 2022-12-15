package users;

import java.util.Vector;

import classes.Course;
import classes.ID;
import classes.Schedule;
import enums.Faculty;
import enums.Role;
import enums.TeacherTitle;
import universitySystem.UniversitySystem;

public class Teacher extends Employee {
	private Faculty faculty;
	private TeacherTitle title;
	private Vector<Course> courses;
	private Schedule schedule;

	public Teacher(ID id, String name, Role role, double salary, Faculty faculty, TeacherTitle title,
			Vector<Course> courses, Schedule schedule) {
		super(id, name, role, salary);
		this.faculty = faculty;
		this.title = title;
		this.courses = courses;
		this.schedule = schedule;
		UniversitySystem.addTeacher(this);
	}

	public Teacher(ID id, String name, Role role, double salary) {
		super(id, name, role, salary);
		this.faculty = Faculty.Undefined;
		this.courses = new Vector<Course>();
		this.schedule = new Schedule(id);
		UniversitySystem.addTeacher(this);
	}

	public Teacher(ID id, String name, Role role) {
		super(id, name, role);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.courses = new Vector<Course>();
		this.schedule = new Schedule(id);
		UniversitySystem.addTeacher(this);
	}
	
	public Teacher(ID id, String name, String password, Role role) {
		super(id, name, password, role);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.courses = new Vector<Course>();
		this.schedule = new Schedule(id);
		UniversitySystem.addTeacher(this);
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public TeacherTitle getTitle() {
		return this.title;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}

	public Vector<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void putMark(Student s) {
		
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		Teacher t = (Teacher) o;
		return this.faculty.equals(t.getFaculty()) && this.title.equals(t.getTitle())
				&& this.courses.equals(t.getCourses()) && this.schedule.equals(t.getSchedule());
	}

	public Vector<Student> checkAttendance() {
		// TODO
		return null;
	}

	public int compareTo(Teacher t) {
//		if (this.getId() == t.getId())
//			return true;
//		return false;
		return 0;
	}

	public String toString() {
		return super.toString() + getTitle() + " " + getFaculty() + " " + getCourses() + " " + getSchedule();
	}
}
