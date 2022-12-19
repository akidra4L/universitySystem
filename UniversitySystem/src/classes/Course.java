package classes;

import java.io.Serializable;
import java.util.Vector;

import enums.Faculty;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private Faculty faculty;
    private int credits;
    private Vector<Course> prerequisite;
    
    public Course(String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite) {
    	this.code = code;
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.prerequisite = prerequisite;
    }
    
    public Course(String title, Faculty faculty, int credits) {
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    }
    
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public int getCredits() {
        return this.credits;
    }
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    
    public Vector<Course> getPrerequisite() {
        return this.prerequisite;
    }
    public void setPrerequisite(Vector<Course> prerequisite) {
        this.prerequisite = prerequisite;
    }
}
