package classes;

import java.util.HashMap;
import java.time.LocalDate;

import enums.Mark;
import generators.Semester;

public class Transcript {
    private ID studentID;
    private Semester semester;
    private HashMap<CourseStudent, Mark> marks;
    
    private LocalDate currentDate = LocalDate.now();
    
    public Transcript(ID studentID, Semester semester, HashMap<CourseStudent, Mark> marks) {
    	this.studentID = studentID;
    	this.semester = semester;
    	this.marks = marks;
    }
    
    public Transcript(ID studentID) {
    	this.studentID = studentID;
    	this.semester = Semester.of(currentDate.getMonth());
    	this.marks = new HashMap<CourseStudent, Mark>();
    }
    
    public ID getStudentID() {
        return this.studentID;
    }

    public Semester getSemester() {
        return this.semester;
    }
    
	public HashMap<CourseStudent, Mark> getMarks() {
		return marks;
	}
	
	public String toString() {
		return this.studentID + " " + this.semester + " " + this.marks;
	}
}
