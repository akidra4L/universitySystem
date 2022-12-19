package classes;

import java.util.Vector;

import enums.Faculty;
import users.Student;
import users.Teacher;

public class Lesson extends Course {
	private static final long serialVersionUID = 1L;
	private Date date;
    private String room;
    private Teacher teacher;
    private Vector<Student> students;
    
    public Lesson(ID id, String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite, Date date, String room, Teacher teacher, Vector<Student> students) {
		super(id, code, title, faculty, credits, prerequisite);
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
