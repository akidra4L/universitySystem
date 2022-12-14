package users;

import java.util.Vector;

import classes.ID;
import classes.Lesson;
import classes.Request;
import enums.ManagerType;
import enums.Role;
import universitySystem.UniversitySystem;

public class Manager extends Employee {
    private ManagerType type;
    
    public Manager(ID id, String name, Role role, double salary, ManagerType type) {
		super(id, name, role, salary);
		this.type = type;
		UniversitySystem.addManager(this);
	}
    
    public Manager(ID id, String name, Role role) {
    	super(id, name, role);
    	this.type = ManagerType.Undefined;
    	UniversitySystem.addManager(this);
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
    
    public String toString() {
    	return super.toString() + " " + this.type;
    }
}
