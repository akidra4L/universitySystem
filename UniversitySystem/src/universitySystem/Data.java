package universitySystem;

import java.util.Vector;

import classes.*;
import enums.*;
import users.*;

public class Data {
	static void loadData() {
		Admin a = new Admin(new ID(), "Alikhan", "admin", Role.Admin);
		
		Student s0 = new Student(new ID(), "Zhantore", "0", Role.Student);
		CourseStudent oop = new CourseStudent(s0.getId(), "CS101", "OOP", Faculty.FIT, 6, null, new Mark(100), 0, false);
		Vector<CourseStudent> vcs = new Vector<CourseStudent>();
		vcs.add(oop);
		s0.setCourses(vcs);
		
		Student s1 = new Student(new ID(), "Ariya", "1", Role.Student);
		Student s2 = new Student(new ID(), "Miras", "2", Role.Student);
		Student s3 = new Student(new ID(), "Zhanel", "3", Role.Student);
		Student s4 = new Student(new ID(), "Yelaman", "4", Role.Student);
		
		Teacher t0 = new Teacher(new ID(), "Pakita", "0", Role.Teacher);
		
	}
}
