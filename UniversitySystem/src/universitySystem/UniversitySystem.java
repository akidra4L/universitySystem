package universitySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import classes.*;
import enums.*;
import users.*;
import view.viewAdminController;
import view.viewManagerController;
import view.viewStudentController;
import view.viewTeacherController;
import view.viewUserController;

public class UniversitySystem {
	public static String name;
	static Vector<User> users;
	static Vector<Course> courses;
	static Vector<Book> books;
	static Vector<News> news;
	
	static {
		courses = new Vector<Course>();
		users = new Vector<User>();
		new UsersData();
		new CoursesData();
		books = new Vector<Book>();
		news = new Vector<News>();
	}
	
	public UniversitySystem(String name) {
		UniversitySystem.name = name;
	}
	
	public static void addUser(User u) {
		users.add(u);
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
	
	public void exit() throws Exception {
		System.err.println("\n---Bye---\n");
		UsersData.saveUsers();
		CoursesData.saveCourses();
	}
	
	void launch() throws Exception {
		System.out.println("--- " + name + " ---");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			menu: while(true) {
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
							System.err.println("\nError. Check login and password.\n");
							break;
							
						} else if (u instanceof Admin) {
							Admin admin = (Admin) u;
							viewAdminController.showAdminMenu(admin);
								
							System.out.print("Option: ");
							int option = Integer.parseInt(input.readLine());
							if(option == 1) {
								System.out.println("---Change password---");
								System.out.print("New password: ");
								String newPassword = input.readLine();
								admin.setPassword(newPassword);
								System.out.println("\n---Done---");
							} else if (option == 2) {
								System.out.println("\n---All users---");
								for(User us: users) {
									System.out.println(us);
								}
									
							} else if (option == 3) {
								System.out.println("\n---Create user---");
								System.out.print("Name: ");
								String newUserName = input.readLine();
								System.out.print("Role: ");
								Role newUserRole = Role.of(input.readLine().toLowerCase());
								
								if (newUserRole == Role.Manager) {
									System.out.print("Manager type: ");
									ManagerType managerType = ManagerType.of(input.readLine().toLowerCase());
									
									admin.createUser(new ID(), newUserName, managerType);
								} else {
									admin.createUser(new ID(), newUserName, newUserRole);
								}
								System.out.println("\n---Done---");
									
							} else if (option == 4) {
								System.out.println("\n---Delete user---");
								System.out.print("ID: ");
								String deleteID = input.readLine();
									
								if(deleteID.equals(admin.getId().getNumberID())) {
									admin.deleteUser(deleteID);
									isLoged = false;
									System.out.println();
								} else {
									admin.deleteUser(deleteID);
								}
								System.out.println("\n---Done---");
									
							} else if (option == 5) {
									isLoged = false;
							}
								
						} else if (u instanceof Student) {
							Student student = (Student) u;
							viewStudentController.showStudentMenu((Student) u);
								
							System.out.print("Option: ");
							int option = Integer.parseInt(input.readLine());
							if(option == 1) {
								System.out.println("---Change password---");
								System.err.print("New password: ");
								String newPassword = input.readLine();
								student.setPassword(newPassword);
								System.out.println("\n---Done---");
							}  else if (option == 2) {
								System.err.println("\n---Schedule---");
								System.out.println(student.getSchedule());
							} else if (option == 3) {
								System.err.println("\n---Marks---");
								for(StudentCourse cs: student.getCourses()) {
									System.out.println(cs.getTitle() + " - " + cs.getMark().getScore());
								}
							} else if (option == 4) {
								System.err.println("\n---Transcript---");
								System.out.println(student.getTranscript());
							}
							else if (option == 5) {
								isLoged = false;
							}
						} else if (u instanceof Teacher) {
							Teacher teacher = (Teacher) u;
							viewTeacherController.showTeacherMenu((Teacher) u);
								
							System.out.print("Option: ");
							int option = Integer.parseInt(input.readLine());
							if(option == 1) {
								System.out.println("---Change password---");
								System.err.print("New password: ");
								String newPassword = input.readLine();
								teacher.setPassword(newPassword);
								System.out.println("---Done---");
							} else if (option == 2) {
								System.err.println("\n---Schedule---");
								System.out.println(teacher.getSchedule());
							} else if (option == 3) {
								System.out.print("\n---Setting mark---");
									
							}
						} else if (u instanceof Manager) {
							Manager manager = (Manager) u;
							viewManagerController.showManagerMenu(manager);
							
							System.out.print("Option: ");
							int option = Integer.parseInt(input.readLine());
							if(option == 7) {
								isLoged = false;
							} else if (option == 1) {
								System.err.print("New password: ");
								String newPassword = input.readLine();
								manager.setPassword(newPassword);
								System.out.println("---Done---");
							} else if (option == 2) {
								System.err.println("\n---All students---");
								System.out.println(manager.viewStudents());
							} else if (option == 3) {
								System.out.println("\n---View student---");
								System.out.print("ID: ");
								String studentID = input.readLine();
								
								System.out.println(manager.viewStudent(studentID));
								System.out.println("\n---Done---");
							} else if (option == 4) {
								System.out.println("---News---");
								System.out.println(news);
								System.out.println("---Done---");
							} else if (option == 5) {
								System.out.println("\n---News creation---");
								System.out.print("Title: ");
								String title = input.readLine();
								System.out.print("Description: ");
								String description = input.readLine();
								
								manager.createNews(title, description);
								System.out.println("\n---Done---");
							} else if (option == 6) {
								System.out.println("\n---Delete news---");
								System.out.print("Author: ");
								String author = input.readLine();
								System.out.print("Title: ");
								String title = input.readLine();
								System.out.print("Description: ");
								String description = input.readLine();
								
								manager.deleteNews(author, title, description);
								System.out.println("\n---Done---");
							}
						}
					}
						
				} else if (command == 2) {
					exit();
					break menu;
				}
			}
		} catch (IOException e) {
			System.err.print("Error: saving data");
			exit();
		}
		input.close();
	}
}
