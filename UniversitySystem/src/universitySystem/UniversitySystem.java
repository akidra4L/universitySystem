package universitySystem;

import java.util.*;

import classes.Book;
import users.*;

public class UniversitySystem {
	private String name;
	protected static Vector<User> users = new Vector<User>();
	
	public UniversitySystem(String name) {
		this.name = name;
	}
	
	static {
		Vector<User> users = new Vector<User>();
		Vector<Book> books = new Vector<Book>();
	}
	
	public String getName() {
		return this.name;
	}
}
