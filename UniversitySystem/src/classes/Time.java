package classes;

import java.io.Serializable;

/**
 * Time class
 *
 */
public class Time implements Comparable<Time>, Serializable {
	private static final long serialVersionUID = 1L;
	int hours, minutes;

	/**
	 * Default constructor
	 * @param hours
	 * @param minutes
	 */
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * Method, which is creating right format of a Time
	 * @return String
	 */
	public String checkMinutesAndSeconds() {	
		var builder = new StringBuilder();
		
		if(this.minutes < 10) {
			builder.append("0" + this.minutes);
		} else {
			builder.append(this.minutes);
		}
		
		return builder.toString();
	}
	
	/**
	 * Method, which returns Universal representation of Time
	 * @return String
	 */
	public String toUniversal() {
		String ans = "";
		if(this.hours < 10) {
			ans = "0" + this.hours + ":";
		} else {
			ans = this.hours + ":";
		}
		
		String ms = checkMinutesAndSeconds();
		ans += ms;
		
		return ans;
	}
	
	/**
	 * Method, which returns Standard representation of Time
	 * @return String
	 */
	public String toStandard() {
		String ans = "";
		if(this.hours > 12) {
			ans += (this.hours % 12) + ":";
			String ms = checkMinutesAndSeconds();
			ans += ms + " PM";
		} else {
			ans += this.hours + ":";
			String ms = checkMinutesAndSeconds();
			ans += ms + " AM";
		}
		return ans;
	}

	@Override
	public int compareTo(Time o) {
		if(this.hours > o.hours) {
			if(this.hours == o.hours) {
				if(this.minutes > o.minutes) {
					if(this.minutes == o.minutes) {
						return 0;
					}
					return 1;
				}
				return 0;
			}
			return 1;
		}
		return 0;
	}
	
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.hours + " " + this.minutes;
	}
}
