package classes;

import java.io.Serializable;

import universitySystem.UniversitySystem;

/**
 * News class
 *
 */
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
	private String author;
    private String title;
    private String description;
    
    /**
     * Default constructor
     * @param author
     * @param title
     * @param description
     */
    public News(String author, String title, String description) {
    	this.author = author;
    	this.title = title;
    	this.description = description;
    	UniversitySystem.addNews(this);
    }
    
    /**
     * Getter for News Author
     * @return String
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Setter for News Author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Getter for News Title
     * @return String
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Setter for News Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Getter for News Description
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Setter for News Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if(o == null) return false;
    	if(this.getClass() != o.getClass()) return false;
    	
    	News n = (News) o;
    	return this.author.equals(n.getAuthor()) && this.title.equals(n.getTitle()) && this.description.equals(n.getDescription());
    }
    
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return "Author: " + this.author + " Title: " + this.title + " Description: " + this.description;
    }
}
