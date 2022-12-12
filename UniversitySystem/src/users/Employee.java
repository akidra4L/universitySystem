package users;

import classes.ID;
import enums.Role;

public class Employee extends User {
	private double salary;
	
    public Employee(ID id, String name, Role role, double salary) {
		super(id, name, role);
		this.salary = salary;
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
}
