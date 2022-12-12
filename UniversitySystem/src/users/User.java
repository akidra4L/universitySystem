package users;

import classes.ID;
import enums.Role;

public class User {
    private ID id;
    private String name;
    private Role role;

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
    
    public void makeRequest() {
        //TODO
    }
}
