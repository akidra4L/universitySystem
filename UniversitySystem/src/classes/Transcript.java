package classes;

import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalDate;

import enums.MarkLetter;
import generators.Semester;

public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID studentID;
    private Semester semester;
    private HashMap<Course, MarkLetter> markLetters;
    
    private LocalDate currentDate = LocalDate.now();
    
    public Transcript(ID studentID, Semester semester, HashMap<Course, MarkLetter> markLetters) {
    	this.studentID = studentID;
    	this.semester = semester;
    	this.markLetters = markLetters;
    }
    
    public Transcript(ID studentID) {
    	this.studentID = studentID;
    	this.semester = Semester.of(currentDate.getMonth());
    	this.markLetters = new HashMap<Course, MarkLetter>();
    }
    
    public ID getStudentID() {
        return this.studentID;
    }

    public Semester getSemester() {
        return this.semester;
    }
    
	public HashMap<Course, MarkLetter> getMarks() {
		return markLetters;
	}
	
	public String toString() {
		return this.studentID + " " + this.semester + " " + this.markLetters;
	}
}
