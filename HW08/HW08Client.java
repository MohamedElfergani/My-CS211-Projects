/* Mohamed Elfergani
 * CS 211
 * 6/6/2021
 * Short program that demonstrates the use of the IntTree class.
 */

public class HW08Client {
	public static void main(String[] args) {
		
		IntTree t = new IntTree(15);
		System.out.println("Tree structure: ");
		System.out.println();
		t.printSideways();
		System.out.println();
		t.printPreorder();
		t.printInorder();
		t.printPostorder();

		// returns the number of left children
		System.out.println("\nNumber of left children in the left node: " + t.countLeftNodes());
		System.out.println();

		// prints out the values at n from left to right
		System.out.println("Values at n from left to right: ");
		t.printLevel(3); // 4 5 6 7
		System.out.println();

		/*
		 * prints out the entire binary tree as a String. Returned data is in
		 * parenthesis with elements separated by commas.
		 */
		System.out.println("Binary Tree in String form: " + t.toString());
	}
}
