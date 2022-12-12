package users;

import java.util.Vector;

import classes.Book;
import classes.ID;
import enums.Role;

public class Librarian extends Employee {
	private Vector<Book> books;
	
	public Librarian(ID id, String name, Role role, double salary, Vector<Book> books) {
		super(id, name, role, salary);
		this.books = books;
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
