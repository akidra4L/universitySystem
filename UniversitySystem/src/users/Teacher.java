package users;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import classes.Course;
import classes.ID;
import enums.Faculty;
import enums.TeacherTitle;

/**
 * Teacher class
 * @author AlikhanGubayev
 *
 */
public class Teacher extends Employee {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private TeacherTitle title;
	private HashMap<Course, Vector<Student>> allCourses;

	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 * @param faculty
	 * @param title
	 * @param allCourses
	 */
	public Teacher(ID id, String name, double salary, Faculty faculty, TeacherTitle title, HashMap<Course, Vector<Student>> allCourses) {
		super(id, name, salary);
		this.faculty = faculty;
		this.title = title;
		this.allCourses = allCourses;
	}

	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 */
	public Teacher(ID id, String name, double salary) {
		super(id, name, salary);
		this.faculty = Faculty.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
	}

	/**
	 * Default constructor
	 * @param id
	 * @param name
	 */
	public Teacher(ID id, String name) {
		super(id, name);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
	}
	
	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param password
	 */
	public Teacher(ID id, String name, String password) {
		super(id, name, password);
		this.faculty = Faculty.Undefined;
		this.title = TeacherTitle.Undefined;
		this.allCourses = new HashMap<Course, Vector<Student>>();
	}

	/**
	 * Getter for Teacher's Faculty
	 * @return Faculty
	 */
	public Faculty getFaculty() {
		return this.faculty;
	}
	/**
	 * Setter for Teacher's faculty
	 * @param faculty
	 */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	/**
	 * Getter for Teacher's Title
	 * @return TeacherTitle
	 */
	public TeacherTitle getTitle() {
		return this.title;
	}

	/**
	 * Setter for Teacher's Title
	 * @param title
	 */
	public void setTitle(TeacherTitle title) {
		this.title = title;
	}
	
	/**
	 * Getter for Teacher's Courses
	 * @return HashMap
	 */
	public HashMap<Course, Vector<Student>> getAllCourses() {
		return allCourses;
	}

	/**
	 * Setter for Teacher's Courses
	 * @param allCourses
	 */
	public void setAllCourses(HashMap<Course, Vector<Student>> allCourses) {
		this.allCourses = allCourses;
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		Teacher t = (Teacher) o;
		return this.faculty.equals(t.getFaculty()) && this.title.equals(t.getTitle());
	}
	
	/**
	 * Method, which returning Course by it's code
	 * @param courseCode
	 * @return Course if exists in System, null otherwise
	 */
	public Course containsCourse(String courseCode) {
		for (Course c : this.allCourses.keySet()) {
			if(c.getCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Method, which returning Vector<Student> by Course code 
	 * @param courseCode
	 * @return Vector<Student>
	 */
	public Vector<Student> getStudents(String courseCode) {
		Course c = containsCourse(courseCode);
		for(Map.Entry<Course, Vector<Student>> hm: allCourses.entrySet()) {
			if(hm.getKey().equals(c)) {
				return hm.getValue();
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Method, which returning Student by his ID
	 * @param courseCode
	 * @param studentID
	 * @return Student
	 */
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
	
	public boolean deleteStudentFromCourse(String courseCode, String studentID) {
		Student s = this.getStudent(courseCode, studentID);
		Course c = containsCourse(courseCode);
		for(Map.Entry<Course, Vector<Student>> hm: allCourses.entrySet()) {
			if(hm.getKey().equals(c)) {
				hm.getValue().remove(s);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Method, which returning info about Student for certain Course
	 * @param courseCode
	 * @param id
	 * @return String
	 */
	public String getInfoForCourse(String courseCode, ID id) {
		Student s = getStudent(courseCode, id.getNumberID());
		Course c = containsCourse(courseCode);
		return s.getId().getNumberID() + " " + s.getName() + " " + s.getPoints(c);
	}
	
	/**
	 * Method, which adding for certain Student points
	 * @param courseCode
	 * @param id
	 * @param mark
	 * @return true if Student is in certain Course, false otherwise
	 */
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
	
	/**
	 * Method, which adding certain Student for this Teacher for certain Course
	 * @param c
	 * @param s
	 */
	public void addStudent(Course c, Student s) {
		allCourses.entrySet().stream().filter(n -> n.getKey().equals(c)).forEach(n -> n.getValue().add(s));;
	}
	
	/**
	 * Method, which adding Course to Teacher
	 * @param c
	 */
	public void addCourse(Course c) {
		allCourses.put(c, new Vector<Student>());
	}
	
	/**
	 * Method, which shows Schedule of Teacher
	 */
	public void viewSchedule() {
		allCourses.keySet().forEach((key) -> System.out.println(key.getWeekdayAndTime()));
	}

	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.title +  " " + this.allCourses;
	}
	
	/**
	 * Method, which shows information about Teacher: ID's number, name, faculty, courses
	 * @return String
	 */
	public String viewInfo() {
		return this.getId().getNumberID() + " " + this.getName() + " " + this.getFaculty() + " " + this.getAllCourses();
	}
}
