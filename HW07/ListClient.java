/*Mohamed Elfergani
 * CS 211
 * 5/32/2021
 * This is a client that prints out the methods.
 */
public class ListClient {

	public static void main(String[] args) {
		LinkedIntList myList1 = new LinkedIntList();

		// myList1 will be the numbers used in the switchPairs method
		myList1.add(23);
		myList1.add(43);
		myList1.add(-2);
		myList1.add(-341);
		myList1.add(11);
		myList1.add(55);
		myList1.add(9);

		LinkedIntList myList2 = new LinkedIntList();

		// myList2 will be the numbers used in the split method
		myList2.add(34);
		myList2.add(-34);
		myList2.add(-99);
		myList2.add(75);
		myList2.add(-4);
		myList2.add(4);
		myList2.add(99);

		// prints out the myList1 before
		System.out.println("List 1 before: " + myList1);

		// myList1 during the switchPairs method
		myList1.switchPairs();

		// print out after method switchPairs
		System.out.println("List 1 after method switchPairs: " + myList1);

		// prints out the myList2 before
		System.out.println("\nList 2 before: " + myList2);

		// myList2 during the split method
		myList2.split();

		// prints out after method split
		System.out.println("List 2 after method split: " + myList2);
	}
}
