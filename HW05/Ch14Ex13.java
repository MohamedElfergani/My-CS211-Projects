/* Mohamed Elfergani
 * CS 211
 * 5/16/2021
 * This class writes a method called expunge that accepts a stack of integers as a parameter and makes sure that the stack’s elements
 * are in nondecreasing order from top to bottom, by removing from the stack any element that is smaller than any element(s) on top of it.
 */

import java.util.*;

public class Ch14Ex13 {

	public static Stack<Integer> expunge(Stack<Integer> stStack) {

		Stack<Integer> newStackS = new Stack<Integer>();

		//checks stack to see if its empty
		if(stStack.empty())
			return stStack;

		// pushes the top element of stack to newStackS
		newStackS.push(stStack.pop());

		// runs loops as long as stack is not empty
		while(!stStack.empty()) 
		{
			
			//checks to see if element at the top of the stack is equal or 
			//greater than the element at the top of newStackS
			if(stStack.peek() >= newStackS.peek()) 
			{
				newStackS.push(stStack.pop());
			}

			else
			{
				stStack.pop(); // pops the top element of the stack
			}
		}

		/* pushes back to the stack
		 * runs the full loop unless newStackS is empty 
		 * then it will not compile
		 */
		while(!newStackS.empty()) 
		{
			stStack.push(newStackS.pop()); // pops the top element of newStackS and pushes it back 
											//into stack
		}

		// returns stack
		return stStack;
	}

	public static void main (String[] args) {

		// created a new Stack
		Stack<Integer> st = new Stack<Integer>();

		// elements added into the stack
		st.push(4);
		st.push(20);
		st.push(15);
		st.push(15);
		st.push(8);
		st.push(5);
		st.push(7);
		st.push(12);
		st.push(3);
		st.push(10);
		st.push(5);
		st.push(1);

		// prints the output of the elements
		System.out.println("Before Stack:\n" + st);
		System.out.println("After Stack:\n" + expunge(st));
	}
}