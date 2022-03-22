/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = new String[3];
		ranks[0] = "one";
		ranks[1] = "two";
		ranks[2] = "three";
		String[] suits = new String[2];
		suits[0] = "spade";
		suits[1] = "diamond";
		int[] values = new int[3];
		values[0] = 1;
		values[1] = 2;
		values[2] = 3;
		Deck Kevin1 = new Deck(ranks, suits, values);
		System.out.println(Kevin1.size());
		Deck Kevin2 = new Deck(ranks, suits, values);
		System.out.println(Kevin2.deal());
		Deck Kevin3 = new Deck(ranks, suits, values);
		System.out.println(Kevin3);
			

		
	}
}
