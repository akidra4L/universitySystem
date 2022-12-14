package universitySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import classes.*;
import enums.*;
import users.*;
import view.viewAdminController;
import view.viewStudentController;
import view.viewTeacherController;
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
		Data.loadData();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			viewUserController.showUserMenu();
			System.out.print("Option: ");
			int command = Integer.parseInt(input.readLine());
			if(command == 1) {
				System.out.print("Login: ");
				String login = input.readLine();
				System.out.print("Password: ");
				String password = input.readLine();
				User u = login(login, password);
				
				boolean isLoged = true;
				while(isLoged) {
					if(u == null) {
						System.err.println("Error. Check login and password.\n");
						break;
						
					} else if (u.getRole() == Role.Admin) {
						Admin admin = (Admin) u;
						viewAdminController.showAdminMenu(admin);
						
						System.out.print("Option: ");
						int option = Integer.parseInt(input.readLine());
						if(option == 1) {
							System.out.print("New password: ");
							String newPassword = input.readLine();
							admin.setPassword(newPassword);
							System.out.println("---Done---");
						} else if (option == 2) {
							System.out.println("---All users---");
							for(User us: users) {
								System.out.println(us);
							}
							
						} else if (option == 3) {
							System.out.println("---Create user---");
							System.out.print("Name: ");
							String newUserName = input.readLine();
							System.out.print("Role: ");
							Role newUserRole = Role.of(input.readLine().toLowerCase());
							admin.createUser(new ID(), newUserName, newUserRole);
							System.out.println("---Done---");
							
						} else if (option == 4) {
							System.out.println("---Delete user---");
							System.out.print("ID: ");
							String deleteID = input.readLine();
							
							if(deleteID.equals(admin.getId().getNumberID())) {
								admin.deleteUser(deleteID);
								isLoged = false;
								System.out.println();
							} else {
								admin.deleteUser(deleteID);
							}
							System.out.println("---Done---");
							
						} else if (option == 5) {
							isLoged = false;
						}
						
					} else if (u.getRole() == Role.Student) {
						Student student = (Student) u;
						viewStudentController.showStudentMenu((Student) u);
						
						System.out.print("Option: ");
						int option = Integer.parseInt(input.readLine());
						if(option == 1) {
							System.err.print("New password: ");
							String newPassword = input.readLine();
							student.setPassword(newPassword);
							System.out.println("\n---Done---");
						}  else if (option == 2) {
							System.err.println("\n---Schedule---");
							System.out.println(student.getSchedule());
						} else if (option == 3) {
							System.err.println("\n---Marks---");
							for(CourseStudent cs: student.getCourses()) {
								System.out.println(cs.getTitle() + " - " + cs.getMark().getScore());
							}
						} else if (option == 4) {
							System.err.println("\n---Transcript---");
							System.out.println(student.getTranscript());
						}
						else if (option == 5) {
							isLoged = false;
						}
					} else if (u.getRole() == Role.Teacher) {
						viewTeacherController.showTeacherMenu((Teacher) u);
					}
				}
				
			} else if (command == 2) {
				System.err.println("\n---Bye---\n");
				break;
			}
		}
		
		input.close();
	}
}
