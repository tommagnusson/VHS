package vhs.advanced.elevens;

import java.util.HashSet;
import java.util.Set;

public class CardTester {

	public static void main(String[] args) {
		
		Deck ordered = ArrayDeck.newOrderedDeck();
		while (!ordered.isEmpty()) {
			ordered.draw();
		}
		System.out.println(ordered.getSize());
		Deck anotherOrdered = ArrayDeck.newOrderedDeck();
		System.out.println(anotherOrdered.getSize());
		System.out.println(ArrayDeck.newShuffledDeck());
	}
	
}
