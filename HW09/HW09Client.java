/* Mohamed Elfergani
* CS211
* 6/16/2021
* This client program tests our hashset of integers by adding and removing several elements from it
*/
import java.util.*;

public class HW09Client 
{
	public static void main(String[] args) 
	{
		// Exercise 01, 02, 03
		HashIntSet set1 = new HashIntSet();
		set1.add(3);
		set1.add(5);
		set1.add(6);
		set1.add(8);
		set1.add(9);

		// Exercise 01, 02, 03
		HashIntSet set2 = new HashIntSet();
		set2.add(3);
		set2.add(6);
		set2.add(8);

		// Exercise 02
		HashIntSet set3 = new HashIntSet();
		set3.add(3);
		set3.add(6);
		set3.add(7);
		set3.add(8);
		set3.add(9);
		set3.add(-1);

		// Exercise 09
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(42);
		pq.add(50);
		pq.add(45);
		pq.add(78);
		pq.add(61);
		pq.add(84);

		// Exercise 11
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		pq1.add(7);
		pq1.add(7);
		pq1.add(8);
		pq1.add(8);
		pq1.add(10);
		pq1.add(45);
		pq1.add(45);

		// Exercise 01
		System.out.println("Exercise 1: ");
		System.out.println("1st Set: " + set1.toString());
		System.out.println("2nd Set: " + set2.toString());
		set1.addAll(set2);
		System.out.println("Set after method addAll: " + set1.toString());

		// Exercise 02
		System.out.println("\nExercise 2: ");
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		System.out.println("Set3: " + set3.toString());
		System.out.println("Set1 contains Set2 after method containsAll: " + set1.containsAll(set2));
		System.out.println("Set1 contains Set3 after method containsAll: " + set1.containsAll(set3));

		// Exercise 03
		System.out.println("\nExercise 3: ");
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		System.out.println("Set1 equals Set1?: " + set1.equals(set1)); // true
		System.out.println("Set1 equals Set2?: " + set1.equals(set2)); // false
		System.out.println("Set2 equals Set2?: " + set2.equals(set2)); // true

		// Exercise 09
		System.out.println("\nExercise 9: ");
		System.out.println("Smallest kth value when k = 4: " + kthSmallest(pq, 4));

		// Exercise 11
		System.out.println("\nExercise 11: ");
		System.out.println("Queue before calling method removeDuplicates: " + pq1);
		removeDuplicates(pq1);
		System.out.println("Queue after calling method removeDuplicates: " + pq1);
	}

	 /* Mohamed Elfergani
	 * CS211
	 * 6/16/2021
	 * In this program we write a method called kthSmallest that accepts a PriorityQueue 
	 * of integers and an integer k as parameters and returns the kth-smallest integer 
	 * from the priority queue.
	 * 
	 * Chapter 18 Exercise 09
	 * 
	 */
	public static int kthSmallest(PriorityQueue<Integer> pq, int k) 
	{
		// if k is 0 or negative or greater than 0 throw an IllegalArgumentException
		if(k < 1 || k > pq.size())
			throw new IllegalArgumentException();

		// create a queue as an auxiliary storage
		Queue<Integer> myPQ = new PriorityQueue<Integer>();

		// adds all of pq to the specified myPQ
		myPQ.addAll(pq);

		// variable
		int kthValue = 0;

		// the int values are constant and cannot be changed in myPQ
		final int size = myPQ.size();

		// in the for loop if the condition is true loop will start. If false loop ends for size
		for(int i = 0; i < size; i++) 
		{
			// if i is less than k then it returns the minimum element in the queue
			if(i < k) 
			{
				kthValue = myPQ.peek();
			}

			// returns and removes myPQ at the front 
			myPQ.poll();
		}

		// return kthValue
		return kthValue;
	}

	 /* Mohamed Elfergani
	 * CS211
         * 6/16/2021
	 * In this program we write a method called removeDuplicates that accepts a PriorityQueue 
	 * of integers as a parameter and modifies the queue’s state so that any 
	 * element that is equal to another element in the queue is removed.
	 * 
	 * Chapter 18 Exercise 11
	 * 
	 */
	public static void removeDuplicates(PriorityQueue<Integer> pq1) 
	{
		// auxiliary storage using a Stack
		Stack<Integer> mySt = new Stack<Integer>();

		// repeat loop until pq1 is empty
		while(!pq1.isEmpty()) 
		{
			// remove and get myInput value from pq1
			int myInput = pq1.poll();

			// if myInput is already in the stack or not return false if not return true if found
			if(!mySt.contains(myInput)) 
			{
				// push myInput into the stack
				mySt.push(myInput);
			}
		}

		// repeats loop for mySt until its empty
		while(!mySt.isEmpty()) 
		{
			// removes top value from stack and adds it back to pq1
			pq1.add(mySt.pop());
		}
	}
}
