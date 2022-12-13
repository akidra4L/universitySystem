package generators;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.Random;

public class GeneratorID {
	private static LocalDate currentDate = LocalDate.now();
	private static HashMap<Integer, Boolean> allID = new HashMap<Integer, Boolean>();
	
	private static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(99999 - 10000) + 10000;
	}
	
	private static int getYear() {
		return currentDate.getYear() % 100;
	}
	
	public static String generateID() {
		String code = getYear() + "B";
		int randomID = getRandomID();
		while(true) {
			if(!allID.containsKey(randomID)) {
				allID.put(randomID, true);
				break;
			} else {
				break;
			}
		}
		code += randomID;
		return code;
	}
}
