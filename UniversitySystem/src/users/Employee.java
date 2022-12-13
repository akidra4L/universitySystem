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
		UniversitySystem.employees.add(this);
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
}
