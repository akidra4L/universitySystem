package users;

import classes.ID;
import enums.Role;
import universitySystem.UniversitySystem;

public class User {
    private ID id;
    private String name;
    private Role role;
    
    public User(ID id, String name, Role role) {
    	this.id = id;
    	this.name = name;
    	this.role = role;
    	UniversitySystem.users.add(this);
    }

    public ID getId() {
        return this.id;
    }
    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public void Login() {
        //TODO
    }

    public void Logout() {
        //TODO
    }
    
    public void createRequest() {
        //TODO
    }
    
    public String toString() {
    	return this.id + " " + this.name + " " + this.role;
    }
}
