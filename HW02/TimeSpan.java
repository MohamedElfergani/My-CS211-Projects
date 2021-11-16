/* Mohamed Elfergani
 * CS 211
 * 4/22/2021
 * This class inludes a compareTo method that compares time by length.
 */

// Represents a time span of elapsed hours and minutes.
// Simple implementation using only total minutes as state.
public class TimeSpan implements Comparable<TimeSpan> {
	private int totalMinutes;

	// Constructs a time span with the given interval.
	// pre: hours >= 0 && minutes >= 0
	public TimeSpan(int hours, int minutes) {
		totalMinutes = 0;
		add(hours, minutes);
	}

	// Adds the given interval to this time span.
	// pre: hours >= 0 && minutes >= 0
	public void add(int hours, int minutes) {
		totalMinutes += 60 * hours + minutes;
	}

	// Returns a String for this time span such as "6h15m".
	public String toString() {
		return (totalMinutes / 60) + "h" + (totalMinutes % 60) + "m";
	}

	/*
	 * this method is supposed to compare TimeSpan that returns -1 if TimeSpan is
	 * less than the other, it should return 0 if both have same sign, it returns a +1
	 */
	public int compareTo(TimeSpan other) {
		if (this.totalMinutes < other.totalMinutes) {
			return -1;
		} else if (this.totalMinutes > other.totalMinutes) {
			return 1;
		} else {
			return 0;
		}
	}
}
