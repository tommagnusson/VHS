package vhs.examples.enums;

import java.util.ArrayList;
import java.util.List;

import vhs.examples.enums.Card.Rank;
import vhs.examples.enums.Card.Suit;

public class EnumTester {

	public static void main(String[] args) {
		Card[] deck = generateDeck();
		System.out.println(deck[0]);
	}
	
	private static Card[] generateDeck() {
		List<Card> preDeck = new ArrayList<Card>(Suit.values().length * Rank.values().length);
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				preDeck.add(new Card(r, s));
			}
		}
		return preDeck.toArray(new Card[preDeck.size()]);
	}
}
