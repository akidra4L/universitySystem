package universitySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import classes.*;
import enums.*;
import users.*;
import view.*;

public class UniversitySystem {
	public static String name;
	static Vector<User> users;
	static Vector<Course> courses;
	static Vector<Book> books;
	static Vector<News> news;
	static List<Request> requests;

	static {
		users = new Vector<User>();
		courses = new Vector<Course>();
		news = new Vector<News>();
		books = new Vector<Book>();
		requests = new ArrayList<Request>();
		new UsersData();
		new CoursesData();
		new NewsData();
		new BooksData();
		new RequestsData();
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

	public static void addCourse(Course c) {
		courses.add(c);
	}
	public static void addRequest(Request r) {
		requests.add(r);
	}
	public static List<Request> getRequests() {
		return requests;
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

	public static Vector<Course> getCourse() {
		return courses;
	}

	public static void setCourses(Vector<Course> courses) {
		UniversitySystem.courses = courses;
	}

	public User findUser(User u) {
		if (users.contains(u)) {
			return u;
		}
		return null;
	}

	public User findUser(String id) {
		for (User u : users) {
			if (u.getId().getNumberID().equals(id)) {
				return u;
			}
		}
		return null;
	}

	public static Course findCourse(String code) {
		for (Course c : courses) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}

	public User login(String name, String password) {
		for (User u : users) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

	public void exit() throws Exception {
		System.err.println("\n---Bye---\n");
		UsersData.saveUsers();
		CoursesData.saveCourses();
		NewsData.saveNews();
		BooksData.saveBooks();
		RequestsData.saveRequests();
	}

	void launch() throws Exception {
		System.out.println("--- " + name + " ---");

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			menu: while (true) {
				viewUserController.showUserMenu();
				System.out.print("Option: ");
				int command = Integer.parseInt(input.readLine());
				try {
					if (command == 1) {
						System.out.print("Login: ");
						String login = input.readLine();
						System.out.print("Password: ");
						String password = input.readLine();
						User u = login(login, password);

						boolean isLoged = true;
						while (isLoged) {
							if (u == null) {
								System.err.println("\nError. Check login and password.\n");
								break;

							} else if (u instanceof Admin) {
								Admin admin = (Admin) u;
								viewAdminController.showAdminMenu(admin);

								System.out.print("Option: ");
								int option = Integer.parseInt(input.readLine());
								if (option == 1) {
									System.out.println("---Change password---");
									System.out.print("New password: ");
									String newPassword = input.readLine();
									admin.setPassword(newPassword);
									System.out.println("\n---Done---");
								} else if (option == 2) {
									System.out.println("---Create Request---");
									System.out.print("Description: ");
									String description = input.readLine();
									
									admin.sendRequest(new Request(admin, description));
									System.out.println("\n---Done---");
								} else if (option == 3) {
									System.out.println("\n---All users---");
									for (User us : users) {
										System.out.println(us);
									}

								} else if (option == 4) {
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

								} else if (option == 5) {
									System.out.println("\n---Delete user---");
									System.out.print("ID: ");
									String deleteID = input.readLine();

									if (deleteID.equals(admin.getId().getNumberID())) {
										admin.deleteUser(deleteID);
										isLoged = false;
										System.out.println();
									} else {
										admin.deleteUser(deleteID);
									}
									System.out.println("\n---Done---");

								} else if (option == 6) {
									isLoged = false;
								} else {
									System.err.println("Error: wrong option");
								}
							} else if (u instanceof Student) {
								Student student = (Student) u;
								viewStudentController.showStudentMenu((Student) u);

								System.out.print("Option: ");
								int option = Integer.parseInt(input.readLine());
								if (option == 1) {
									System.out.println("---Change password---");
									System.err.print("New password: ");
									String newPassword = input.readLine();
									student.setPassword(newPassword);
									System.out.println("\n---Done---");
								} else if (option == 2) {
									System.out.println("---Create Request---");
									System.out.print("Description: ");
									String description = input.readLine();
									
									student.sendRequest(new Request(student, description));
									System.out.println("\n---Done---");
								} else if (option == 3) {
									System.err.println("\n---Schedule---");
									student.viewSchedule();
								} else if (option == 4) {
									System.err.println("\n---Marks---");
									student.getAllCourses().forEach((key, value) -> System.out
											.println(key.getTitle() + " - " + value.getScore()));
								} else if (option == 5) {
									System.err.println("\n---Transcript---");
									student.viewTranscript();
								} else if (option == 6) {
									isLoged = false;
								} else {
									System.err.println("Error: wrong option");
								}
							} else if (u instanceof Teacher) {
								Teacher teacher = (Teacher) u;
								viewTeacherController.showTeacherMenu((Teacher) u);

								System.out.print("Option: ");
								int option = Integer.parseInt(input.readLine());
								if (option == 6) {
									isLoged = false;
								} else if (option == 1) {
									System.out.println("---Change password---");
									System.err.print("New password: ");
									String newPassword = input.readLine();
									teacher.setPassword(newPassword);
									System.out.println("---Done---");
								} else if (option == 2) {
									System.out.println("---Create Request---");
									System.out.print("Description: ");
									String description = input.readLine();
									
									teacher.sendRequest(new Request(teacher, description));
									System.out.println("\n---Done---");
								} else if (option == 3) {
									System.out.println("\n---Schedule---");
									teacher.viewSchedule();
								} else if (option == 4) {
									System.out.println("\n---Students---");
									System.out.print("Course ID: ");
									String courseID = input.readLine();
									Vector<Student> allTeacherStudents = teacher.getStudents(courseID);
									try {
										System.out.println("Course - " + teacher.containsCourse(courseID).getTitle());
										for (Student ats : allTeacherStudents) {
											System.out.println("- " + teacher.getInfoForCourse(courseID, ats.getId()));
										}
									} catch (NullPointerException e) {
										System.err.println("Error: do not have such course");
									}
								} else if (option == 5) {
									System.out.println("\n---Setting mark---");

									System.out.print("ID: ");
									String studentID = input.readLine();

									System.out.print("Course Code: ");
									String courseCode = input.readLine();

									System.out.print("Points: ");
									int points = Integer.parseInt(input.readLine());

									User us = findUser(studentID);
									if (us instanceof Student) {
										try {
											teacher.putMarkToStudent(courseCode, studentID, points);
											System.out.println("---Done---");
										} catch (NullPointerException e) {
											System.err.println("Error: you do not have permission to this course");
										}
									} else {
										System.err.println("Error: wrong user");
									}
								} else {
									System.err.println("Error: wrong option");
								}
							} else if (u instanceof Manager) {
								Manager manager = (Manager) u;
								if (manager.getType() == ManagerType.Manager) {
									viewManagerController.showManagerMenu(manager);

									System.out.print("Option: ");
									int option = Integer.parseInt(input.readLine());
									if (option == 17) {
										isLoged = false;
									} else if (option == 1) {
										System.err.print("New password: ");
										String newPassword = input.readLine();
										manager.setPassword(newPassword);
										System.out.println("---Done---");
									} else if (option == 2) {
										System.out.println("---Create Request---");
										System.out.print("Description: ");
										String description = input.readLine();
										
										manager.sendRequest(new Request(manager, description));
										System.out.println("\n---Done---");
									} else if (option == 3) {
										System.out.println("---Requests---");
										viewManagerController.showRequestsManagerMenu();
										System.out.print("Option: ");
										int requestCommand = Integer.parseInt(input.readLine());
										
										if(requestCommand == 1) {
											System.out.println("---All requests---");
											for(Request r: Manager.getRequests()) {
												System.out.println("- " + r);
											}
											System.out.println("---Done---");
										} else if (requestCommand == 2) {
											System.out.println("---Manage request---");
											viewManagerController.showRequestsOptions();
											System.out.print("Option: ");
											int requestOption = Integer.parseInt(input.readLine());
											
											System.out.print("Request ID: ");
											Request r = manager.getRequest(input.readLine());
											if (r != null) {
												if (requestOption == 1) {
													manager.approveRequest(r);
													System.out.println("---Done---");
												} else if (requestOption == 2) {
													manager.denyRequest(r);
													System.out.println("---Done---");
												} else {
													System.err.println("Error: unknown request command");
												}
											} else {
												System.err.println("Error: null request");
											}
										} else {
											System.err.println("Error: unknown command");
										}
									} else if (option == 4) {
										System.out.println("---Change user information---");
										System.out.print("ID: ");
										String id = input.readLine();

										viewEditController.showEditUserMenu();
										System.out.print("Option: ");
										int editCommand = Integer.parseInt(input.readLine());

										if (manager.viewStudent(id) != null) {
											Student s = manager.viewStudent(id);
											if (editCommand == 1) {
												System.out.print("New user name: ");
												String newName = input.readLine();
												s.setName(newName);
												System.out.println("---Done---");
											} else if (editCommand == 2) {
												System.out.print("New faculty: ");
												Faculty fac = Faculty.of(input.readLine().toLowerCase());
												s.setFaculty(fac);
												System.out.println("---Done---");
											} else {
												System.err.println("Error: unknown command");
											}
										} else if (manager.viewTeacher(id) != null) {
											Teacher t = manager.viewTeacher(id);
											if (editCommand == 1) {
												System.out.print("New user name: ");
												String newName = input.readLine();
												t.setName(newName);
												System.out.println("---Done---");
											} else if (editCommand == 2) {
												System.out.print("New faculty: ");
												Faculty fac = Faculty.of(input.readLine().toLowerCase());
												t.setFaculty(fac);
												System.out.println("---Done---");
											} else {
												System.err.println("Error: unknown command");
											}
										} else {
											System.err.println("Error: null user");
										}
									} else if (option == 5) {
										System.out.println("\n---All teachers---");
										Vector<Teacher> teachers = manager.viewTeachers();
										for (Teacher t : teachers) {
											System.out.println("- " + t.viewInfo());
										}
										System.out.println("---Done---");
									} else if (option == 6) {
										System.out.println("\n---All students---");
										Vector<Student> students = manager.viewStudents();
										for (Student s : students) {
											System.out.println("- " + s.viewInfo());
										}
										System.out.println("---Done---");
									} else if (option == 7) {
										System.out.println("\n---View student---");
										System.out.print("ID: ");
										String studentID = input.readLine();

										System.out.println(manager.viewStudent(studentID));
										System.out.println("\n---Done---");
									} else if (option == 8) {
										System.out.println("---News---");
										System.out.println(news);
										System.out.println("---Done---");
									} else if (option == 9) {
										System.out.println("\n---News creation---");
										System.out.print("Title: ");
										String title = input.readLine();
										System.out.print("Description: ");
										String description = input.readLine();

										manager.createNews(title, description);
										System.out.println("\n---Done---");
									} else if (option == 10) {
										System.out.println("\n---Delete news---");
										System.out.print("Author: ");
										String author = input.readLine();
										System.out.print("Title: ");
										String title = input.readLine();
										System.out.print("Description: ");
										String description = input.readLine();

										manager.deleteNews(author, title, description);
										System.out.println("\n---Done---");
									} else if (option == 11) {
										System.out.println("---All courses---");
										if (courses.isEmpty()) {
											System.out.println("Empty.");
										} else {
											for (Course c : courses) {
												System.out.println("- " + c);
											}
										}
										System.out.println("\n---Done---");
									} else if (option == 12) {
										System.out.println("---Create course---");
										System.out.print("Course name: ");
										String courseName = input.readLine();

										System.out.print("Faculty: ");
										Faculty faculty = Faculty.of(input.readLine().toLowerCase());

										System.out.print("Credits: ");
										int credits = Integer.parseInt(input.readLine());

										System.out.print("Weekday: ");
										WeekDay weekday = WeekDay.of(input.readLine().toLowerCase());

										System.out.print("Hour: ");
										int hours = Integer.parseInt(input.readLine());

										System.out.print("Minutes: ");
										int minutes = Integer.parseInt(input.readLine());

										manager.createCourse(courseName, faculty, credits, weekday, hours, minutes);
										System.out.println("\n---Done---");
									} else if (option == 13) {
										System.out.println("\n---Edit course---");
										System.out.print("Course's code: ");
										String courseCode = input.readLine();

										for (Course c : courses) {
											if (c.getCode().equals(courseCode)) {
												viewEditController.showEditCourseMenu();
												System.out.print("--- Option: ");
												int editCourse = Integer.parseInt(input.readLine());

												if (editCourse == 1) {
													System.out.print("New name: ");
													String name = input.readLine();
													c.setTitle(name);
												} else if (editCourse == 2) {
													System.out.print("New faculty: ");
													Faculty faculty = Faculty.of(input.readLine().toLowerCase());
													c.setFaculty(faculty);
												} else if (editCourse == 3) {
													System.out.print("New credits: ");
													int credits = Integer.parseInt(input.readLine());
													c.setCredits(credits);
												}
												break;
											}
										}
										System.out.println("\n---Done---");
									} else if (option == 14) {
										System.out.println("---Delete course---");
										System.out.print("Course's code: ");
										String courseCode = input.readLine();

										Vector<Course> newCourses = courses;
										for (Course c : newCourses) {
											if (c.getCode().equals(courseCode)) {
												newCourses.remove(c);
												UniversitySystem.setCourses(newCourses);
												break;
											}
										}
										System.out.println("\n---Done---");
									} else if (option == 15) {
										System.out.println("---Register for course---");
										System.out.print("User ID: ");
										String id = input.readLine();

										System.out.print("Course code: ");
										String courseCode = input.readLine();

										User user = findUser(id);
										if (user != null) {
											if (user instanceof Student) {
												System.out.print("Teacher's ID: ");
												String teacherID = input.readLine();
												User teacher = findUser(teacherID);
												if (teacher != null) {
													Student s = (Student) user;
													Teacher t = (Teacher) teacher;
													if (manager.registerForCourse(s, courseCode, t)) {
														System.out.println("\n---Done---");
													} else {
														System.err.println(
																"Error: student already registered for this course");
													}
												} else {
													System.err.println("Error: teacher is not found");
												}

											} else if (user instanceof Teacher) {
												Teacher t = (Teacher) user;
												if (manager.registerForCourse(t, courseCode)) {
													System.out.println("\n---Done---");
												} else {
													System.err.println(
															"Error: teacher already registered for this course");
												}
											}
										} else {
											System.err.println("Error: unknown user");
										}
									} else if (option == 16) {
										System.out.println("---Delete from course---");

										System.out.print("User ID: ");
										String id = input.readLine();

										System.out.print("Course code: ");
										String courseCode = input.readLine();
										
										System.out.print("Teacher's ID: ");
										String teacherID = input.readLine();

										User user = findUser(id);
										Teacher t = manager.viewTeacher(teacherID);
										if (user != null) {
											if (user instanceof Student) {
												Student s = (Student) user;
												if (manager.deleteFromCourse(s, courseCode)) {
													t.deleteStudentFromCourse(courseCode, id);
													System.out.println("\n---Done---");
												} else {
													System.err.println("Error: student do not have this course");
												}
											}
										} else {
											System.err.println("Error: unknown user");
										}
									} else {
										System.err.println("Error: wrong option");
									}
								} else if (manager.getType() == ManagerType.ManagerFinancial) {
									viewManagerController.showFinancialManagerMenu(manager);

									System.out.print("Option: ");
									int option = Integer.parseInt(input.readLine());
									if (option == 5) {
										isLoged = false;
									} else if (option == 1) {
										System.err.print("New password: ");
										String newPassword = input.readLine();
										manager.setPassword(newPassword);
										System.out.println("---Done---");
									} else if (option == 2) {
										System.out.println("---Create Request---");
										System.out.print("Description: ");
										String description = input.readLine();
										
										manager.sendRequest(new Request(manager, description));
									}
									else if (option == 3) {
										System.out.println("---All employees---");
										Vector<Employee> employees = manager.getEmployees();
										for (Employee e : employees) {
											System.out.println("- " + e.viewInfoForFinancial());
										}
										System.out.println("\n---Done---");
									} else if (option == 4) {
										System.out.println("---Edit employee's salary---");
										System.out.print("Employee's ID: ");
										String employeeID = input.readLine();

										System.out.print("New salary: ");
										double salary = Double.parseDouble(input.readLine());

										try {
											Employee e = manager.getEmployee(employeeID);
											e.setSalary(salary);
											System.out.println("---Done---");
										} catch (NullPointerException e) {
											System.err.println("Error: null user");
										}
									} else {
										System.err.println("Error: wrong option");
									}
								}
							} else if (u instanceof Librarian) {
								Librarian librarian = (Librarian) u;
								viewLibrarianController.showLibrarianMenu(librarian);

								System.out.print("Option: ");
								int option = Integer.parseInt(input.readLine());
								if (option == 6) {
									isLoged = false;
								} else if (option == 1) {
									System.err.print("New password: ");
									String newPassword = input.readLine();
									librarian.setPassword(newPassword);
									System.out.println("---Done---");
								} else if (option == 2) {
									System.out.println("---Create Request---");
									System.out.print("Description: ");
									String description = input.readLine();
									
									librarian.sendRequest(new Request(librarian, description));
									System.out.println("\n---Done---");
								} else if (option == 3) {
									System.out.println("---View books---");
									librarian.viewBooks();
									System.out.println("\n---Done---");
								} else if (option == 4) {
									System.out.println("---Add book---");
									System.out.print("Author: ");
									String author = input.readLine();

									System.out.print("Book name: ");
									String bookName = input.readLine();

									librarian.addBook(author, bookName);
									System.out.println("\n---Done---");
								} else if (option == 5) {
									System.out.println("---Give book---");
									System.out.print("User ID: ");
									String userID = input.readLine();

									System.out.print("Book ID: ");
									String bookID = input.readLine();

									User bookUser = findUser(userID);
									try {
										librarian.giveBook(bookUser, bookID);
										System.out.println("\n---Done---");
									} catch (NullPointerException e) {
										System.err.println("Error: null user");
									}
								} else {
									System.err.println("Error: wrong option");
								}
							}
						}

					} else if (command == 2) {
						exit();
						break menu;
					}
				} catch (NumberFormatException e) {
					System.err.println("Error: wrong input format");
				}
			}
		} catch (IOException e) {
			System.err.print("Error: saving data");
			exit();
		}
		input.close();
	}
}
