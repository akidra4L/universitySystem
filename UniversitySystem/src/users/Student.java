package users;

import java.util.Vector;

import enums.Degree;
import enums.Faculty;

public class Student extends User {
    private Faculty faculty;
    private Degree degree;
    private Vector<CourseStudent> courses;
    private double gpa;
    private Schedule schedule;

    private Faculty getFaculty() {
        return this.faculty;
    }
    
    private Degree getDegree() {
        return this.degree;
    }
    
    private Vector<CourseStudent> getCourses() {
        return this.courses;
    }
    private Vector<CourseStudent> setCourses(Vector<CourseStudent> courses) {
        this.courses = courses;
    }
    
    private double getGpa() {
        return this.gpa;
    }
    
    private Schedule getSchedule() {
        return this.schedule;
    }
    private Schedule setSchedule(Schedule schedule) {
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
    }
}
