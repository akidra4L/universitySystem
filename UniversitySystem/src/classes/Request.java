package classes;

import java.io.Serializable;

import enums.StateOfRequest;
import users.User;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private String description;
    private User from;
    private StateOfRequest state;
    
    public Request(ID id, String description, User from, StateOfRequest state) {
    	this.id = id;
    	this.description = description;
    	this.from = from;
    	this.state = state;
    }
    
    public ID getId() {
        return this.id;
    }
    
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public User getFrom() {
        return this.from;
    }
    public void setFrom(User from) {
        this.from = from;
    }
    
    public StateOfRequest getState() {
        return this.state;
    }
    
    public void setState(StateOfRequest state) {
        this.state = state;
    }  
}
