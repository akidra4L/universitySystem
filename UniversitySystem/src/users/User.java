package users;

import java.io.Serializable;
import java.util.Vector;

import classes.Book;
import classes.ID;
import classes.Request;
import universitySystem.UniversitySystem;

/**
 * User class
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private ID id;
	private String name;
	private String password;
	private Vector<Book> books;

	/**
	 * Default constructor. Constructor initializing the fields of user class.
	 * @param id
	 * @param name
	 */
	public User(ID id, String name) {
		this.id = id;
		this.name = name;
		this.password = id.getNumberID();
		this.books = new Vector<Book>();
		UniversitySystem.addUser(this);
	}

	/**
	 * Default constructor. Constructor initializing the fields of user class.
	 * @param id
	 * @param name
	 * @param password
	 */
	public User(ID id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.books = new Vector<Book>();
		UniversitySystem.addUser(this);
	}

	/**
	 * Getter for User's ID
	 * @return ID
	 */
	public ID getId() {
		return this.id;
	}
	/**
	 * Setter for User's ID
	 */
	public void setId(ID id) {
		this.id = id;
	}

	/**
	 * Getter for User's name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter for User's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for User's password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for User's password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for User's password in hash representation
	 * @return Integer
	 */
	public int getHashCode() {
		return this.password.hashCode();
	}

	/**
	 * Getter for User's books
	 * @return String
	 */
	public Vector<Book> getMyBooks() {
		return books;
	}

	/**
	 * Setter for User's books
	 * @param books
	 */
	public void setBooks(Vector<Book> books) {
		this.books = books;
	}

	/**
	 * Method, which is adding book to User's collection
	 * @param book
	 */
	public void addBookToMyCollection(Book book) {
		books.add(book);
	}

	/**
	 * User can send request to Manager
	 * @param request
	 */
	public void sendRequest(Request r) {
		Manager.processRequest(r);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;

		User u = (User) o;
		return this.id.equals(u.getId()) && this.name.equals(u.getName()) && this.password.equals(u.getPassword());
	}

	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.id + " " + this.name;
	}
}
