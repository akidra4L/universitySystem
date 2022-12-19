package classes;

import java.io.Serializable;
import java.util.Vector;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private Vector<Lesson> lessons;
    
    public Schedule(ID id, Vector<Lesson> lessons) {
    	this.id = id;
    	this.lessons = lessons;
    }
    public Schedule(ID id) {
    	this.id = id;
    	this.lessons = new Vector<Lesson>();
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
    
    public String toString() {
    	return this.id + " " + this.lessons;
    }
}
