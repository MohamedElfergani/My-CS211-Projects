/* Mohamed Elfergani
 * CS 211
 * 4/18/2021
 * This class represents a walk-up event ticket. They have a price of $50.
 */

public class WalkupTicket extends Ticket {

	
	    public WalkupTicket(int value)
	    {
	        super(value);
	    }

	    // Setter
	    public WalkupTicket() 
	    {
	        this(0);
	    }

	    // Getter
	    public double getPrice()
	    {
	        price = 50.0;
	        return price;
	    }
	}