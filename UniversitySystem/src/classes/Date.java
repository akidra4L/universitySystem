package classes;

import generators.Semester;

import java.io.Serializable;

import enums.WeekDay;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L;
	private Time time;
    private int day;
    private int month;
    private int year;
    private WeekDay weekday;
    private Semester semester;
    
    public Date(Time time, int day, int month, int year, WeekDay weekday, Semester semester) {
    	this.time = time;
    	this.day = day;
    	this.month = month;
    	this.year = year;
    	this.weekday = weekday;
    	this.semester = semester;
    }
    
    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }
    
    public Time getTime() {
    	return this.time;
    }
    public void setTime(Time time) {
    	this.time = time;
    }
    
    public int getMonth() {
        return this.month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public WeekDay getWeekDay() {
        return this.weekday;
    }
    public void setWeekDay(WeekDay weekday) {
        this.weekday = weekday;
    }
    
    public Semester getSemester() {
        return this.semester;
    }
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
