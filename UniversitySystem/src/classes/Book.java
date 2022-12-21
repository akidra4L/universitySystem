package classes;

import java.io.Serializable;

import universitySystem.UniversitySystem;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID id;
    private String author;
    private String name;
    private boolean isAvailable;
    
    public Book(ID id, String author, String name, boolean isAvailable) {
    	this.id = id;
    	this.author = author;
    	this.name = name;
    	this.isAvailable = isAvailable;
    	UniversitySystem.addBook(this);
    }
    
    public Book(String author, String name) {
    	this.id = new ID();
    	this.author = author;
    	this.name = name;
    	this.isAvailable = true;
    	UniversitySystem.addBook(this);
    }
    
    public ID getId() {
        return this.id;
    }
    
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
