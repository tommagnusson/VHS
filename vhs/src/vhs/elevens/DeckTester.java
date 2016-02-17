package vhs.elevens;

/**
 * This is a class that tests the ArrayDeck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the ArrayDeck operations for consistency.
	 *
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

		String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

		int[] pointValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		Deck deck = new Deck(ranks, suits, pointValues);
		System.out.println(deck);
		System.out.println("Dealt: " + deck.deal());
		System.out.println(deck.isEmpty());
		System.out.println(deck.size());
	}
}
