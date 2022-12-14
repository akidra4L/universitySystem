package users;

import java.util.Vector;

import classes.ID;
import enums.Role;
import universitySystem.UniversitySystem;

public class Admin extends User {
    public Admin(ID id, String name, Role role) {
		super(id, name, role);
		UniversitySystem.addAdmin(this);
	}

	public void createUser(ID id, String name, Role role) {
		if(role == Role.Admin) {
			@SuppressWarnings("unused")
			Admin admin = new Admin(id, name, role);
		} else if (role == Role.Employee || role == Role.Librarian || role == Role.Teacher || role == Role.Manager) {
			if(role == Role.Employee) {
				@SuppressWarnings("unused")
				Employee employee = new Employee(id, name, role);
			} else if (role == Role.Librarian) {
				@SuppressWarnings("unused")
				Librarian librarian = new Librarian(id, name, role);
			} else if (role == Role.Teacher) {
				@SuppressWarnings("unused")
				Teacher teacher = new Teacher(id, name, role);
			} else if (role == Role.Manager) {
				@SuppressWarnings("unused")
				Manager manager = new Manager(id, name, role);
			}
		} else if (role == Role.Student) {
			@SuppressWarnings("unused")
			Student student = new Student(id, name, role);
		} else {
			System.out.println("Error: Unknown role.");
		}
    }
    
    public boolean deleteUser(ID id) {
    	Vector<User> users = UniversitySystem.getUsers();
    	for(User user: users) {
    		if(id.equals(user.getId())) {
    			users.remove(user);
    			UniversitySystem.setUsers(users);
    			if(user.getRole() == Role.Admin) {
    				Admin admin = (Admin) user;
    				UniversitySystem.removeAdmin(admin);
    			} else if (user.getRole() == Role.Employee) {
    				Employee employee = (Employee) user;
    				UniversitySystem.removeEmployee(employee);
    			} else if (user.getRole() == Role.Librarian) {
    				Librarian librarian = (Librarian) user;
    				UniversitySystem.removeLibrarian(librarian);
    			} else if (user.getRole() == Role.Manager) {
    				Manager manager = (Manager) user;
    				UniversitySystem.removeManager(manager);
    			} else if (user.getRole() == Role.Student) {
    				Student student = (Student) user;
    				UniversitySystem.removeStudent(student);
    			} else if (user.getRole() == Role.Teacher) {
    				Teacher teacher = (Teacher) user;
    				UniversitySystem.removeTeacher(teacher);
    			}
    			return true;
    		}
    	}
    	return false;
    }

    public void changeUserProfile() {
        //TODO
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
