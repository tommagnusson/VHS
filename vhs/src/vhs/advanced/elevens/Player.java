package vhs.advanced.elevens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	private PokerHand hand;
	
	public Player(List<Card> smallHand, List<Card> publicCards) {
		checkSmallHandIs2(smallHand);
		List<Card> hand = new ArrayList<Card>(smallHand);
		hand.addAll(publicCards);
		this.hand = new PokerHand(hand);
	}
	
	private void checkSmallHandIs2(List<Card> smallHand) {
		if (smallHand.size() != 2) {
			throw new IllegalArgumentException("A player's small hand must be 2 cards in size");
		}
	}

	public PokerHand getHand() {
		return new PokerHand(hand);
	}

}
