package users;

import classes.ID;

/**
 * Employee class. Parent class for Teacher, Manager, Librarian etc
 */
public class Employee extends User {
	private static final long serialVersionUID = 1L;
	private double salary;
	
	/**
	 *  Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 */
    public Employee(ID id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}
    
    /**
     *  Default constructor
     * @param id
     * @param name
     */
    public Employee(ID id, String name) {
    	super(id, name);
    	this.salary = 0;
    }
    
    /**
     *  Default constructor
     * @param id
     * @param name
     * @param password
     */
    public Employee(ID id, String name, String password) {
    	super(id, name, password);
    	this.salary = 0;
    }

    /**
     * Getter for Employee's salary
     * @return Double
     */
    public double getSalary() {
        return this.salary;
    }
    /**
     * Setter for Employee's salary
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		
		Employee e = (Employee) o;
		return this.salary == e.getSalary();
	}
	
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return super.toString();
	} 
	
	/**
	 * Method, which shows information about Employee, using in Financial Manager
	 * @return
	 */
	public String viewInfoForFinancial() {
		return super.getId() + " " + super.getName() + " " + this.salary;
	}
	
}
