
/*Mohamed Elfergani
 * CS 211
 * 4/30/2021
 * The purpose of this program is to make a method that accepts a list of integers as a parameter and returns the number of times the most frequently occurring integer
 */
import java.util.*;

public class Ch11EX15 {

	// main method
	public static void main(String[] args) {

		// creates a set of integers
		// the list of numbers I chose
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 7, 9, 6, 7, 3, 4, 12, 15, 7));

		int numbers = maxOccurrences(list);

		// prints out the list and the most frequently occurring integer
		System.out.println("The list of integers I chose is: " + list);
		System.out.println("_________________________");
		System.out.println();
		System.out.println("The number of times the most frequently occurring number in the list is: " + numbers);

	}

	private static int maxOccurrences(List<Integer> list) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					count++;
				}
			}
			map.put(i, count);
		}

		// now that we have the list of all numbers; we return the most frequently
		// occurring number
		int max = 0;
		for (int i : map.values()) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
}