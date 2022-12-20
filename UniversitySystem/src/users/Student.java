package users;

import java.util.HashMap;

import classes.Course;
import classes.ID;
import classes.Mark;
import classes.Schedule;
import classes.Transcript;
import enums.Degree;
import enums.Faculty;

public class Student extends User implements Comparable<Student>, Cloneable {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private Degree degree;
	private HashMap<Course, Mark> allCourses;
	private double gpa;
	private Schedule schedule;
	private Transcript transcript;

	public Student(ID id, String name, Faculty faculty, Degree degree, HashMap<Course, Mark> allCourses, double gpa,
			Schedule schedule, Transcript transcript) {
		super(id, name);
		this.faculty = faculty;
		this.degree = degree;
		this.allCourses = allCourses;
		this.gpa = gpa;
		this.schedule = schedule;
		this.transcript = transcript;
	}

	public Student(ID id, String name) {
		super(id, name);
		this.faculty = Faculty.Undefined;
		this.degree = Degree.Undefined;
		this.allCourses = new HashMap<Course, Mark>();
		this.gpa = 0;
		this.schedule = new Schedule(id);
		this.transcript = new Transcript(id);
	}

	public Student(ID id, String name, String password) {
		super(id, name, password);
		this.faculty = Faculty.Undefined;
		this.degree = Degree.Undefined;
		this.allCourses = new HashMap<Course, Mark>();
		this.gpa = 0;
		this.schedule = new Schedule(id);
		this.transcript = new Transcript(id);
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public Degree getDegree() {
		return this.degree;
	}

	public double getGpa() {
		return this.gpa;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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
				&& this.schedule.equals(s.getSchedule()) && this.transcript.equals(s.getTranscript())
				&& this.getAllCourses().equals(s.getAllCourses());
	}

	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.degree + " " + this.allCourses + " " + this.gpa + " "
				+ this.schedule + " " + this.transcript;
	}

	public void putMark(Course course, Mark mark) {
		if (allCourses.containsKey(course)) {

			Mark currentMark = allCourses.get(course);

			double sum = currentMark.getScore() + mark.getScore();

			if (sum > 100) {
				throw new IllegalArgumentException("Mark cannot exceed 100");
			}

			allCourses.put(course, new Mark(sum));
		} else {
			allCourses.put(course, mark);
		}
	}

	public HashMap<Course, Mark> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(HashMap<Course, Mark> allCourses) {
		this.allCourses = allCourses;
	}
}
