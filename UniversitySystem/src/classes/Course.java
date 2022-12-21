package classes;

import java.io.Serializable;

import enums.Faculty;
import enums.WeekDay;
import generators.GeneratorCourseCode;
import universitySystem.UniversitySystem;

/**
 * Course class, using in Student and Teacher classes
 *
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private Faculty faculty;
    private int credits;
    private Date date;
    
    /**
     * Default constructor
     * @param code
     * @param title
     * @param faculty
     * @param credits
     * @param date
     */
    public Course(String code, String title, Faculty faculty, int credits, Date date) {
    	this.code = code;
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.date = date;
    	UniversitySystem.addCourse(this);
    }
    
    /**
     * Default constructor
     * @param title
     * @param faculty
     * @param credits
     * @param weekday
     * @param hours
     * @param minutes
     */
    public Course(String title, Faculty faculty, int credits, WeekDay weekday, int hours, int minutes) {
    	this.code = GeneratorCourseCode.getCode(faculty);
    	this.title = title;
    	this.faculty = faculty;
    	this.credits = credits;
    	this.date = new Date(weekday, new Time(hours, minutes));
    	UniversitySystem.addCourse(this);
    }
    
    /**
     * Getter for Course's Code
     * @return String
     */
    public String getCode() {
        return this.code;
    }
    /**
     * Setter for Course's Code
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Getter for Course's Title
     * @return String
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Setter for Course's Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Getter for Course's Faculty
     * @return Faculty
     */
    public Faculty getFaculty() {
        return this.faculty;
    }
    /**
     * Setter for Course's Faculty
     * @param faculty
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    /**
     * Getter for Course's Credits
     * @return Integer
     */
    public int getCredits() {
        return this.credits;
    }
    /**
     * Setter for Course's Credits
     * @param credits
     */
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
    
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return this.code + " " + this.title + " " + this.faculty + " " + this.credits + " " + this.date;
    }

    /**
     * Getter for Course's Date
     * @return Date
     */
	public Date getDate() {
		return date;
	}
	/**
	 * Setter for Course's Date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Method, which returns information about Course and his Date
	 * @return String
	 */
	public String getWeekdayAndTime() {
		return this.title + ": " + this.getDate().getWeekdayAndTime();
	}
	
	/**
	 * Method, which returns information about Couse's code, title and credits. Using in Student's transcript
	 * @return String
	 */
	public String viewTranscriptInfo() {
		return this.code + " " + this.title + " " + this.credits;
	}
}
