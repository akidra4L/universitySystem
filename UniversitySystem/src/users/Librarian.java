package users;

import java.util.Vector;

import classes.Book;

public class Librarian extends Employee {
    private Vector<Book> books;
    
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
