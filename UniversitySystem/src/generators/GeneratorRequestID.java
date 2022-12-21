package generators;

import java.util.HashMap;
import java.util.Random;

/**
 * GeneratorRequestsID class, generator for Request ID, creating unique ID
 *
 */
public class GeneratorRequestID {
	private static HashMap<Integer, Boolean> allID = new HashMap<Integer, Boolean>();
	
	/**
	 * Method, which returns random Integer
	 * @return Integer
	 */
	public static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(99999 - 10000) + 10000;
	}
	
	/**
	 * Method, which is creating unique Request ID
	 * @return String
	 */
	public static String generateID() {
		String code = "R";
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
