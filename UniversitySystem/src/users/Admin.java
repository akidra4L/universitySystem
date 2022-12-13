package users;

import classes.ID;
import enums.Role;
import universitySystem.UniversitySystem;

public class Admin extends User {
    public Admin(ID id, String name, Role role) {
		super(id, name, role);
		UniversitySystem.admins.add(this);
	}

	public void createUser(ID id, String name, Role role) {
		User user = new User(id, name, role);
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
