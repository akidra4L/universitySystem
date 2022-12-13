package universitySystem;

import java.io.IOException;
import java.util.*;

import classes.*;
import enums.*;
import users.*;

public class UniversitySystem {
	private String name;
	private static Vector<User> users;
	private static Vector<Admin> admins;
	private static Vector<Student> students;
	private static Vector<Employee> employees;
	private static Vector<Teacher> teachers;
	private static Vector<Librarian> librarians;
	private static Vector<Manager> managers;
	private static Vector<Book> books;
	private static Vector<News> news;
	
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
	
	public static void addUser(User u) {
		users.add(u);
	}
	public static void addAdmin(Admin a) {
		admins.add(a);
	}
	public static void addStudent(Student s) {
		students.add(s);
	}
	public static void addEmployee(Employee e) {
		employees.add(e);
	}
	public static void addTeacher(Teacher t) {
		teachers.add(t);
	}
	public static void addLibrarian(Librarian l) {
		librarians.add(l);
	}
	public static void addManager(Manager m) {
		managers.add(m);
	}
	public static void addBook(Book b) {
		books.add(b);
	}
	public static void addNews(News n) {
		news.add(n);
	}
	
	public void launch() throws IOException {
		Admin admin = new Admin(new ID(), "admin", Role.Admin);
		System.out.println(users);
		admin.createUser(new ID(), "Alikhan", Role.Librarian);
		System.out.println(librarians);
	}
}
