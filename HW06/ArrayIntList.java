/*Mohamed Elfergani
 * CS 211
 * 5/19/2021
 * The purpose of this program is to do the following:
 * Write a method called lastIndexOf that accepts an integer as a parameter and returns the index in the list of the last occurrence of that value.
 * Write a method called lastIndexOf that accepts an integer as a parameter and returns the index in the list of the last occurrence of that value.
 * Write a method called runningTotal that returns a new ArrayIntList that contains a running total of the original list.
 * Write a method called count that accepts an element value as a parameter and returns the number of occurrences of that value in the list.
 * Write a method called removeLast that removes and returns the last value from a list of integers.
 */

// Class ArrayIntList can be used to store a list of integers.
import java.util.*;

public class ArrayIntList {

	private int[] elementData; // list of integers
	private int size; // current number of elements in the list

	public static final int DEFAULT_CAPACITY = 100;

	// before: capacity >= 0 (throws IllegalArgumentException if not)
	// after: constructs an empty list with the given capacity
	public ArrayIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		elementData = new int[capacity];
		size = 0;
	}

	// after: constructs an empty list of default capacity
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}

	// after: returns the current number of elements in the list
	public int size() {
		return size;
	}

	// before : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// after: returns the integer at the given index in the list
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	// after: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}
	}

	// after: returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (elementData[i] == value) {
				return i;
			}
		}
		return -1;
	}

	// after: returns true if list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	// after: returns true if the given value is contained in the list,
	// false otherwise
	public boolean contains(int value) {
		return indexOf(value) >= 0;
	}

	// before : size() < capacity (throws IllegalStateException if not)
	// after: appends the given value to the end of the list
	public void add(int value) {
		ensureCapacity(size + 1); // this public method throws the exception
		elementData[size] = value;
		size++;
	}

	// before : size() < capacity (throws IllegalStateException if not) &&
	// 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// after: inserts the given value at the given index, shifting subsequent
	// values right
	public void add(int index, int value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ensureCapacity(size + 1); // this public method throws the exception
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	// before : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// after: removes value at the given index, shifting subsequent values left
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}

	// before : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// after: replaces the integer at the given index with the given value
	public void set(int index, int value) {
		checkIndex(index);
		elementData[index] = value;
	}

	// after: list is empty
	public void clear() {
		size = 0;
	}

	// after: ensures that the underlying array has the given capacity; if not,
	// the size is doubled (or more if given capacity is even larger)
	private void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	// after: throws an IndexOutOfBoundsException if the given index is
	// not a legal index of the current list
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	public int lastIndexOf(int nextValue) {
		for (int i = size - 1; i >= 0; i--) {
			// if its equal to the nextValue
			if (elementData[i] == nextValue) {
				return i;
			}
		}
		return -1;
	}

	public int indexOfSubList(ArrayIntList listL) {
		// for loop shortens the bigger list
		for (int i = 0; i <= size - listL.size; i++) {
			// set variables for counting
			int countBothNums = 0;

			// for loop goes through smaller list
			for (int j = 0; j < listL.size; j++) {
				// compare if they are equal
				if (elementData[i + j] == listL.elementData[j])
					countBothNums++; // add 1 to count
			}

			/*
			 * check the size. If the count is equal to listL.size then we know its in the
			 * sequence
			 */
			if (countBothNums == listL.size)
				return i;
		}

		// if it is not in the sequence then its not there or it does not exist so
		// return a -1
		return -1;
	}

	public ArrayIntList runningTotal() {
		ArrayIntList myList = new ArrayIntList(size);

		// set variables
		int numNums = 0;

		// for loop used to loop through the ArrayIntList
		for (int i = 0; i < size; i++) {
			// sum and set value to sum the result after getting i
			numNums += elementData[i];

			// take the current value in sum and add it into the array
			myList.add(numNums);
		}

		// return the array
		return myList;
	}

	public int count(int tempValue) // Count method
	{
		// set variables
		int occurrence = 0;
		for (int i = 0; i < size; i++) {
			// if its equal to the value
			if (elementData[i] == tempValue)
				occurrence++; // add 1 to count
		}

		// return the total of the count variable
		return occurrence;
	}

	public int removeLast() {
		// if list is empty, hence size == 0, then throw NoSuchElementException
		if (size == 0) {
			throw new NoSuchElementException();
		}

		// this gets the last value within the list and assigns it to a variable
		int otherIt = elementData[size - 1];
		size--;

		// return last value removed
		return otherIt;
	}
}
