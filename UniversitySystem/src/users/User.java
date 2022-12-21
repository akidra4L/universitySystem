package users;

import java.io.Serializable;
import java.util.Vector;

import classes.Book;
import classes.ID;
import classes.Request;
import universitySystem.UniversitySystem;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private ID id;
	private String name;
	private String password;
	private Vector<Book> books;

	public User(ID id, String name) {
		this.id = id;
		this.name = name;
		this.password = id.getNumberID();
		this.books = new Vector<Book>();
		UniversitySystem.addUser(this);
	}

	public User(ID id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.books = new Vector<Book>();
		UniversitySystem.addUser(this);
	}

	public ID getId() {
		return this.id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHashCode() {
		return this.password.hashCode();
	}

	public void createRequest() {
		// TODO
	}

	public Vector<Book> getMyBooks() {
		return books;
	}

	public void setBooks(Vector<Book> books) {
		this.books = books;
	}

	public void addBookToMyCollection(Book book) {
		books.add(book);
	}

//Aba start
	public void sendRequest(Request r) {
//		Request request = new Request(r.getId(), r.getDescription(), this, r.getDepartment(), r.getState());
		UniversitySystem.processRequest(r);
	}

//Aba end

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

	public String toString() {
		return this.id + " " + this.name;
	}
}
