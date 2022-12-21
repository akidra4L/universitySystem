package classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import enums.WeekDay;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<Course, Date> lessons;
    
    public Schedule(HashMap<Course, Date> lessons) {
    	this.lessons = lessons;
    }
    public Schedule() {
    	this.lessons = new HashMap<Course, Date>();
    }
    
    public HashMap<Course, Date> getLessons() {
    	return this.lessons;
    }
    public void setLessons(HashMap<Course, Date> lessons) {
    	this.lessons = lessons;
    }
    
    public void getSchedule() {
    	for(Map.Entry<Course, Date> hm: lessons.entrySet()) {
    		System.out.println("- " + hm.getKey().getTitle() + " " + hm.getValue().getWeekdayAndTime());
    	}
    }
    
    public void addLesson(Course c, int hours, int minutes, WeekDay weekday) {
    	this.lessons.put(c, new Date(weekday, new Time(hours, minutes)));
    }
    
    public String toString() {
    	return this.lessons.toString();
    }
}
