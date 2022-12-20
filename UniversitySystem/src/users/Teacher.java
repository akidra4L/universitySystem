package users;

import java.util.HashMap;
import java.util.Map;
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
	private HashMap<Course, Vector<Student>> allCourses;
	private Schedule schedule;

	public Teacher(ID id, String name, double salary, Faculty faculty, TeacherTitle title, HashMap<Course, Vector<Student>> allCourses, Schedule schedule) {
		super(id, name, salary);
		this.faculty = faculty;
		this.title = title;
		this.allCourses = allCourses;
		this.schedule = schedule;
	}

	public Teacher(ID id, String name, double salary) {
		super(id, name, salary);
		this.faculty = Faculty.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
		this.schedule = new Schedule(id);
	}

	public Teacher(ID id, String name) {
		super(id, name);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
		this.schedule = new Schedule(id);
	}
	
	public Teacher(ID id, String name, String password) {
		super(id, name, password);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
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
	
	public HashMap<Course, Vector<Student>> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(HashMap<Course, Vector<Student>> allCourses) {
		this.allCourses = allCourses;
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
	
	public Course containsCourse(String courseCode) {
		for (Course c : this.allCourses.keySet()) {
			if(c.getCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}
	
	public Student getStudent(String courseCode, String studentID) {
		Course c = containsCourse(courseCode);
		for(Map.Entry<Course, Vector<Student>> hm: allCourses.entrySet()) {
			if(hm.getKey().equals(c)) {
				Vector<Student> students = hm.getValue();
				for(Student s: students) {
					if(s.getId().getNumberID().equals(studentID)) {
						return s;
					}
				}
			} else {
				return null;
			}
		}
		return null;
	}
	
	public boolean putMarkToStudent(String courseCode, String id, double mark) {
		for(Map.Entry<Course, Vector<Student>> hm : allCourses.entrySet()) {
			if(hm.getKey().getCode().equals(courseCode)) {
				for(Student st: hm.getValue()) {
					if(st.getId().getNumberID().equals(id)) {
						st.putMark(hm.getKey(), mark);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void addStudent(Course c, Student s) {
		allCourses.entrySet().stream().filter(n -> n.getKey().equals(c)).forEach(n -> n.getValue().add(s));;
	}
	
	public void addCourse(Course c) {
		allCourses.put(c, new Vector<Student>());
	}

	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.title +  " " + this.allCourses + " " + this.schedule;
	}
}
