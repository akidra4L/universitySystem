package classes;

import java.io.Serializable;

import generators.GeneratorID;

public class ID implements Serializable {
    private static final long serialVersionUID = 1L;
	private String numberID;
    private boolean isAvailable;
    private Date dateCreation;
    
    public ID(String numberID, boolean isAvailable, Date dateCreation) {
    	this.numberID = numberID;
    	this.isAvailable = isAvailable;
    	this.dateCreation = dateCreation;
    }
    
    public ID() {
    	this.numberID = GeneratorID.generateID();
    	this.isAvailable = true;
    	this.dateCreation = new Date(30, 8, 2022);
    }
    
    public String getNumberID() {
        return this.numberID;
    }
    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }
    
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public String toString() {
    	return this.numberID;
    }
}
