package generators;

import java.util.HashMap;
import java.util.Random;

import enums.Faculty;

/**
 * GeneratorCourseCode, generator for Course's code, creating unique code
 */
public class GeneratorCourseCode {
	private static HashMap<Integer, Boolean> allID = new HashMap<Integer, Boolean>();
	
	/**
	 * Method, which returns random Integer
	 * @return Integer
	 */
	private static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(999 - 100) + 100;
	}
	
	/**
	 * Method, which creating unique code
	 * @param faculty
	 * @return String
	 */
	public static String getCode(Faculty faculty) {
		int randomID = getRandomID();
		while(true) {
			if(!allID.containsKey(randomID)) {
				allID.put(randomID, true);
				break;
			} else {
				randomID = getRandomID();
			}
		}
		return faculty + "" + randomID;
	}
}
