package classes;

import users.Manager;

public class News {
    private ID id;
    private Manager author;
    private String title;
    private String description;
    
    public News(ID id, Manager author, String title, String description) {
    	this.id = id;
    	this.author = author;
    	this.title = title;
    	this.description = description;
    }
    
    public ID getId() {
        return this.id;
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
}
