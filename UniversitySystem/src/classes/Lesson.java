package classes;

import java.util.Vector;

import users.Student;
import users.Teacher;

public class Lesson extends Course {
    private Date date;
    private String room;
    private Teacher teacher;
    private Vector<Student> students;
    
    public Lesson(Date date, String room, Teacher teacher, Vector<Student> students) {
    	this.date = date;
    	this.room = room;
    	this.teacher = teacher;
    	this.students = students;
    }
    
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return this.room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    
    public Teacher getTeacher() {
        return this.teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Vector<Student> getStudents() {
        return this.students;
    }
    public void setStudents(Vector<Student> students) {
        this.students = students;
    }
}
