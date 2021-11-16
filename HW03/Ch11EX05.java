/*Mohamed Elfergani
 * CS 211
 * 4/29/2021
 * The purpose of this program is to rearranges the list’s elements into sorted ascending order, as well as removing all duplicate values from the list.
 */

import java.util.*;

public class Ch11EX05 {

	public static void main(String[] args) {

		// Store integers in an ArrayList
		Integer[] numbers = { 7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9 };
		System.out.println("The list before getting sorted and removing all duplicate values: ");
		
		//prints out the 'before list'
		System.out.println(Arrays.toString(numbers));

		System.out.println("_______________________");
		System.out.println();
		
		ArrayList<Integer> numbers2 = sortAndRemove(Arrays.asList(numbers));
		System.out.println("The list after being sorted in ascending order and removing all duplicate values: ");
		
		//prints out the 'after list' where everything is sorted and removed all duplicate values
		System.out.println(numbers2);
	}

	public static ArrayList<Integer> sortAndRemove(List<Integer> list) {
		// Use a TreeSet to find and remove duplicates
		ArrayList<Integer> removeNumbers2 = new ArrayList<Integer>();
		TreeSet<Integer> newTest = new TreeSet<Integer>();

		newTest.addAll(list);
		removeNumbers2.addAll(newTest);

		// remove all at the specified position in the list
		return removeNumbers2;
	}
}
