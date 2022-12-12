package users;

import java.util.Vector;

import classes.ID;
import enums.Faculty;
import enums.Role;
import enums.TeacherTitle;

public class Teacher extends Employee {
    private Faculty faculty;
    private TeacherTitle title;
    private Vector<Course> courses;
    private Schedule schedule;
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public TeacherTitle getTitle() {
        return this.title;
    }
    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public Vector<Course> getCourses() {
        return this.courses;
    }
    public Vector<Course> setCourses(Vector<Course> courses) {
        this.courses = courses;
    }
    
    private Schedule getSchedule() {
        return this.schedule;
    }
    private Schedule setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public void putMark() {
        // TODO
    }

    public Vector<Student> checkAttendance() {
        // TODO
    }
}
