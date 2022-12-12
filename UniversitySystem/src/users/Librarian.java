package users;

import java.util.Vector;

public class Librarian extends Employee {
    private Vector<Book> books;
    
    public Vector<Book> getBooks() {
        return this.books;
    }
    public Vector<Book> setBooks(Vector<Book> books) {
        this.books = books;
    }

    public void giveBook() {
        // TODO
    }
    
    public void givePermissionToLibrary() {
        //TODO
    }
}
