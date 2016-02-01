package vhs.examples.elevens;

public class War {

	public static void main(String[] args) {
		boolean canAdvance = true;
		int sets = 0;
		while (canAdvance) {
			Deck deck = Deck.newShuffledDeck();
			int wins = 0;
			int losses = 0;
			while (deck.getSize() > 0) {
				Card playerCard = deck.draw();
				Card computerCard = deck.draw();
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
