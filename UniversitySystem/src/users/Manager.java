package users;

import enums.Faculty;
import enums.ManagerType;

public class Manager extends Employee {
    private Faculty faculty;
    private ManagerType type;
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public ManagerType getType() {
        return this.type;
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
