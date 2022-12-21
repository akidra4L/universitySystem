package classes;

import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalDate;

import enums.MarkLetter;
import generators.Semester;

/**
 * Transcript class
 *
 */
public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
	private ID studentID;
    private Semester semester;
    private HashMap<Course, MarkLetter> markLetters;
    private LocalDate currentDate = LocalDate.now();
    
    /**
     * Default constructor
     * @param studentID
     * @param semester
     * @param markLetters
     */
    public Transcript(ID studentID, Semester semester, HashMap<Course, MarkLetter> markLetters) {
    	this.studentID = studentID;
    	this.semester = semester;
    	this.markLetters = markLetters;
    }
    
    /**
     * Default constructor
     * @param studentID
     */
    public Transcript(ID studentID) {
    	this.studentID = studentID;
    	this.semester = Semester.of(currentDate.getMonth());
    	this.markLetters = new HashMap<Course, MarkLetter>();
    }
    
    /**
     * Getter for Student's ID, whose Transcript is it
     * @return ID
     */
    public ID getStudentID() {
        return this.studentID;
    }

    /**
     * Getter for Transcript's Semester
     * @return
     */
    public Semester getSemester() {
        return this.semester;
    }
    
    /**
     * Getter for Marks
     * @return HashMap
     */
	public HashMap<Course, MarkLetter> getMarks() {
		return markLetters;
	}
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.studentID + " " + this.semester + " " + this.markLetters;
	}
}
