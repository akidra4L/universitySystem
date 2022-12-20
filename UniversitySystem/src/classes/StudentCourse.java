package classes;

import enums.Faculty;

public class StudentCourse extends Course {
	private static final long serialVersionUID = 1L;
	private Date date;
    private String room;
	private Mark mark;
    private int attendance;
    private boolean isPassed;
    
    public StudentCourse(String code, String title, Faculty faculty, int credits, Mark mark, int attendance, boolean isPassed) {
		super(code, title, faculty, credits);
		this.setMark(mark);
		this.attendance = attendance;
		this.isPassed = isPassed;
	}
    
    public StudentCourse(String code, String title, Faculty faculty, int credits) {
    	super(code, title, faculty, credits);
    	this.mark = null;
    	this.attendance = 0;
    	this.isPassed = false;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}
