package universitySystem;

import java.util.*;

import classes.*;
import enums.*;
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
		Vector<News> news = new Vector<News>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void launch() {
		Admin admin = new Admin(new ID(), "admin", Role.Admin);
		users.add(admin);
		System.out.println(users);
	}
}
