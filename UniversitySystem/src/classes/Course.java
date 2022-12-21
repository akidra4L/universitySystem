package classes;

import java.io.Serializable;

import enums.Faculty;
import enums.WeekDay;
import generators.GeneratorCourseCode;
import universitySystem.UniversitySystem;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private Faculty faculty;
    private int credits;
    private Date date;
    
    public Course(String code, String title, Faculty faculty, int credits, Date date) {
    	this.code = code;
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.date = date;
    	UniversitySystem.addCourse(this);
    }
    
    public Course(String title, Faculty faculty, int credits, WeekDay weekday, int hours, int minutes) {
    	this.code = GeneratorCourseCode.getCode(faculty);
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.date = new Date(weekday, new Time(hours, minutes));
    	UniversitySystem.addCourse(this);
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
    
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if(o == null) return false;
    	if(this.getClass() != o.getClass()) return false;
    	
    	Course c = (Course) o;
    	return this.code.equals(c.getCode()) && this.title.equals(c.getTitle()) && this.getCredits() == c.getCredits() && this.getFaculty().equals(c.getFaculty());
    }
    
    public String toString() {
    	return this.code + " " + this.title + " " + this.faculty + " " + this.credits + " " + this.date;
    }

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getWeekdayAndTime() {
		return this.title + ": " + this.getDate().getWeekdayAndTime();
	}
}
