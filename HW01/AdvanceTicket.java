/* Mohamed Elfergani
 * CS 211
 * 4/18/2021
 * This is a subclass that represents tha tickets purchased in advance.   
 */


// Creates a class to extend Ticket class
public class AdvanceTicket extends Ticket {

	private int day; // int variable
	int cost; // double variable

	public AdvanceTicket(int cost, int day) { // Constructor that consists of two arguments
		super(cost);
		if (day < 0) // days cannot be negative, throw an exception
			throw new IllegalArgumentException("Days can't be negative.");
		this.day = day;
	}

	// This is a getter and an if statement to show different prices on each day
	public double getPrice() {
		if (day >= 10) {
			price = 30.0;
		} else {
			price = 40.0;
		}
		return price;

	}
}