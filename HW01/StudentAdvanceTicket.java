/* Mohamed Elfergani
 * CS 211
 * 4/18/2021
 * This class represents tickets purchased in advance by students. 
 */

public class StudentAdvanceTicket extends Ticket {

	// int variable
	int ticketNumber;
	int day;
	// double variable
	double ticketCost;

	// Constructor that consists of two arguments
	StudentAdvanceTicket(int ticketNumber, int day) {
		super(ticketNumber);
		this.day = day;
		if (day >= 10)
			ticketCost = 15;
		if (day < 10)
			ticketCost = 20;
	}

	// Returns the cost of the ticket
	public double getPrice() {
		return ticketCost;
	}

	// toString, asks for ID from students
	public String toString() {
		return super.toString() + " (ID required) ";
	}
}