package users;

import java.util.HashMap;
import java.util.Vector;

import classes.Course;
import classes.ID;
import classes.Schedule;
import enums.Faculty;
import enums.TeacherTitle;

public class Teacher extends Employee {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private TeacherTitle title;
	private HashMap<Course, Student> allCourses;
	private Schedule schedule;

	public Teacher(ID id, String name, double salary, Faculty faculty, TeacherTitle title, HashMap<Course, Student> allCourses, Schedule schedule) {
		super(id, name, salary);
		this.faculty = faculty;
		this.title = title;
		this.allCourses = allCourses;
		this.schedule = schedule;
	}

	public Teacher(ID id, String name, double salary) {
		super(id, name, salary);
		this.faculty = Faculty.Undefined;
		this.allCourses = new HashMap<Course, Student>();
		this.schedule = new Schedule(id);
	}

	public Teacher(ID id, String name) {
		super(id, name);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Student>();
		this.schedule = new Schedule(id);
	}
	
	public Teacher(ID id, String name, String password) {
		super(id, name, password);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Student>();
		this.schedule = new Schedule(id);
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

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public HashMap<Course, Student> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(HashMap<Course, Student> allCourses) {
		this.allCourses = allCourses;
	}

	public void putMark(Student s) {
		
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		Teacher t = (Teacher) o;
		return this.faculty.equals(t.getFaculty()) && this.title.equals(t.getTitle())
				&& this.schedule.equals(t.getSchedule());
	}

	public Vector<Student> checkAttendance() {
		// TODO
		return null;
	}

	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.title +  " " + this.allCourses + " " + this.schedule;
	}
}
