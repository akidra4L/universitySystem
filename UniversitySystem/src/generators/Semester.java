package generators;

import java.time.Month;

/**
 * Semester Enum
 *
 */
public enum Semester {
	Spring, Summer, Fall;
	
	/**
	 * Method of Semester's Enum, which is returning during Semester by month
	 * @param month
	 * @return
	 */
	static public Semester of (final Month month) {
		if(month.ordinal() < 6 && month.ordinal() > 1) return Spring;
		else if (month.ordinal() >= 6 && month.ordinal() < 9) return Summer;
		else return Fall;
	}
}
