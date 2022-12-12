package classes;

import java.util.Vector;

import enums.Faculty;

public class Course {
    private ID id;
    private String code;
    private String title;
    private Faculty faculty;
    private int credits;
    private Vector<Course> prerequisite;
    
    public Course(ID id, String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite) {
    	this.id = id;
    	this.code = code;
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.prerequisite = prerequisite;
    }
    
    public ID getId() {
        return this.id;
    }
    public void setId(ID id) {
        this.id = id;
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
