package classes;

import enums.StateOfRequest;
import users.User;

public class Request {
    private ID id;
    private String description;
    private User from;
    private User to;
    private StateOfRequest state;
    
    public Request(ID id, String description, User from, User to, StateOfRequest state) {
    	this.id = id;
    	this.description = description;
    	this.from = from;
    	this.to = to;
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

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}    
}
