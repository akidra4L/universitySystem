package classes;

import java.io.Serializable;

import users.Employee;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private Employee from;
    private Employee to;
    
    public Message(ID id, Employee from, Employee to) {
    	this.id = id;
    	this.from = from;
    	this.to = to;
    }

    public ID getId() {
        return this.id;
    }
    public void setId(ID id) {
        this.id = id;
    }

    public Employee getFrom() {
        return this.from;
    }
    public void setFrom(Employee from) {
        this.from = from;
    }

    public Employee getTo() {
        return this.to;
    }
    public void setTo(Employee to) {
        this.to = to;
    }

    public void sendMessage() {
        //TODO
    }
    public Message checkMessage() {
        //TODO
        return null;
    }
    
    
}
