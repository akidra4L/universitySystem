package universitySystem;

import java.util.Vector;

import classes.*;
import enums.*;
import users.*;

public class Data {
	static void loadData() {
		Admin a = new Admin(new ID(), "Alikhan", "admin");
		
		Student s0 = new Student(new ID(), "Zhantore", "0");
		CourseStudent oop = new CourseStudent(s0.getId(), "CS101", "OOP", Faculty.FIT, 6, null, new Mark(100), 0, false);
		Vector<CourseStudent> vcs = new Vector<CourseStudent>();
		vcs.add(oop);
		s0.setCourses(vcs);
		
		Student s1 = new Student(new ID(), "Ariya", "1");
		Student s2 = new Student(new ID(), "Miras", "2");
		Student s3 = new Student(new ID(), "Zhanel", "3");
		Student s4 = new Student(new ID(), "Yelaman", "4");
		
		Teacher t0 = new Teacher(new ID(), "Pakita", "0");
		
	}
}
