package users;

import java.util.HashMap;
import java.util.Map;

import classes.Book;
import classes.ID;

/**
 * Librarian class
 */
public class Librarian extends Employee {
	private static final long serialVersionUID = 1L;
	private HashMap<Book, User> books;
	
	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 * @param books
	 */
	public Librarian(ID id, String name, double salary, HashMap<Book, User> books) {
		super(id, name, salary);
		this.books = books;
	}
	
	/**
	 * Default constructor
	 * @param id
	 * @param name
	 */
	public Librarian(ID id, String name) {
		super(id, name);
		this.books = new HashMap<Book, User>();
	}
	
	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 */
	public Librarian(ID id, String name, double salary) {
		super(id, name, salary);
	}
    
	/**
	 * Getter for get all books
	 * @return HashMap
	 */
    public HashMap<Book, User> getBooks() {
        return this.books;
    }
    
    /**
     * Setter for books
     * @param books
     */
    public void setBooks(HashMap<Book, User> books) {
        this.books = books;
    }

    /**
     * Method, which giving certain book to user
     * @param u
     * @param bookID
     * @return true if user is exists in System, false otherwise
     */
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
    
    /**
     * Method, which shows Books in library
     */
    public void viewBooks() {
    	books.keySet().forEach((key) -> System.out.println(key.getId().getNumberID() + " " + key.getName() + " " + key.getAuthor() + " " + key.getIsAvailable()));
    }
    
    /**
     * Method, adding Book to library by Book class
     * @param book
     */
    public void addBook(Book book) {
		books.put(book, null);
	}
    
    /**
     * Method, adding Book to library by Author and Title of Book
     * @param author
     * @param name
     */
    public void addBook(String author, String name) {
    	books.put(new Book(author, name), null);
    }
    
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return super.toString();
    }
}
