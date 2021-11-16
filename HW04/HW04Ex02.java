/* Mohamed Elfergani
 * CS211
 * 05/08/2021
 * The purpose of this program is to take an integer n as a parameter and prints to the console the first n 
 * integers starting with 1 in sequential order, separated by commas.
 */
public class HW04Ex02 {

	public static void writeNums(int number1) 
	{
		// if number1 is less that 1 then the program is going to throw an IllegalArgumentException
		if (number1 < 1) 
		{
			throw new IllegalArgumentException();
		} 
		
		// else if number1 is equal to 1 then print out the number 1
		else if (number1 == 1) 
		{
			System.out.print("1");
		} 
		
		// else recursive called to display the number sequence
		else 
		{
			writeNums(number1 - 1);
			System.out.print(", " + number1);
		}
	}
	
	public static void main(String[] args) 
	{
		// print output method called with number 5
		System.out.println("Result after the method called by the number 5: ");
		writeNums(5);
		
		// print output method called with number 12
		System.out.println("\nResult after the method called by the number 12: ");
		writeNums(12);
		
		// print output method called with number 20
		System.out.println("\nResult after the method called by the number 20: ");
		writeNums(20);
	}
}
