/* Mohamed Elfergani
 * CS211
 * 05/08/2021
 * The purpose of this program is to accept an integer as a parameter and writes its binary representation to the console
 */
public class HW04Ex05 {

	public static void writeBinary(int number, int countS) {
		/*
		 * if countC is less than 6 method writeBinary will have the intege num / 2
		 * whereas int countC will be adding 1 then print out the int num which gives
		 * the remainder of integer divided by 2
		 */
		if (countS < 6) {
			// calling method recursively
			writeBinary(number / 2, countS + 1);
			System.out.print(number % 2); // print out the remainder of input values
		}
	}

	// method prints the binary representation of the integer value listed
	public static void writeBinary(int numbers) {
		writeBinary(numbers, 0);
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Binary representation of the number 44: ");
		writeBinary(44);

		System.out.println("\nBinary representation of the number 100: ");
		writeBinary(100);

		System.out.println("\nBinary representation of the number 243: ");
		writeBinary(243);

		System.out.println("\nBinary representation of the number 1000: ");
		writeBinary(1000);
	}
}