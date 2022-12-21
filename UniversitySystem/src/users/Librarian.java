package users;

import java.util.HashMap;
import java.util.Map;

import classes.Book;
import classes.ID;

public class Librarian extends Employee {
	private static final long serialVersionUID = 1L;
	private HashMap<Book, User> books;
	
	public Librarian(ID id, String name, double salary, HashMap<Book, User> books) {
		super(id, name, salary);
		this.books = books;
	}
	
	public Librarian(ID id, String name) {
		super(id, name);
		this.books = new HashMap<Book, User>();
	}
	
	public Librarian(ID id, String name, double salary) {
		super(id, name, salary);
	}
    
    public HashMap<Book, User> getBooks() {
        return this.books;
    }
    public void setBooks(HashMap<Book, User> books) {
        this.books = books;
    }

    public boolean giveBook(User u, String bookID) {
    	for(Map.Entry<Book, User> hm: books.entrySet()) {
    		if(hm.getKey().getId().getNumberID().equals(bookID) && hm.getKey().getId().getIsAvailable()) {
    			books.put(hm.getKey(), u);
    			hm.getKey().setIsAvailable(false);
    			u.addBookToMyCollection(hm.getKey());
    			return true;
    		}
    	}
        return false;
    }
    
    public void viewBooks() {
    	books.keySet().forEach((key) -> System.out.println(key.getId().getNumberID() + " " + key.getName() + " " + key.getAuthor() + " " + key.getIsAvailable()));
    }
    
    public void addBook(Book book) {
		books.put(book, null);
	}
    
    public void addBook(String author, String name) {
    	books.put(new Book(author, name), null);
    }
    
    public String toString() {
    	return super.toString();
    }
}
