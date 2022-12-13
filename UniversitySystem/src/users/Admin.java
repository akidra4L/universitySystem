package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import classes.ID;
import enums.Role;
import universitySystem.UniversitySystem;

public class Admin extends User {
    public Admin(ID id, String name, Role role) {
		super(id, name, role);
		UniversitySystem.admins.add(this);
	}

	public void createUser(ID id, String name, Role role) throws IOException {
		if(role == Role.Admin) {
			@SuppressWarnings("unused")
			Admin admin = new Admin(id, name, role);
		} else if (role == Role.Employee) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter salary: ");
			double salary = Double.parseDouble(reader.readLine());
			
			@SuppressWarnings("unused")
			Employee employee = new Employee(id, name, role, salary);
		}
    }
    
    public void deleteUser() {
        //TODO
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
