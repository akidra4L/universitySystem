package users;

import java.util.Vector;

import classes.ID;
import classes.Message;
import enums.Role;
import universitySystem.UniversitySystem;

public class Employee extends User {
	private double salary;
	private Vector<Message> messages;
	
    public Employee(ID id, String name, Role role, double salary) {
		super(id, name, role);
		this.salary = salary;
		UniversitySystem.addEmployee(this);
	}
    
    public Employee(ID id, String name, Role role) {
    	super(id, name, role);
    	this.salary = 0;
    	this.messages = new Vector<Message>();
    	UniversitySystem.addEmployee(this);
    }
    
    public Employee(ID id, String name, String password, Role role) {
    	super(id, name, password, role);
    	this.salary = 0;
    	this.messages = new Vector<Message>();
    	UniversitySystem.addEmployee(this);
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
