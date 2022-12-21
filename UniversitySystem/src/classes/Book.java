package classes;

import java.io.Serializable;

import universitySystem.UniversitySystem;

/**
 * 
 * Book class
 *
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private String author;
    private String name;
    private boolean isAvailable;
    
    /**
     * Default constructor
     * @param id
     * @param author
     * @param name
     * @param isAvailable
     */
    public Book(ID id, String author, String name, boolean isAvailable) {
    	this.id = id;
    	this.author = author;
    	this.name = name;
    	this.isAvailable = isAvailable;
    	UniversitySystem.addBook(this);
    }
    
    /**
     * Default constructor
     * @param author
     * @param name
     */
    public Book(String author, String name) {
    	this.id = new ID();
    	this.author = author;
    	this.name = name;
    	this.isAvailable = true;
    	UniversitySystem.addBook(this);
    }
    
    /**
     * Getter for Book's ID
     * @return book's id
     */
    public ID getId() {
        return this.id;
    }
    
    /**
     * Getter for Author of Book
     * @return book's author
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * Setter for Author of Book
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for Title of Book
     * @return book's title
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Setter for Title of Book
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for Availability of Book
     * @return book's availability
     */
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    
    /**
     * Setter for Availability of Book.
     * @param isAvailable
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return this.author + " " + this.name;
    }
}
