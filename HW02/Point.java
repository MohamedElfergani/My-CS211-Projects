/* Mohamed Elfergani
 * CS 211
 * 4/23/2021
 * This class defines a natural ordering by implementing the Comparable interface. Compares the points in the y-major order and x-coordinate values.
 */

import java.lang.Comparable;

public class Point implements Comparable<Object> {

	private int x;
	private int y;

	// Constructs a new point at the given (x, y) location.
	// pre: x >= 0 && y >= 0
	public Point(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}

	// Constructs a new point at the origin, (0, 0).
	public Point() {

		// calls Point(int, int) constructor
		this(0, 0);
	}

	// Returns the distance between this Point and (0, 0).
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	// Returns whether o refers to a point with the same (x, y)
	// coordinates as this point. Robust version.
	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point other = (Point) o;
			return this.x == other.getX() && this.y == other.getY();
		} else { // not a Point object
			return false;
		}
	}

	// Returns the x of this point.
	private int getX() {
		return this.x;
	}

	// Returns the y of this point.
	private int getY() {
		return this.y;
	}

	// Returns a String of this point.
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	// Returns a new point.
	public Point translate(int dx, int dy) {
		return new Point(this.x + dx, this.y + dy);
	}

	/*
	 * compareTo method checks to see if x is = to x of A returns a value of
	 * y-A.getY() if not return x-A.getX()
	 */
	public int compareTo(Object o) {
		Point A = (Point) o;
		if (x == A.getX()) {
			return x - A.getX();
		}

		else {
			return y - A.getY();
		}
	}

	// override the compareTo method of the comparable interface
	// if and else if statements
	public int compareTo(Point o) {
		if (this.y < o.y) {
			return -1;
		} else if (this.y > o.y) {
			return 1;
		} else if (this.x < o.x) {
			return -1;
		} else if (this.x > o.x) {
			return 1;
		} else {
			return 0;
		}
	}
}