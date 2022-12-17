package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import classes.*;
import enums.*;
import users.*;

public class UsersData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static void loadData() {
		
//		Student s0 = new Student(new ID(), "Zhantore", "0");
//		CourseStudent oop = new CourseStudent(s0.getId(), "CS101", "OOP", Faculty.FIT, 6, null, new Mark(100), 0, false);
//		Vector<CourseStudent> vcs = new Vector<CourseStudent>();
//		vcs.add(oop);
//		s0.setCourses(vcs);
//		
//		Student s1 = new Student(new ID(), "Ariya", "1");
//		Student s2 = new Student(new ID(), "Miras", "2");
//		Student s3 = new Student(new ID(), "Zhanel", "3");
//		Student s4 = new Student(new ID(), "Yelaman", "4");
//		
//		Teacher t0 = new Teacher(new ID(), "Pakita", "0");
		
	}
	
	static {
		if (new File("users.ser").exists()) {
			try {
				UniversitySystem.users = readUsers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else UniversitySystem.users = new Vector<User>();
	}
	
	static Vector<User> readUsers() throws Exception {
		FileInputStream fis = new FileInputStream("users.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<User> users = (Vector<User>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return users;
	}
	
	static void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("users.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.users);
		
		fos.close();
		oos.close();
	}
}
