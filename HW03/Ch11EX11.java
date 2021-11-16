/*Mohamed Elfergani
 * CS 211
 * 4/30/2021
 * The purpose of this program is to make a method that accepts two sets and returns a new set "containing their symmetric set difference."
 */
import java.util.HashSet;
import java.util.Set;

public class Ch11EX11 {

	public static void main(String[] args) {

		// creates a set of integers
		Set<Integer> symmetric = new HashSet<Integer>();

		// adds the integers to the set
		symmetric.add(1);
		symmetric.add(4);
		symmetric.add(7);
		symmetric.add(9);

		// creates a second set of integers
		Set<Integer> symmetric2 = new HashSet<Integer>();

		// adds the second set of integers to the set
		symmetric2.add(2);
		symmetric2.add(4);
		symmetric2.add(5);
		symmetric2.add(6);
		symmetric2.add(7);

		
		// prints the two sets of numbers
		System.out.println("The first set of integers is: " + symmetric);
		System.out.println();
		System.out.println("The second set of integers is: " + symmetric2);
		System.out.println();
		
		// Calling the symmetricSetDifference method on the two sets
		Set<Integer> symmetricSet = symmetricSetDifference(symmetric, symmetric2);

		
		// prints the result set
		System.out.println("The symmetric difference set is: " + symmetricSet);

	}

	private static Set<Integer> symmetricSetDifference(Set<Integer> symmetric, Set<Integer> symmetric2) {

		// A ser of type integers
		Set<Integer> inter = new HashSet<Integer>(symmetric);

		// The intersection of both sets
		inter.retainAll(symmetric2);

		//Removes the intersection set from symmetric1
		symmetric.removeAll(inter);

		//Removes the intersection set from symmetric2
		symmetric2.removeAll(inter);

		//combines both sets into  one
		symmetric.addAll(symmetric2);

		//returns symmetric
		return symmetric;

	}

}
