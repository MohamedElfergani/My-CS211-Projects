/* Mohamed Elfergani
 * CS 211
 * 4/18/2021
 * This Client class print all the tickets, their price, and number.
 */
public class ClientTicket {
	public static void main(String[] args) {

		// Client test for tickets
		Ticket Num1 = new AdvanceTicket(9, 11);
		Ticket Num2 = new AdvanceTicket(6, 8);
		Ticket Num3 = new WalkupTicket(7);
		Ticket Num4 = new StudentAdvanceTicket(9, 8);
		Ticket Num5 = new StudentAdvanceTicket(7, 12);
		
		
		// prints out each number of ticket and the price
		System.out.println("(9, 11) Test for AdvancedTicket.java: ");
		System.out.print(Num1); // Number: 9, Price: 30.0
		
		System.out.println();
		System.out.println();

		System.out.println("(6, 8) Test for AdvancedTicket.java: ");
		System.out.println(Num2); // Number: 6, Price: 40.0
		
		System.out.println();
		System.out.println();
		
		System.out.println("(6) Test for WalkupTicket.java: ");
		System.out.println(Num3); // Number: 6, Price: 0.0
		
		System.out.println();
		System.out.println();
		
		System.out.println("(6, 8) Test for StudentAdvancedTicket.java: ");
		System.out.println(Num4); // Number: 6, Price: 20.0 (ID required) 
		
		System.out.println();
		System.out.println();
		
		System.out.println("(7, 12) Test for StudentAdvancedTicket.java: ");
		System.out.println(Num5); // Number: 7, Price: 15.0 (ID required) 
		
		
		

	}
}
