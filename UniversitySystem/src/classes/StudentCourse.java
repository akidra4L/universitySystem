package classes;

import java.util.Vector;

import enums.Faculty;

public class StudentCourse extends Course {
	private static final long serialVersionUID = 1L;
	private Mark mark;
    private int attendance;
    private boolean isPassed;
    
    public StudentCourse(String code, String title, Faculty faculty, int credits, Vector<Course> prerequisite, Mark mark, int attendance, boolean isPassed) {
		super(code, title, faculty, credits, prerequisite);
		this.setMark(mark);
		this.attendance = attendance;
		this.isPassed = isPassed;
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

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}
}
