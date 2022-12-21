package classes;

import generators.Semester;

import java.io.Serializable;

import enums.WeekDay;

/**
 * Date class, shows date about event
 *
 */
public class Date implements Serializable {
    private static final long serialVersionUID = 1L;
	private Time time;
    private int day;
    private int month;
    private int year;
    private WeekDay weekday;
    private Semester semester;
    
    /**
     * Default constructor
     * @param time
     * @param day
     * @param month
     * @param year
     * @param weekday
     * @param semester
     */
    public Date(Time time, int day, int month, int year, WeekDay weekday, Semester semester) {
    	this.time = time;
    	this.day = day;
    	this.month = month;
    	this.year = year;
    	this.weekday = weekday;
    	this.semester = semester;
    }
    /**
     * Default constructor
     * @param day
     * @param month
     * @param year
     */
    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }
    /**
     * Default constructor
     * @param weekday
     * @param time
     */
    public Date(WeekDay weekday, Time time) {
    	this.weekday =  weekday;
    	this.time = time;
    }
    
    /**
     * Method, which returns information about Weekday and Time of event
     * @return String
     */
    public String getWeekdayAndTime() {
    	return this.weekday + " " + this.time.toStandard();
    }
    
    /**
     * Getter for Date's Time
     * @return Time
     */
    public Time getTime() {
    	return this.time;
    }
    /**
     * Setter for Date's Time
     * @param time
     */
    public void setTime(Time time) {
    	this.time = time;
    }
    
    /**
     * Getter for Date's Month
     * @return Integer
     */
    public int getMonth() {
        return this.month;
    }
    /**
     * Setter for Date's Month
     * @param month
     */
    public void setMonth(Integer month) {
        this.month = month;
    }
    
    /**
     * Getter for Date's Year
     * @return Integer
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     * Setter for Date's Year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * Getter for Date's Weekday
     * @return Weekday
     */
    public WeekDay getWeekDay() {
        return this.weekday;
    }
    /**
     * Setter for Date's Weekday
     * @param weekday
     */
    public void setWeekDay(WeekDay weekday) {
        this.weekday = weekday;
    }
    
    /**
     * Getter for Date's Semester
     * @return Semester
     */
    public Semester getSemester() {
        return this.semester;
    }
    /**
     * Setter for Date's Semester
     * @param semester
     */
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     * Getter for Date's Day
     * @return Integer
     */
	public int getDay() {
		return day;
	}
	/**
	 * Setter for Date's Day
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.getWeekdayAndTime();
	}
}
