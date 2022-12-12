package generators;

import java.util.Random;

public class GeneratorID {
	
	private static int getRandomID() {
		Random rand = new Random();
		return rand.nextInt(99999 - 10000) + 10000;
	}
	
	public static String generateID() {
		String code = "22B0";
		int rand = getRandomID();
		code += rand;
		return code;
	}
}
