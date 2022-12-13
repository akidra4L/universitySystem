package universitySystem;

import java.io.IOException;
import java.util.*;

import classes.*;
import enums.*;
import users.*;

public class UniversitySystem {
	private String name;
	public static Vector<User> users = new Vector<User>();
	public static Vector<Admin> admins = new Vector<Admin>();
	public static Vector<Student> students = new Vector<Student>();
	public static Vector<Employee> employees = new Vector<Employee>();
	public static Vector<Teacher> teachers = new Vector<Teacher>();
	public static Vector<Librarian> librarians = new Vector<Librarian>();
	public static Vector<Manager> managers = new Vector<Manager>();
	public static Vector<Book> books = new Vector<Book>();
	public static Vector<News> news = new Vector<News>();
	
	public UniversitySystem(String name) {
		this.name = name;
	}
	
	static {
		Vector<User> users = new Vector<User>();
		Vector<Admin> admins = new Vector<Admin>();
		Vector<Student> students = new Vector<Student>();
		Vector<Employee> employees = new Vector<Employee>();
		Vector<Teacher> teachers = new Vector<Teacher>();
		Vector<Librarian> librarians = new Vector<Librarian>();
		Vector<Manager> managers = new Vector<Manager>();
		Vector<Book> books = new Vector<Book>();
		Vector<News> news = new Vector<News>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void launch() throws IOException {
		Admin admin = new Admin(new ID(), "admin", Role.Admin);
		System.out.println(users);
		admin.createUser(new ID(), "Alikhan", Role.Employee);
		System.out.println(employees);
	}
}
