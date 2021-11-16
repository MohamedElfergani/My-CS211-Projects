/*Mohamed Elfergani
 * CS 211
 * 5/19/2021
 * The purpose of this program is to print out each method and tests them
 */
public class Client {

	public static void main(String[] args) {

		// lastIndexOf test
		int[] storeData = { 1, 18, 2, 7, 18, 39, 18, 40 };
		ArrayIntList myFullList = new ArrayIntList();
		for (int n : storeData) {
			myFullList.add(n);
		}

		// print output of the lastIndexOf method
		System.out.println("Original Index List = " + myFullList);
		System.out.println("Last index is found in the list at position:" + " " + myFullList.lastIndexOf(39));
		System.out
				.println("The last index does not exist in the list, so we show a:" + " " + myFullList.lastIndexOf(72));

		// indexOfSubList test
		int[] storeData1 = { 11, -7, 3, 42, 0, 14 };
		ArrayIntList myFullList1 = new ArrayIntList();
		for (int n : storeData1) {
			myFullList1.add(n);
		}

		int[] storeData2 = { 3, 42, 0 };
		ArrayIntList myFullList2 = new ArrayIntList();
		for (int n : storeData2) {
			myFullList2.add(n);
		}

		// print output of the indexOfSubList method
		System.out.println("\nSublist: " + myFullList1.indexOfSubList(myFullList2));

		// runningTotal test
		int[] storeData3 = { 2, 3, 5, 4, 7, 15, 20, 7 };
		ArrayIntList myFullList3 = new ArrayIntList();
		for (int n : storeData3) {
			myFullList3.add(n);
		}

		int[] storeData4 = { 2, 3, 5, 4, 7, 15, 20, 7 };
		ArrayIntList myFullList4 = new ArrayIntList();
		for (int n : storeData4) {
			myFullList4.add(n);
		}

		// print output of the runningTotal method
		System.out.println("\nOriginal Running total list: " + myFullList4.toString());
		System.out.println("Running total list: " + myFullList3.runningTotal());

		// count test
		int[] storeData5 = { 2, -3, 2, 0, 5, 2, 2, 6 };
		ArrayIntList myFullList5 = new ArrayIntList();
		for (int n : storeData5) {
			myFullList5.add(n);
		}

		// print output of the count method
		System.out.println("\nOccurrences in the list: " + myFullList5.count(2));

		// removeLast test
		int[] storeData6 = { 8, 17, 42, 3, 8 };
		ArrayIntList myFullList6 = new ArrayIntList();
		for (int n : storeData6) {
			myFullList6.add(n);
		}

		// print output of the removeLast method
		System.out.println("\nOriginal list before removing last number:" + " " + myFullList6.toString());
		System.out.println("The last number removed: " + myFullList6.removeLast());
		System.out.println("List after removal: " + myFullList6.toString());
		System.out.println("The last number removed: " + myFullList6.removeLast());
		System.out.println("List after removal: " + myFullList6.toString());
		System.out.println("The last number removed: " + myFullList6.removeLast());
		System.out.println("List after removal: " + myFullList6.toString());

		ArrayIntList empty = new ArrayIntList();
		System.out.println("If list is empty: " + empty.removeLast());
	}
}
