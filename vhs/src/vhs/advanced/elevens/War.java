package vhs.advanced.elevens;

import java.util.Iterator;

public class War {

	public static void main(String[] args) {
		boolean canAdvance = true;
		int sets = 0;
		while (canAdvance) {
			Deck deck = ArrayDeck.newShuffledDeck();
			int wins = 0;
			int losses = 0;
			Iterator<Card> it = deck.iterator();
			while (it.hasNext()) {
				Card playerCard = it.next();
				Card computerCard = it.next();
				if (playerCard.compareRankTo(computerCard) >= 0) {
					System.out.println("Your " + playerCard + " beat my " + computerCard);
					System.out.println("Battle won!");
					wins++;
				} else {
					System.out.println("My " + computerCard + " beat your " + playerCard);
					System.out.println("Battle lost.");
					losses++;
				}
				System.out.println(wins + ":" + losses);
				System.out.println("Net: " + (wins - losses));
				System.out.println();
				canAdvance = (wins-losses) >= 0;
			}
			System.out.println("Set complete.");
			sets++;
			System.out.println("Current set: " + sets);
		}
		System.out.println("You lost :(");
	}
	
}
