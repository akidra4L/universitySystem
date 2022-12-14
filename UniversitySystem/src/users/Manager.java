package users;

import java.util.Vector;

import classes.CourseStudent;
import classes.ID;
import classes.Lesson;
import classes.News;
import classes.Request;
import enums.ManagerType;
import enums.Role;
import universitySystem.UniversitySystem;

public class Manager extends Employee {
    private ManagerType type;
    
    public Manager(ID id, String name, Role role, double salary, ManagerType type) {
		super(id, name, role, salary);
		this.type = type;
		UniversitySystem.addManager(this);
	}
    
    public Manager(ID id, String name, Role role) {
    	super(id, name, role);
    	this.type = ManagerType.Undefined;
    	UniversitySystem.addManager(this);
    }
    
    public ManagerType getType() {
        return this.type;
    }
    
    public News createNews(String title, String description) {
    	return new News(this, title, description);
    }

    public boolean deleteNews(News news) {
    	Vector<News> allNews = UniversitySystem.getNews();
    	for(News n: allNews) {
    		if(n.equals(news)) {
    			allNews.remove(n);
    			UniversitySystem.setNews(allNews);
    			return true;
    		}
    	}
        return false;
    }
    
    public boolean registerForCourse(Student student, CourseStudent course) {
        if(student.enrollCourse(course)) {
        	Vector<CourseStudent> courses = student.getCourses();
        	courses.add(course);
        	student.setCourses(courses);
        	return true;
        }
        return false;
    }
    
    public Vector<User> viewUsers() {
    	return UniversitySystem.getUsers();
    }
    
    public User viewUser(User user) {
    	Vector<User> allUsers = UniversitySystem.getUsers();
    	for(User u: allUsers) {
    		if(u.equals(user)) {
    			return u;
    		}
    	}
    	return null;
    }

    public Lesson viewLessonInfo() {
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
