package users;

import java.util.Vector;

import classes.CourseStudent;
import classes.Schedule;
import classes.Transcript;
import enums.Degree;
import enums.Faculty;

public class Student extends User {
    private Faculty faculty;
    private Degree degree;
    private Vector<CourseStudent> courses;
    private double gpa;
    private Schedule schedule;

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

    public Transcript viewTranscript() {
        // TODO
    	return null;
    }
}
