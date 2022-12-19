package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import classes.Course;

public class CoursesData implements Serializable {
	private static final long serialVersionUID = 1L;

	static {
		if (new File("courses.ser").exists()) {
			try {
				UniversitySystem.courses = readCourses();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UniversitySystem.courses = new Vector<Course>();
		}
	}
	
	static Vector<Course> readCourses() throws Exception {
		FileInputStream fis = new FileInputStream("courses.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<Course> courses = (Vector<Course>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return courses;
	}
	
	static void saveCourses() throws Exception {
		FileOutputStream fos = new FileOutputStream("courses.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.courses);
		
		fos.close();
		oos.close();
	}
	
}
