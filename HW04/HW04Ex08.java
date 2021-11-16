/* Mohamed Elfergani
 * CS211
 * 05/08/2021
 * The purpose of this program is to return the product of the first n even integers.
*/
public class HW04Ex08 {

	// method returns the product of first numsN integers
	public static int multiplyEvens(int numsN) {
		if (numsN <= 0)
			throw new IllegalArgumentException();

		// if numsN is equals to 1 then return 2
		else if (numsN == 1)
			return 2;

		// else recursive function is called
		else
			return (numsN * 2) * multiplyEvens(numsN - 1);
	}

	public static void main(String[] args) {
		// prints out function call to test multiplyEvens
		System.out.print("Result after method multiplyEvens: " + multiplyEvens(4));
	}
}
