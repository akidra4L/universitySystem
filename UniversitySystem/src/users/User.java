package users;

import classes.ID;
import enums.Role;
import universitySystem.UniversitySystem;

public class User {
    private ID id;
    private String name;
    private String password;
    private Role role;
    
    public User(ID id, String name, Role role) {
    	this.id = id;
    	this.name = name;
    	this.password = id.getNumberID();
    	this.role = role;
    	UniversitySystem.addUser(this);
    }
    
    public User(ID id, String name, String password, Role role) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.role = role;
    	UniversitySystem.addUser(this);
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
    
    public String getPassword() {
		return password;
    }
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHashCode() {
		return this.password.hashCode();
	}
    
    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public void Logout() {
        //TODO
    }
    
    public void createRequest() {
        //TODO
    }
    
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if(o == null) return false;
    	if(this.getClass() != o.getClass()) return false;
    	
    	User u = (User) o;
    	return this.id.equals(u.getId()) && this.name.equals(u.getName()) && this.role.equals(u.getRole()) && this.password.equals(u.getPassword());
    }
    
    public String toString() {
    	return this.id + " " + this.name + " " + this.role;
    }
}
