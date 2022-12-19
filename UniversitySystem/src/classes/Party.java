package classes;

import java.io.Serializable;

import users.User;

public class Party implements Serializable {
    private static final long serialVersionUID = 1L;
	private String title;
    private String description;
    private User organizator;
    
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public User getOrganizator() {
        return this.organizator;
    }
    public void setOrganizator(User organizator) {
        this.organizator = organizator;
    }
}
