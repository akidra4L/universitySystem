package users;

import java.util.HashMap;
import java.util.Map;

import classes.Course;
import classes.ID;
import classes.Mark;
import classes.Transcript;
import enums.Degree;
import enums.Faculty;

public class Student extends User implements Comparable<Student>, Cloneable {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private Degree degree;
	private HashMap<Course, Mark> allCourses;
	private double gpa;
	private Transcript transcript;

	public Student(ID id, String name, Faculty faculty, Degree degree, HashMap<Course, Mark> allCourses, double gpa,
			Transcript transcript) {
		super(id, name);
		this.faculty = faculty;
		this.degree = degree;
		this.allCourses = allCourses;
		this.gpa = gpa;
		this.transcript = transcript;
	}

	public Student(ID id, String name) {
		super(id, name);
		this.faculty = Faculty.Undefined;
		this.degree = Degree.Undefined;
		this.allCourses = new HashMap<Course, Mark>();
		this.gpa = 0;
		this.transcript = new Transcript(id);
	}

	public Student(ID id, String name, String password) {
		super(id, name, password);
		this.faculty = Faculty.Undefined;
		this.degree = Degree.Undefined;
		this.allCourses = new HashMap<Course, Mark>();
		this.gpa = 0;
		this.transcript = new Transcript(id);
	}

	public Faculty getFaculty() {
		return this.faculty;
	}
	public void setFaculty(Faculty fac) {
		this.faculty = fac;
	}

	public Degree getDegree() {
		return this.degree;
	}

	public double getGpa() {
		return this.gpa;
	}

	public int getTotalCreditsInSemester() {
		int total = 0;
		for (Course c : allCourses.keySet()) {
			total += c.getCredits();
		}
		return total;
	}

	public boolean enrollCourse(Course course) {
		if (course.getCredits() + getTotalCreditsInSemester() <= 30) {
			return true;
		}
		return false;
	}

	public boolean dropCourse(Course course) {
		for (Course c : allCourses.keySet()) {
			if (c.equals(course)) {
				allCourses.remove(c);
				return true;
			}
		}
		return false;
	}

	public Transcript getTranscript() {
		return transcript;
	}
	
	public void viewTranscript() {
		for(Map.Entry<Course, Mark> hm: allCourses.entrySet()) {
			System.out.println("- " + hm.getKey().viewTranscriptInfo() + " " + hm.getValue().getScore() + " " + hm.getValue().getMarkLetter());
		}
	}

	@Override
	public int compareTo(Student o) {
		if (this.gpa > o.getGpa()) {
			return 1;
		}
		return 0;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		Student s = (Student) o;
		return this.faculty.equals(s.getFaculty()) && this.degree.equals(s.getDegree()) && this.gpa == s.getGpa()
			    && this.transcript.equals(s.getTranscript())
				&& this.getAllCourses().equals(s.getAllCourses());
	}

	public void putMark(Course course, double mark) {
		if (allCourses.containsKey(course)) {

			Mark currentMark = allCourses.get(course);
			double sum = currentMark.getScore() + mark;

			if (sum > 100) {
				throw new IllegalArgumentException("The score cannot exceed 100");
			}
			allCourses.put(course, new Mark(sum));
		} else {
			throw new IllegalArgumentException("The student is not registered for this course");
		}
	}

	public HashMap<Course, Mark> getAllCourses() {
		return allCourses;
	}
	
	public double getPoints(Course c) {
		for(Map.Entry<Course, Mark> hm: allCourses.entrySet()) {
			if(hm.getKey().equals(c)) {
				return hm.getValue().getScore();
			}
		}
		return 0;
	}

	public void setAllCourses(HashMap<Course, Mark> allCourses) {
		this.allCourses = allCourses;
	}
	
	public void viewSchedule() {
		allCourses.keySet().forEach((key) -> System.out.println(key.getWeekdayAndTime()));
	}
	
	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.degree + " " + this.allCourses + " " + this.gpa + " "
				+ " " + this.transcript;
	}
	
	public String viewInfo() {
		return this.getId().getNumberID() + " " + this.getName() + " " + this.getGpa() + " " + this.getFaculty() + " " + this.allCourses;
	}
}
