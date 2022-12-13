package users;

import java.util.Vector;

import classes.ID;
import classes.Lesson;
import classes.Request;
import enums.Faculty;
import enums.ManagerType;
import enums.Role;
import universitySystem.UniversitySystem;

public class Manager extends Employee {
	private Faculty faculty;
    private ManagerType type;
    
    public Manager(ID id, String name, Role role, double salary, Faculty faculty, ManagerType type) {
		super(id, name, role, salary);
		this.faculty = faculty;
		this.type = type;
		UniversitySystem.managers.add(this);
	}
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public ManagerType getType() {
        return this.type;
    }
    
    public void createNews() {
    	// TODO
    }

    public void manageNews() {
        // TODO
    }
    
    public void registerForCourse() {
        // TODO
    }
    
    public User viewUser() {
    	// TODO
        return null;
    }

    public Lesson viewLessonInfo() {
        //TODO
        return null;
    }

    public Vector<Request> viewRequests() {
        //TODO
        return null;
    }

    public Request getRequest() {
        //TODO
        return null;
    }
}
