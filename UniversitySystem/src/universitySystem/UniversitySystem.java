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
	
	static {
		users = new Vector<User>();
		admins = new Vector<Admin>();
		students = new Vector<Student>();
		employees = new Vector<Employee>();
		teachers = new Vector<Teacher>();
		librarians = new Vector<Librarian>();
		managers = new Vector<Manager>();
		books = new Vector<Book>();
		news = new Vector<News>();
	}
	
	public UniversitySystem(String name) {
		this.name = name;
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
	public static void removeAdmin(Admin a) {
		admins.remove(a);
	}
	
	public static void addStudent(Student s) {
		students.add(s);
	}
	public static void removeStudent(Student s) {
		students.remove(s);
	}
	
	public static void addEmployee(Employee e) {
		employees.add(e);
	}
	public static void removeEmployee(Employee e) {
		employees.remove(e);
	}
	
	public static void addTeacher(Teacher t) {
		teachers.add(t);
	}
	public static void removeTeacher(Teacher t) {
		teachers.remove(t);
	}
	
	public static void addLibrarian(Librarian l) {
		librarians.add(l);
	}
	public static void removeLibrarian(Librarian l) {
		librarians.remove(l);
	}
	
	public static void addManager(Manager m) {
		managers.add(m);
	}
	public static void removeManager(Manager m) {
		managers.remove(m);
	}
	
	public static void addBook(Book b) {
		books.add(b);
	}
	public static void addNews(News n) {
		news.add(n);
	}
	
	public static Vector<User> getUsers() {
		return users;
	}
	public static void setUsers(Vector<User> users) {
		UniversitySystem.users = users;
	}
	
	public void launch() throws IOException {
		Admin admin = new Admin(new ID(), "admin", Role.Admin);
		System.out.println(users);
		admin.createUser(new ID(), "Alikhan", Role.Manager);
		ID id = UniversitySystem.managers.get(0).getId();
		System.out.println(managers);
		
		admin.deleteUser(id);
		System.out.println(id);
		System.out.println(teachers);
	}
}
