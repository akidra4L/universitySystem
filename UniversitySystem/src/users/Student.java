package users;

import java.util.Vector;
import java.util.HashMap;

import classes.CourseStudent;
import classes.ID;
import classes.Schedule;
import classes.Transcript;
import enums.Degree;
import enums.Faculty;
import enums.Mark;
import enums.Role;
import universitySystem.UniversitySystem;

public class Student extends User {
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
    
    public void takeExam() {
        // TODO
    }

    public void takeHomework() {
        // TODO
    }
    
    public void takeLesson() {
        // TODO
    }
    
    public void enrollCourse() {
        // TODO
    }

    public void dropCourse() {
        // TODO
    }

	public Transcript getTranscript() {
		return transcript;
	}
	
	public String toString() {
		return super.toString() + " " + this.faculty + " " + this.degree + " " + this.courses + " " + this.gpa + " " + this.schedule + " " + this.transcript;
 	}
}
