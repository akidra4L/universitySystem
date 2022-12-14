package universitySystem;

import java.io.IOException;
import java.util.*;

import classes.*;
import enums.*;
import users.*;
import view.viewStudentController;
import view.viewUserController;

public class UniversitySystem {
	private String name;
	static Vector<User> users;
	static Vector<Admin> admins;
	static Vector<Student> students;
	static Vector<Employee> employees;
	static Vector<Teacher> teachers;
	static Vector<Librarian> librarians;
	static Vector<Manager> managers;
	static Vector<Book> books;
	static Vector<News> news;
	
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
	static void addAdmin(Admin a) {
		admins.add(a);
	}
	static void removeAdmin(Admin a) {
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
	static void setUsers(Vector<User> users) {
		UniversitySystem.users = users;
	}
	
	public static Vector<News> getNews() {
		return news;
	}
	public static void setNews(Vector<News> news) {
		UniversitySystem.news = news;
	}
	
	public User findUser(User u) {
		if(users.contains(u)) {
			return u;
		}
		return null;
	}
	
	public User login(String name, String password) {
		for(User u: users) {
			if(u.getName().equals(name) && u.getPassword().equals(password)) {
				return u;
			}
 		}
		return null;
	}
	
	void launch() throws IOException {
		viewUserController.showUserMenu();
		Admin admin = new Admin(new ID(), "admin", Role.Admin);
		System.out.println(users);
		admin.createUser(new ID(), "Alikhan", Role.Student);
		System.out.println(users);
		System.out.println(users.elementAt(1).getPassword());
		users.elementAt(1).setPassword("123");
		System.out.println(login("Alikhan", "123"));
		viewStudentController.showStudentMenu((Student) login("Alikhan", "123"));
	}
}
