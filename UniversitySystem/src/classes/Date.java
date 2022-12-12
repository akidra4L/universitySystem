package classes;

import enums.Semester;
import enums.WeekDay;

public class Date {
    private Time time;
    private int month;
    private int year;
    private WeekDay day;
    private Semester semester;
    
    public Date(Time time, int month, int year, WeekDay day, Semester semester) {
    	this.time = time;
    	this.month = month;
    	this.year = year;
    	this.day = day;
    	this.semester = semester;
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
    
    public WeekDay getDay() {
        return this.day;
    }
    public void setDay(WeekDay day) {
        this.day = day;
    }
    
    public Semester getSemester() {
        return this.semester;
    }
    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
