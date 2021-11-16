/* Mohamed Elfergani
 * CS211
 * 05/08/2021
 * The purpose of this program is to take a string as a parameter and return a string in which all of the vowels have been moved to the end.
 * The vowels should appear in reverse order of what they were in the original word
*/
public class HW04Ex15 {

	public static String vowelsToEnd(String aLetter) {
		// if entire string traversed then return the final string
		if (!aLetter.isEmpty()) {
			// declare the character type variables and methods
			char letterCh = Character.toLowerCase(aLetter.charAt(0));
			String input = vowelsToEnd(aLetter.substring(1)); // String

			// if letterCh is a vowel return the input + String aLetter from the method
			if (letterCh == 'a' || letterCh == 'e' || letterCh == 'i' || letterCh == 'o' || letterCh == 'u') {
				return input + aLetter.charAt(0);
			}

			// else return the String aLetter + input from the method reversed
			else {
				return aLetter.charAt(0) + input;
			}
		}

		// return empty value
		return "";
	}

	public static void main(String[] args) {
		// print output of the word beautifully
		System.out.println("After vowels are reversed of the word beautifully: ");
		String aLetter = "beautifully";
		System.out.println(vowelsToEnd(aLetter));
	}
}
