package classes;

import enums.Mark;

public class CourseStudent extends Course {
    private Mark mark;
    private int attendance;
    private boolean isPassed;
    
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
