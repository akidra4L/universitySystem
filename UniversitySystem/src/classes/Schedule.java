package classes;

import java.util.Vector;

public class Schedule {
    private ID id;
    private Vector<Lesson> lessons;
    
    public Schedule(ID id, Vector<Lesson> lessons) {
    	this.id = id;
    	this.lessons = lessons;
    }
    
    public ID getId() {
        return this.id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    
    public Vector<Lesson> getLessons() {
        return this.lessons;
    }
    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }
}
