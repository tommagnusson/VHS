package vhs.advanced.elevens;

import java.util.Iterator;
import java.util.Random;

public class ArrayDeck implements Deck, Iterable<Card> {

	private Card[] deck;
	private int size;
	
	/**
	 * Cache an instance of an ordered deck to avoid
	 * creating a new ordered deck object every time newShuffledDeck()
	 * is called.
	 * 
	 * Avoid creating unnecessary objects (Item 5)
	 *  */
	private static final Deck ORDERED = newOrderedDeck();
	
	// Same principle as ORDERED
	private static final Random RANDOM = new Random();
	
	private ArrayDeck(Card[] c) {
		deck = c.clone();
		size = deck.length;
	}
	
	private ArrayDeck(Deck d) {
		deck = d.toArray().clone();
		size = deck.length;
	}

	private static Deck generateOrderedDeck() {
		Card[] ordered = new Card[Card.NUM_UNIQUE_CARDS];
		
		for (int i = 0; i < ordered.length; i++) {
			ordered[i] = new Card(i);
		}
		
		return new ArrayDeck(ordered);
	}
	
	// Static factory method (Item 1)
	public static Deck newOrderedDeck() {
		// Cannot return ORDERED because it
		// would return the reference (able to be mutated)
		return generateOrderedDeck();
	}
	
	/**
	 * Implements the Fisher-Yates shuffle variation called
	 * the "inside out" algorithm.
	 * 
	 * Static Factory method (Item 1)
	 * 
	 * @return
	 * 		Shuffled deck
	 */
	public static Deck newShuffledDeck() {
		Card[] ordered = ORDERED.toArray();
		Card[] shuffled = new Card[Card.NUM_UNIQUE_CARDS];
		
		for (int i = 0; i < Card.NUM_UNIQUE_CARDS; i++) {
			int randomIndex = RANDOM.nextInt(i + 1); // 0 <= randomIndex <= i
			if (randomIndex != i) { 				 // if the randomIndex is not equal to the index...
				shuffled[i] = shuffled[randomIndex]; // replace the card at the current index with one of the previously placed cards
			}
			shuffled[randomIndex] = ordered[i]; 	 // the random index now takes the next ordered card
		}
		
		return new ArrayDeck(shuffled);
	}
	
	public int getSize() {
		return size;
	}
	
	public Card[] toArray() {
		return deck.clone();
	}
	
	public Card draw() {
		if (!isEmpty()) {
			size--;
			return deck[size];
		}
		throw new IllegalStateException("No more cards to draw. Check isEmpty() before using draw()");
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Card c: deck) {
			str.append(c + " \n");
		}
		return str.toString();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	private class CardIterator implements Iterator<Card> {
		
		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Card next() {
			return draw();
		}
		
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardIterator();
	}
	
	
}
