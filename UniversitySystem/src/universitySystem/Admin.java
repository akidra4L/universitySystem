package universitySystem;

import java.io.Serializable;
import java.util.Vector;

import classes.*;
import enums.*;
import users.*;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 1L;

	public Admin(ID id, String name) {
		super(id, name);
	}
    
    public Admin(ID id, String name, String password) {
		super(id, name, password);
	}

	public void createUser(ID id, String name, Role role) {
		if(role == Role.Admin) {
			@SuppressWarnings("unused")
			Admin admin = new Admin(id, name);
		} else if (role == Role.Employee || role == Role.Librarian || role == Role.Teacher || role == Role.Manager) {
			if(role == Role.Employee) {
				@SuppressWarnings("unused")
				Employee employee = new Employee(id, name);
			} else if (role == Role.Librarian) {
				@SuppressWarnings("unused")
				Librarian librarian = new Librarian(id, name);
			} else if (role == Role.Teacher) {
				@SuppressWarnings("unused")
				Teacher teacher = new Teacher(id, name);
			} else if (role == Role.Manager) {
				@SuppressWarnings("unused")
				Manager manager = new Manager(id, name);
			}
		} else if (role == Role.Student) {
			@SuppressWarnings("unused")
			Student student = new Student(id, name);
		} else {
			System.out.println("Error: Unknown role.");
		}
    }
	
	public void createUser(ID id, String name, ManagerType type) {
		new Manager(id, name, type);
    }
    
    public boolean deleteUser(ID id) {
    	Vector<User> users = UniversitySystem.getUsers();
    	for(User user: users) {
    		if(id.equals(user.getId())) {
    			users.remove(user);
    			UniversitySystem.setUsers(users);
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean deleteUser(String id) {
    	Vector<User> users = UniversitySystem.getUsers();
    	for(User user: users) {
    		if(id.equals(user.getId().getNumberID())) {
    			users.remove(user);
    			UniversitySystem.setUsers(users);
    			return true;
    		}
    	}
    	return false;
    }

    public void updateSoftware() {
        //TODO
    }
    
    public void manageServer() {
        //TODO
    }

    public void restoreData() {
        //TODO
    }
    
    public void backupData() {
        //TODO
    }
    
    public String toString() {
    	return super.toString();
    }
}
