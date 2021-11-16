/* Mohamed Elfergani
 * CS 211
 * 5/16/2021
 * This class writes a method called rearrange that accepts a queue of integers as a parameter and rearranges 
 * the order of the values so that all of the even values appear before the odd values and that otherwise preserves the original order of the queue.
 */

import java.util.*;

public class Ch14Ex06 {

	public static void rearrange(Queue<Integer> queueQ) {
		Stack<Integer> stackST = new Stack<Integer>();
		int beforeList = queueQ.size();

		for (int i = 0; i < beforeList; i++) {
			//removes the last element returned in the collection
			int number1 = queueQ.remove();

			// Even elements are added back to the list
			if (number1 % 2 == 0) {
				// the push method is used to push an element back into the top of the Stack
				stackST.push(number1);
			}

			else {
				// the add method is used to add a specific element
				queueQ.add(number1);
			}
		}

		for (int i = 0; i < 2; i++) {
			while (!queueQ.isEmpty()) {
				//removes the last element returned in the collection
				stackST.push(queueQ.remove());
			}

			// Order of the odd elements are reversed so as to match the actual order
			while (!stackST.isEmpty()) {
				/*
				 * the pop method is used to remove the object at the top of the stack and
				 * returns that object as the value of the function.
				 */
				queueQ.add(stackST.pop());
			}
		}
	}

	public static void main(String[] args) {
		int[] list = { 3, 5, 4, 17, 6, 83, 1, 84, 16, 37 };
		int myList = list.length;

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < myList; i++)
			q.add(list[i]);

		// prints the original list of integers
		System.out.print("Before Queue List:\n");
		System.out.println(q);

		// rearranges the list of integers
		rearrange(q);

		// prints the sorted array
		System.out.print("After Queue List:\n");
		System.out.println(q);
	}
}
