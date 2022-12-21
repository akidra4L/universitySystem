package generators;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.Random;

/**
 * GeneratorID class, generator for User's ID, creating unique ID
 *
 */
public class GeneratorID {
	private static LocalDate currentDate = LocalDate.now();
	private static HashMap<Integer, Boolean> allID = new HashMap<Integer, Boolean>();
	
	/**
	 * Method, which returns random Integer
	 * @return Integer
	 */
	private static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(99999 - 10000) + 10000;
	}
	
	/**
	 * Method, which is returning last 2 numbers of Current Year
	 * @return Integer
	 */
	private static int getYear() {
		return currentDate.getYear() % 100;
	}
	
	/**
	 * Method, which is creating unique User's ID
	 * @return String
	 */
	public static String generateID() {
		String code = getYear() + "B0";
		int randomID = getRandomID();
		while(true) {
			if(!allID.containsKey(randomID)) {
				allID.put(randomID, true);
				break;
			} else {
				randomID = getRandomID();
			}
		}
		code += randomID;
		return code;
	}
}
