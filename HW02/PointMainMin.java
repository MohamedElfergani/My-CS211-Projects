import java.util.ArrayList;
import java.util.Collections;

/* Mohamed Elfergani
 * CS 211
 * 4/22/2021
 * This class is supposed to have 4 points and show the distance away from the origin of each point.
 */

public class PointMainMin {
	public static void main(String[] args) {

		ArrayList<Point> myPoints = new ArrayList<Point>();

		// create two Point objects
		Point point1 = new Point(7, 2);
		Point point2 = new Point(4, 3);
		Point point3 = new Point(5, 4);
		Point point4 = new Point(3, 2);

		//adds the distances to the myPoints method 
		myPoints.add(point1);
		myPoints.add(point2);
		myPoints.add(point3);
		myPoints.add(point4);
        
		System.out.println("Test for all points and their distance from origin:");
		
		// print each point and its distance from the origin
		System.out.println("point1 is " + point1);
		System.out.printf("distance from origin = %3.2f\n", point1.distanceFromOrigin());

		System.out.println();
		
		System.out.println("point2 is " + point2);
		System.out.printf("distance from origin = %3.2f\n", point2.distanceFromOrigin());
		
		System.out.println();

		System.out.println("point3 is " + point3);
		System.out.printf("distance from origin = %3.2f\n", point3.distanceFromOrigin());

		System.out.println();
		
		System.out.println("point4 is " + point4);
		System.out.printf("distance from origin = %3.2f\n", point4.distanceFromOrigin());
		
		System.out.println();

		System.out.println("---------------------");

		System.out.println("Before and after of each point:");
		
		// sorting in y order, if y is =, then x order will be sorted in it
		System.out.println("\nBefore:" + myPoints);
		Collections.sort(myPoints);
		System.out.println("After:" + myPoints);
	}
}