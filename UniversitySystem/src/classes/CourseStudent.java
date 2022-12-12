package classes;

import java.util.Vector;

import enums.Faculty;
import enums.Mark;

public class CourseStudent extends Course {
	private Mark mark;
    private int attendance;
    private boolean isPassed;
    
    public CourseStudent(ID id, String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite, Mark mark, int attendance, boolean isPassed) {
		super(id, code, title, faculty, credits, prerequisite);
		this.mark = mark;
		this.attendance = attendance;
		this.isPassed = isPassed;
	}
    
    public Mark getMark() {
        return this.mark;
    }
    public void setMark(Mark mark) {
        this.mark = mark;
    }
    
    public int getAttendance() {
        return this.attendance;
    }
    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
    
    public boolean getIsPassed() {
        return this.isPassed;
    }
    public void setIsPassed(Boolean isPassed) {
        this.isPassed = isPassed;
    }
}
