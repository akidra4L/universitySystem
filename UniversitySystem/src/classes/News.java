package classes;

import java.io.Serializable;

import universitySystem.UniversitySystem;
import users.Manager;

public class News implements Serializable {
    private static final long serialVersionUID = 1L;
	private Manager author;
    private String title;
    private String description;
    
    public News(Manager author, String title, String description) {
    	this.author = author;
    	this.title = title;
    	this.description = description;
    	UniversitySystem.addNews(this);
    }
    
    public Manager getAuthor() {
        return this.author;
    }
    public void setAuthor(Manager author) {
        this.author = author;
    }
    
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return this.description;
    }
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
    
    public String toString() {
    	return this.author + " " + this.title + " " + this.description;
    }
}
