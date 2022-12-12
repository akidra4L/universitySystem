package classes;

import java.util.Vector;

import enums.Semester;

public class Transcript {
    private ID studentID;
    private Semester semester;
    private Vector<CourseStudent> courses;
    
    public Transcript(ID studentID, Semester semester, Vector<CourseStudent> courses) {
    	this.studentID = studentID;
    	this.semester = semester;
    	this.courses = courses;
    }
    
    public ID getStudentID() {
        return this.studentID;
    }

    public Semester getSemester() {
        return this.semester;
    }
    
    public Vector<CourseStudent> getCourses() {
        return this.courses;
    }
}
