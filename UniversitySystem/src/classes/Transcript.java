package classes;

import java.util.HashMap;
import java.time.LocalDate;

import enums.MarkLetter;
import generators.Semester;

public class Transcript {
    private ID studentID;
    private Semester semester;
    private HashMap<CourseStudent, MarkLetter> markLetters;
    
    private LocalDate currentDate = LocalDate.now();
    
    public Transcript(ID studentID, Semester semester, HashMap<CourseStudent, MarkLetter> markLetters) {
    	this.studentID = studentID;
    	this.semester = semester;
    	this.markLetters = markLetters;
    }
    
    public Transcript(ID studentID) {
    	this.studentID = studentID;
    	this.semester = Semester.of(currentDate.getMonth());
    	this.markLetters = new HashMap<CourseStudent, MarkLetter>();
    }
    
    public ID getStudentID() {
        return this.studentID;
    }

    public Semester getSemester() {
        return this.semester;
    }
    
	public HashMap<CourseStudent, MarkLetter> getMarks() {
		return markLetters;
	}
	
	public String toString() {
		return this.studentID + " " + this.semester + " " + this.markLetters;
	}
}
