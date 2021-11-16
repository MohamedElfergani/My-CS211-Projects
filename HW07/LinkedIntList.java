/* Mohamed Elfergani
 * CS 211
 * 5/32/2021
 * This is the interface definition for the IntList data type
 */

//Class LinkedIntList can be used to store a list of integers.
public class LinkedIntList implements IntList {
	private ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList() {
		front = null;
	}

	// post: returns the current number of elements in the list
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// pre : 0 <= index < size()
	// post: returns the integer at the given index in the list
	public int get(int index) {
		return nodeAt(index).data;
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// post : returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	// post: appends the given value to the end of the list
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next);
		}
	}

	// pre : 0 <= index < size()
	// post: removes value at the given index
	public void remove(int index) {
		if (index == 0) {
			front = front.next;
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}

	// pre : 0 <= i < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	/*
	 * Mohamed Elfergani CS211 5/32/2021 In this program we will write a method
	 * called switchPairs that switches the order of values in the list in a
	 * pairwise fashion. The method essentially should switch the order of the first
	 * two values, then the next two values, and so on. If the list contains an odd
	 * number of values, then the final element is not moved.
	 * 
	 * Chapter 16 Exercise 08
	 * 
	 */
	public void switchPairs() {

		// if front and next is null, then there will be nothing, so it will just return
		// what is there
		if (front == null || front.next == null)
			return;

		// set variables
		ListNode nFirst1 = front;
		ListNode nSecond2 = nFirst1.next;
		nFirst1.next = nSecond2.next;
		nSecond2.next = nFirst1;
		front = nSecond2;

		ListNode newTemp1 = nFirst1;

		// while newTemp1 has a next node to mess with
		while (newTemp1.next != null) {
			// set variables
			nFirst1 = newTemp1.next;
			nSecond2 = nFirst1.next;

			// if nSecond2 is nothing then return the nFirst1
			if (nSecond2 == null)
				return;

			// if not then you would want to end up switching them and proceeding to next
			// ones
			nFirst1.next = nSecond2.next;
			nSecond2.next = nFirst1;
			newTemp1.next = nSecond2;
			newTemp1 = nFirst1;
		}
	}

	/*
	 * Mohamed Elfergani CS211 5/32/2021 In this program we will write a method
	 * called split that rearranges the elements of a list so that all of the
	 * negative values appear before all of the non-negatives. It doesn't matter
	 * what order the numbers are in, only that the negatives appear before the
	 * non-negatives, so there is only one possible solution.
	 * 
	 * Chapter 16 Exercise 12
	 * 
	 */
	public void split() {
		// if front and next is null then there will be nothing, so it will just return
		// what is there
		if (front == null)
			return;

		// set variables
		ListNode negativeNLast = null;
		ListNode currentC1 = front;
		ListNode positiveP = null;
		ListNode negativeN = null;

		// while currentN1 has a next node to mess with
		while (currentC1 != null) {
			// set variables for comparison
			ListNode next = currentC1.next;

			// if the currentN1 number is negativeN
			if (currentC1.data < 0) {
				// set to the negativeN variable
				currentC1.next = negativeN;
				negativeN = currentC1;

				// if the next is nothing
				if (negativeN.next == null)

					// this will be the last negative number
					negativeNLast = negativeN;
			}

			// else, the next one will be postiveP
			else {
				currentC1.next = positiveP;
				positiveP = currentC1;
			}

			// keeps going to through the next
			currentC1 = next;
		}

		// if the negativeN value is nothing, then the first one wil be a postive value
		if (negativeN == null) {
			front = positiveP;
		}

		else {
			// if we have a negativeN number then we will set it
			negativeNLast.next = positiveP;
			front = negativeN;
		}
	}
}