package classes;

public class Time implements Comparable<Time> {
	int hours, minutes, seconds;

	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public String checkMinutesAndSeconds() {	
		var builder = new StringBuilder();
		
		if(this.minutes < 10) {
			builder.append("0" + this.minutes + ":");
		} else {
			builder.append(this.minutes + ":");
		}
		if(this.seconds < 10) {
			builder.append("0" + this.seconds);
		} else {
			builder.append(this.seconds);
		}
		
		return builder.toString();
	}
	
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
						if(this.seconds > o.seconds) {
							return 1;
						}
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
	
	public String toString() {
		return this.hours + " " + this.minutes + " " + this.seconds;
	}
}
