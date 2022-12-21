package users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import classes.*;
import enums.*;
import universitySystem.UniversitySystem;

/**
 * Manager class
 */
public class Manager extends Employee {
    private static final long serialVersionUID = 1L;
	private ManagerType type;
    
	/**
	 * Default constructor
	 * @param id
	 * @param name
	 * @param salary
	 * @param type
	 */
    public Manager(ID id, String name, double salary, ManagerType type) {
		super(id, name, salary);
		this.type = type;
	}
    
    /**
     * Default constructor
     * @param id
     * @param name
     */
    public Manager(ID id, String name) {
    	super(id, name);
    	this.type = ManagerType.Undefined;
    }
    
    /**
     * Default constructor
     * @param id
     * @param name
     * @param type
     */
    public Manager(ID id, String name, ManagerType type) {
    	super(id, name);
    	this.type = type;
    }
    
    /**
     * Getter for Manager's type
     * @return
     */
    public ManagerType getType() {
        return this.type;
    }
    
    /**
     * Method, which creates News
     * @param title
     * @param description
     * @return News
     */
    public News createNews(String title, String description) {
    	return new News(this.getName(), title, description);
    }

    /**
     * Method, which deletes News
     * @param author
     * @param title
     * @param description
     * @return true if News exists in System, false otherwise
     */
    public boolean deleteNews(String author, String title, String description) {
    	Vector<News> allNews = UniversitySystem.getNews();
    	for(News n: allNews) {
    		if(n.getAuthor().equals(author) && n.getTitle().equals(title) && n.getDescription().equals(description)) {
    			allNews.remove(n);
    			UniversitySystem.setNews(allNews);
    			return true;
    		}
    	}
        return false;
    }
    
    /**
     * Method, which registers Student for Course to certain Teacher
     * @param student
     * @param courseCode
     * @param teacher
     * @return boolean
     */
    public boolean registerForCourse(Student student, String courseCode, Teacher teacher) {
    	Course c = UniversitySystem.findCourse(courseCode);
    	if(student.enrollCourse(c)) {
    		teacher.addStudent(c, student);
        	HashMap<Course, Mark> allCourses = student.getAllCourses();
        	if(allCourses.containsKey(c)) {
        		return false;
        	}
        	allCourses.put(c, new Mark());
        	student.setAllCourses(allCourses);
    		return true;
    	}
    	return false;
    }
    
    /**
     * Method, which registers Teacher for Course
     * @param teacher
     * @param courseCode
     * @return
     */
    public boolean registerForCourse(Teacher teacher, String courseCode) {
    	Course c = UniversitySystem.findCourse(courseCode);
    	if (c == null) {
    		return false;
    	}
    	else if (!teacher.getAllCourses().keySet().contains(c)) {
    		teacher.addCourse(c);
    		return true;
    	}
    	return false;
    }
    
    /**
     * Method, which deletes Student from Course
     * @param student
     * @param courseCode
     * @return
     */
    public boolean deleteFromCourse(Student student, String courseCode) {
    	Course c = UniversitySystem.findCourse(courseCode);
    	HashMap<Course, Mark> allCourses = student.getAllCourses();
    	for(Map.Entry<Course, Mark> hm: allCourses.entrySet()) {
    		if(hm.getKey().equals(c)) {
    			allCourses.remove(hm.getKey(), hm.getValue());
    			student.setAllCourses(allCourses);
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Method, which returns Vector<Teacher> to show them
     * @return Vector
     */
    public Vector<Teacher> viewTeachers() {
    	Vector <Teacher> teachers = new Vector<Teacher>();
    	Vector <User> users = UniversitySystem.getUsers();
    	
    	for(User u: users) {
    		if (u instanceof Teacher) {
    			teachers.add((Teacher) u);
    		}
    	}
    	return teachers;
    }
    
    /**
     * Method, which returns Vector<Student> to show them
     * @return Vector
     */
    public Vector<Student> viewStudents() {
    	Vector <Student> students = new Vector<Student>();
    	Vector <User> users = UniversitySystem.getUsers();
    	
    	for(User u : users) {
    		if (u instanceof Student) {
    			students.add((Student) u);
    		}
    	}
    	return students;
    }
    
    /**
     * Method, which returns certain Student by his ID in String representation
     * @param id
     * @return Student
     */
    public Student viewStudent(String id) {
    	Vector <Student> students = viewStudents();
    	for(Student s : students) {
    		if (s.getId().getNumberID().equals(id)) {
    			return s;
    		}
    	}
    	return null;
    }
    
    /**
     * Method, which returns certain Teacher by his ID in String representation
     * @param id
     * @return Teacher
     */
    public Teacher viewTeacher(String id) {
    	Vector <Teacher> teachers = viewTeachers();
    	for(Teacher t : teachers) {
    		if (t.getId().getNumberID().equals(id)) {
    			return t;
    		}
    	}
    	return null;
    }
    
    /**
     * Method, which returns all Employees
     * @return Vector
     */
    public Vector<Employee> getEmployees() {
    	Vector <Employee> employees = new Vector<Employee>();
    	Vector <User> users = UniversitySystem.getUsers();
    	for(User u: users) {
    		if(u instanceof Employee) {
    			employees.add((Employee) u);
    		}
    	}
    	return employees;
    }
    
    /**
     * Method, which returns certain Employee by his ID in String representation
     * @param id
     * @return Employee
     */
    public Employee getEmployee(String id) {
    	Vector <Employee> employees = getEmployees();
    	for(Employee e: employees) {
    		if(e.getId().getNumberID().equals(id)) {
    			return e;
    		}
    	}
    	return null;
    }
    
    /**
     * Method, which creates Course in System
     * @param name
     * @param faculty
     * @param credits
     * @param weekday
     * @param hours
     * @param minutes
     */
    public void createCourse(String name, Faculty faculty, int credits, WeekDay weekday, int hours, int minutes) {
    	new Course(name, faculty, credits, weekday, hours, minutes);
    }
    
    /**
     * Return string representation of the Object
     * @return String
     */
    public String toString() {
    	return super.toString() + " " + this.type;
    }

    /**
     * Method, which returns Request by it's ID in String representation
     * @param id
     * @return Request
     */
    public Request getRequest(String id) {
    	for(Request r: Manager.getRequests()) {
    		if(r.getId().equals(id)) {
    			return r;
    		}
    	}
    	return null;
    }

    /**
     * Method, which returns all Requests in System
     * @return List
     */
	public static List<Request> getRequests() {
		return UniversitySystem.getRequests();
	}
	
	/**
	 * Method, which adds Request in System
	 * @param request
	 */
	public static void processRequest(Request request) {
		UniversitySystem.addRequest(request);
	}

	/**
	 * Method, which sets Request as APPROVED
	 * @param request
	 */
	public void approveRequest(Request request) {
		request.setState(StateOfRequest.APPROVED);
	}

	/**
	 * Method, which 
	 * @param request sets Request as DENIED
	 */
	public void denyRequest(Request request) {
		request.setState(StateOfRequest.DENIED);
	}
}
