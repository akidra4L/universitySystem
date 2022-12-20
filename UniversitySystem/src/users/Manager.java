package users;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import classes.*;
import enums.*;
import universitySystem.UniversitySystem;

public class Manager extends Employee {
    private static final long serialVersionUID = 1L;
	private ManagerType type;
    
    public Manager(ID id, String name, double salary, ManagerType type) {
		super(id, name, salary);
		this.type = type;
	}
    
    public Manager(ID id, String name) {
    	super(id, name);
    	this.type = ManagerType.Undefined;
    }
    
    public Manager(ID id, String name, ManagerType type) {
    	super(id, name);
    	this.type = type;
    }
    
    public ManagerType getType() {
        return this.type;
    }
    
    public News createNews(String title, String description) {
    	return new News(this.getName(), title, description);
    }

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
    
    public boolean registerForCourse(Teacher teacher, String courseCode) {
    	Course c = UniversitySystem.findCourse(courseCode);
    	if (!teacher.getAllCourses().keySet().contains(c)) {
    		teacher.addCourse(c);
    		return true;
    	}
    	return false;
    }
    
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
    
    public Student viewStudent(String id) {
    	Vector <Student> students = viewStudents();
    	for(Student s : students) {
    		if (s.getId().getNumberID().equals(id)) {
    			return s;
    		}
    	}
    	return null;
    }
    
    public void createCourse(String name, Faculty faculty, int credits) {
    	new Course(name, faculty, credits);
    }

    public Course viewCourseInfo() {
        //TODO
        return null;
    }

    public Vector<Request> viewRequests() {
        //TODO
        return null;
    }

    public Request getRequest() {
        //TODO
        return null;
    }
    
    public String toString() {
    	return super.toString() + " " + this.type;
    }
}
