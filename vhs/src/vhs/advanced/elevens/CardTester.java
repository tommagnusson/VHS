package vhs.advanced.elevens;

import java.util.HashSet;
import java.util.Set;

public class CardTester {

	public static void main(String[] args) {
		
		Deck ordered = Deck.newOrderedDeck();
		while(ordered.getSize() > 0) {
			ordered.draw();
		}
		System.out.println(ordered.getSize());
		Deck anotherOrdered = Deck.newOrderedDeck();
		System.out.println(anotherOrdered.getSize());
	}
	
}
