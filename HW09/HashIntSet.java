        /* Mohamed Elfergani
	 * CS211
	 * 6/16/2021
         * Implements a set of integers using a hash table. 
         * The hash table uses separate chaining to resolve collisions.
	 */
import java.util.*;

/* Implements a set of integers using a hash table. 
 * The hash table uses separate chaining to resolve collisions.
 */

public class HashIntSet
{
	private static final double MAX_LOAD_FACTOR = 0.75;
	private HashEntry[] elementData;
	private int size;

	// Constructs an empty set.
	public HashIntSet() 
	{
		elementData = new HashEntry[10];
		size = 0;
	}

	// Adds the given element to this set, if it was not already
	// contained in the set.
	public void add(int value) 
	{
		if (!contains(value)) 
		{
			if (loadFactor() >= MAX_LOAD_FACTOR) 
			{
				rehash();
			}

			// insert new value at front of list
			int bucket = hashFunction(value);
			elementData[bucket] = new HashEntry(value, elementData[bucket]);
			size++;
		}
	}

	// Removes all elements from the set.
	public void clear() 
	{
		for (int i = 0; i < elementData.length; i++)
		{
			elementData[i] = null;
		}
		size = 0;
	}

	// Returns true if the given value is found in this set.
	public boolean contains(int value) 
	{
		int bucket = hashFunction(value);
		HashEntry current = elementData[bucket];
		while (current != null)
		{
			if (current.data == value) 
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns true if there are no elements in this queue.
	public boolean isEmpty() 
	{
		return size == 0;
	}

	// Removes the given value if it is contained in the set.
	// If the set does not contain the value, has no effect.
	public void remove(int value)
	{
		int bucket = hashFunction(value);
		if (elementData[bucket] != null) 
		{
			// check front of list
			if (elementData[bucket].data == value) 
			{
				elementData[bucket] = elementData[bucket].next;
				size--;
			}
			else 
			{
				// check rest of list
				HashEntry current = elementData[bucket];
				while (current.next != null && current.next.data != value) 
				{
					current = current.next;
				}

				// if the element is found, remove it
				if (current.next != null && current.next.data == value) 
				{
					current.next = current.next.next;
					size--;
				}
			}
		}
	}

	// Returns the number of elements in the queue.
	public int size() 
	{
		return size;
	}

	// Returns a string representation of this queue, such as "[10, 20, 30]";
	// The elements are not guaranteed to be listed in sorted order.
	public String toString() 
	{
		String result = "[";
		boolean first = true;
		if (!isEmpty()) 
		{
			for (int i = 0; i < elementData.length; i++) 
			{
				HashEntry current = elementData[i];
				while (current != null) 
				{
					if (!first) 
					{
						result += ", ";
					}
					result += current.data;
					first = false;
					current = current.next;
				}
			}
		}
		return result + "]";
	}

	// Returns the preferred hash bucket index for the given value.
	private int hashFunction(int value)
	{
		return Math.abs(value) % elementData.length;
	}

	private double loadFactor()
	{
		return (double) size / elementData.length;
	}

	// Resizes the hash table to twice its former size.
	private void rehash() 
	{
		// replace element data array with a larger empty version
		HashEntry[] oldElementData = elementData;
		elementData = new HashEntry[2 * oldElementData.length];
		size = 0;

		// re-add all of the old data into the new array
		for (int i = 0; i < oldElementData.length; i++) 
		{
			HashEntry current = oldElementData[i];
			while (current != null) 
			{
				add(current.data);
				current = current.next;
			}
		}
	}

	// Represents a single value in a chain stored in one hash bucket.
	private class HashEntry 
	{
		public int data;
		public HashEntry next;

		public HashEntry(int data) 
		{
			this(data, null);
		}

		public HashEntry(int data, HashEntry next) 
		{
			this.data = data;
			this.next = next;
		}
	}
	
	/* Mohamed Elfergani
	 * CS211
	 * 6/16/2021
	 * In this program we write a method in the HashIntSet class called addAll that accepts 
	 * another hash set as a parameter and adds all of the elements from the other 
	 * set into the current set.
	 * 
	 * Chapter 18 Exercise 01
	 * 
	 */
	public void addAll(HashIntSet set1) 
	{
		// for all entries repeat the loop for set1
		for (int i = 0; i < set1.elementData.length; i++)
		{
			// gets the myOther of set1  
			HashEntry myOther = set1.elementData[i];

			// repeats loop for all elements in the list
			while(myOther != null) 
			{
				// if myOther.data is found return true if not return false
				if(!this.contains(myOther.data)) 
					
					// verifying if myOther is in the set1 
					this.add(myOther.data);

				// gets the next myOther element
				myOther = myOther.next;
			}
		}
	}
	
	/* Mohamed Elfergani
	 * CS211
	 * 6/16/2021
	 * In this program we write a method in the HashIntSet class called containsAll 
	 * that accepts another hash set as a parameter and returns true if your set 
	 * contains every element from the other set.
	 * 
	 * Chapter 18 Exercise 02
	 * 
	 */
	public boolean containsAll(HashIntSet set2) 
	{
		// for everything entered here the loop is repeat for set2
		for(int i = 0; i < set2.elementData.length; i++)
		{
			// gets myCurrent of set2
			HashEntry myCurrent = set2.elementData[i];

			// repeats this loop for all of the elements in the given list
			while(myCurrent != null) 
			{
				// if contains(myCurrent.data) it returns false if not found
				if(!this.contains(myCurrent.data)) 
				{
					return false;
				}

				// reads myCurrent
				myCurrent = myCurrent.next;
			}
		}
		
		// returns true
		return true;
	}

	/* Mohamed Elfergani
	 * CS211
	 * 6/16/2021
	 * In this program we write a method in the HashIntSet class called equals that 
	 * accepts another hash set as a parameter and returns true if the two sets contain 
	 * exactly the same elements. The internal hash table size and ordering 
	 * of the elements does not matter, only the sets of elements themselves.
	 * 
	 * Chapter 18 Exercise 03
	 * 
	 */
	public boolean equals(HashIntSet set3) 
	{
		// if size is not set3.size it returns false 
		if(size != set3.size())
			return false;
		
		// for everything entered here in the loop it is repeated for set3
		for(int i = 0; i < size; i++) 
		{
			// gets myOther1 of set3
			HashEntry myOther1 = elementData[i];
			
			/* if myOther1 is not null depending on if
			 * its operands contains(myOther1.data) but return false 
			 */
			if(myOther1 != null && !set3.contains(myOther1.data))
				return false;
		}
		
		// returns true
		return true;
	}
}
