package enums;

public enum WeekDay {
	Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, Undefined;
	
	public static WeekDay of (final String day) {
		switch (day) {
		case "monday":
			return Monday;
		case "tuesday":
			return Tuesday;
		case "wednesday":
			return Wednesday;
		case "thursday":
			return Thursday;
		case "friday":
			return Friday;
		case "Saturday":
			return Saturday;
		case "Sunday":
			return Sunday; 
		default:
			return Undefined;
		}
	}
}
