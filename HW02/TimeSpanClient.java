/* Mohamed Elfergani
 * CS 211
 * 4/22/2021
 * This client prints out the compareTo() to compare time1 with time2
 */
public class TimeSpanClient {
	public static void main(String[] args) {
		int h1 = 13, m1 = 30;
		TimeSpan t1 = new TimeSpan(h1, m1);

		System.out.println("New object t1: " + t1);
		h1 = 3;
		m1 = 40;
		System.out.println("Adding " + h1 + " hours, " + m1 + " minutes to t1");
		t1.add(h1, m1);
		System.out.println("New t1 state: " + t1);

		System.out.println();
		System.out.println("---------------------");
		System.out.println();

		// printing out using the compareTo() to compare t1 with t2
		TimeSpan t2 = new TimeSpan(12, 40);
		System.out.println("New object t2: " + t2);
		System.out.println("t1.compareTo(t2): " + t1.compareTo(t2));
		System.out.println("t2.compareTo(t1): " + t2.compareTo(t1));
		System.out.println("t1.compareTo(t1): " + t1.compareTo(t1));
	}
}