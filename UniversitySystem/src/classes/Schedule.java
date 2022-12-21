package classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import enums.WeekDay;

/**
 * Schedule class
 *
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<Course, Date> lessons;
    
    /**
     * Default constructor
     * @param lessons
     */
    public Schedule(HashMap<Course, Date> lessons) {
    	this.lessons = lessons;
    }
    /**
     *  Default constructor
     */
    public Schedule() {
    	this.lessons = new HashMap<Course, Date>();
    }
    
    /** 
     * Getter for Lessons
     * @return HashMap<Course, Date> 
     */
    public HashMap<Course, Date> getLessons() {
    	return this.lessons;
    }
    /**
     * Setter for Lessons
     * @param lessons
     */
    public void setLessons(HashMap<Course, Date> lessons) {
    	this.lessons = lessons;
    }
    /**
     * Showing Schedule, using in Student and Teacher
     */
    public void getSchedule() {
    	for(Map.Entry<Course, Date> hm: lessons.entrySet()) {
    		System.out.println("- " + hm.getKey().getTitle() + " " + hm.getValue().getWeekdayAndTime());
    	}
    }
    
    /**
     * Method, which is adding Lesson
     * @param c
     * @param hours
     * @param minutes
     * @param weekday
     */
    public void addLesson(Course c, int hours, int minutes, WeekDay weekday) {
    	this.lessons.put(c, new Date(weekday, new Time(hours, minutes)));
    }
    
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return this.lessons.toString();
    }
}
