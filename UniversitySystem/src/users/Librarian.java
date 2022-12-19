package users;

import java.util.Vector;

import classes.Book;
import classes.ID;
import universitySystem.UniversitySystem;

public class Librarian extends Employee {
	private static final long serialVersionUID = 1L;
	private Vector<Book> books;
	
	public Librarian(ID id, String name, double salary, Vector<Book> books) {
		super(id, name, salary);
		this.books = books;
	}
	
	public Librarian(ID id, String name) {
		super(id, name);
		this.books = new Vector<Book>();
	}
	
	public Librarian(ID id, String name, double salary) {
		super(id, name, salary);
	}
	
	public void addBook(Book book) {
		UniversitySystem.addBook(book);
	}
    
    public Vector<Book> getBooks() {
        return this.books;
    }
    public void setBooks(Vector<Book> books) {
        this.books = books;
    }

    public void giveBook() {
        // TODO
    }
    
    public void givePermissionToLibrary() {
        //TODO
    }
}
