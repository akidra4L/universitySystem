package classes;

import java.io.Serializable;
import java.util.Vector;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private Vector<Course> lessons;
    
    public Schedule(ID id, Vector<Course> lessons) {
    	this.id = id;
    	this.lessons = lessons;
    }
    public Schedule(ID id) {
    	this.id = id;
    	this.lessons = new Vector<Course>();
    }
    
    public ID getId() {
        return this.id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    
    public Vector<Course> getLessons() {
        return this.lessons;
    }
    public void setLessons(Vector<Course> lessons) {
        this.lessons = lessons;
    }
    
    public String toString() {
    	return this.id + " " + this.lessons;
    }
}
