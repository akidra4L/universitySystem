package classes;

import java.io.Serializable;

import generators.GeneratorID;

/**
 * ID class, using for unique Objects
 *
 */
public class ID implements Serializable {
    private static final long serialVersionUID = 1L;
	private String numberID;
    private boolean isAvailable;
    private Date dateCreation;
    
    /**
     * Default constructor
     * @param numberID
     * @param isAvailable
     * @param dateCreation
     */
    public ID(String numberID, boolean isAvailable, Date dateCreation) {
    	this.numberID = numberID;
    	this.isAvailable = isAvailable;
    	this.dateCreation = dateCreation;
    }
    
    /**
     * Default constructor
     */
    public ID() {
    	this.numberID = GeneratorID.generateID();
    	this.isAvailable = true;
    	this.dateCreation = new Date(30, 8, 2022);
    }
    
    /**
     * Getter for ID's number of ID
     * @return String
     */
    public String getNumberID() {
        return this.numberID;
    }
    /**
     * Setter for ID's number of ID
     * @param numberID
     */
    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }
    
    /**
     * Getter for ID's availability
     * @return boolean
     */
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    /**
     * Setter for ID's availability
     * @param isAvailable
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    /**
     * Getter for ID's Date of Creation
     * @return Date
     */
    public Date getDateCreation() {
        return this.dateCreation;
    }
    /**
     * Setter for ID's Date of Creation
     * @param dateCreation
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return this.numberID;
    }
}
