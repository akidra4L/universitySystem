package users;

import java.util.Vector;

import classes.Course;
import classes.CourseStudent;
import classes.ID;
import classes.Schedule;
import classes.Transcript;
import enums.Degree;
import enums.Faculty;
import enums.Role;
import universitySystem.UniversitySystem;

public class Student extends User implements Comparable<Student> {
	private Faculty faculty;
    private Degree degree;
    private Vector<CourseStudent> courses;
    private double gpa;
    private Schedule schedule;
    private Transcript transcript;
    
    public Student(ID id, String name, Role role, Faculty faculty, Degree degree, Vector<CourseStudent> courses, double gpa, Schedule schedule, Transcript transcript) {
		super(id, name, role);
		this.faculty = faculty;
		this.degree = degree;
		this.courses = courses;
		this.gpa = gpa;
		this.schedule = schedule;
		this.transcript = transcript;
		UniversitySystem.addStudent(this);
	}
    
    public Student(ID id, String name, Role role) {
    	super(id, name, role);
    	this.faculty = Faculty.Undefined;
    	this.degree = Degree.Undefined;
    	this.courses = new Vector<CourseStudent>();
    	this.gpa = 0;
    	this.schedule = new Schedule(id);
    	this.transcript = new Transcript(id);
    	UniversitySystem.addStudent(this);
    }

    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public Degree getDegree() {
        return this.degree;
    }
    
    public Vector<CourseStudent> getCourses() {
        return this.courses;
    }
    public void setCourses(Vector<CourseStudent> courses) {
        this.courses = courses;
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
    	for(Course c: courses) {
    		total += c.getCredits();
    	}
    	return total;
    }
    
    public boolean enrollCourse(Course course) {
    	if(course.getCredits() + getTotalCreditsInSemester() <= 30) {
    		return true;
    	}
        return false;
    }

    public boolean dropCourse(Course course) {
        for(Course c: courses) {
        	if(c.equals(course)) {
        		courses.remove(c);
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
		return 0;
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		
		Student s = (Student) o;
		return this.faculty.equals(s.getFaculty()) && this.degree.equals(s.getDegree()) && this.courses.equals(s.getCourses()) && this.gpa == s.getGpa() && this.schedule.equals(s.getSchedule()) && this.transcript.equals(s.getTranscript());
	}
	
	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.degree + " " + this.courses + " " + this.gpa + " " + this.schedule + " " + this.transcript;
 	}
}
