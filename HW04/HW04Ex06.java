/* Mohamed Elfergani
 * CS211
 * 05/08/2021
 * The purpose of this program is to accepts an integer parameter nand prints the first n squares separated by commas, with the odd squares in descending order followed by the even squares in ascending order
 */
public class HW04Ex06 {

	public static void writeSquares(int number) {
		// if n is less than 1 then th eprogram will throw an IllegalArgumentException
		if (number < 1) {
			throw new IllegalArgumentException();
		}

		// else if the base is printed when n equals 1
		else if (number == 1) {
			System.out.print(1);
			return;
		}

		else {
			System.out.print((number - 1) * (number - 1));

			// if n returns false if the result is true or equal to 2
			if (number != 2) {
				// print out commas to separate the numbers
				System.out.print(", ");

				// calling function recursively
				writeSquares(number - 2);
			}

			// calling function recursively
			System.out.print(", " + number * number);
		}
	}

	public static void main(String[] args) {
		/*
		 * prints output of odd squares in descending order followed by the even squares
		 * in ascending order
		 */
		System.out.println("Result of method writeSquares: ");
		writeSquares(8);
	}
}
