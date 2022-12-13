package generators;

import java.time.Month;

public enum Semester {
	Spring, Summer, Fall;
	
	static public Semester of (final Month month) {
		switch(month) {
		// cases to return Spring Semester
		case JANUARY:
			return Spring;
		case FEBRUARY:
			return Spring;
		case MARCH:
			return Spring;
		case APRIL:
			return Spring;
		case MAY:
			return Spring;
		
		// cases to return Summer Semester
		case JUNE:
			return Summer;
		case JULY:
			return Summer;
		
		// cases to return Fall Semester
		case AUGUST:
			return Fall;
		case SEPTEMBER:
			return Fall;
		case OCTOBER:
			return Fall;
		case NOVEMBER:
			return Fall;
		case DECEMBER:
			return Fall;
		
		default:
			return null;
		}
	}
}
