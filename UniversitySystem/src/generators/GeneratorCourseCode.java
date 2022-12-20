package generators;

import java.util.Random;

import classes.Course;
import enums.Faculty;

public class GeneratorCourseCode {
	private static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(999 - 100) + 100;
	}
	
	public static String getCode(Faculty faculty) {
		return faculty + "" + getRandomID();
	}
}
