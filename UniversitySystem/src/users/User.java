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

    private String getName() {
        return this.name;
    }
    private void setName(String name) {
        this.name = name;
    }
    
    private Role getRole() {
        return this.role;
    }
    private void setRole(Role role) {
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
