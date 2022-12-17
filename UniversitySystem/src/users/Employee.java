package users;

import java.util.Vector;

import classes.ID;
import classes.Message;

public class Employee extends User {
	private double salary;
	private Vector<Message> messages;
	
    public Employee(ID id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}
    
    public Employee(ID id, String name) {
    	super(id, name);
    	this.salary = 0;
    	this.messages = new Vector<Message>();
    }
    
    public Employee(ID id, String name, String password) {
    	super(id, name, password);
    	this.salary = 0;
    	this.messages = new Vector<Message>();
    }

    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void createMessage() {
    	// TODO
    }

	public Vector<Message> getMessages() {
		return messages;
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		
		Employee e = (Employee) o;
		return this.salary == e.getSalary() && this.messages.equals(e.getMessages());
	}
	
	public String toString() {
		return super.toString() + " " + this.salary + " " + this.messages;
	} 
	
}
