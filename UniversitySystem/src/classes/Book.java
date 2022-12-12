package classes;

public class Book {
    private ID id;
    private String author;
    private String name;
    private boolean isAvailable;
    
    public Book(ID id, String author, String name, boolean isAvailable) {
    	this.id = id;
    	this.author = author;
    	this.name = name;
    	this.isAvailable = isAvailable;
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
