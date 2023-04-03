
/**
 * 
 * @author jbutka
 *
 *         This class represents a deck of cards, specifically a standard 52
 *         card deck for the purposes of a single deck version of Black Jack
 *         (AKA 21). This will include cards for each suit: Hearts, Spades,
 *         Diamonds and Clubs. It will also include cards 2, 3, 4, 5, 6, 7, 8,
 *         9, 10, J, K, A.
 *
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {// opens class

	private static Card[] deck = new Card[52];

	static String[] suits = { "Diamonds", "Hearts", "Spades", "Clubs" };
	static String[] face = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
			"Queen", "King" };

	private int length;

	/**
	 * Creates a standard 52 card deck
	 */
	public Deck() {// opens Deck()

		String s, f;

		int i = 0;

		for (int j = 0; j < 4; j++) {// go through each suit

			// System.out.println("I am gathering "+suits[j]);
			s = suits[j];

			for (int k = 0; k < 13; k++) {// go through each card value
				// System.out.println("ADDED "+face[k] +" to "+i);
				deck[i] = new Card(suits[j], face[k], j, k);
				// System.out.println(" SUIT "+deck[i].getSuit());
				i++;
			} // each card value

		} // each suit
		/*
		 * // show all cards just for testing purposes for (int x = 0; x < 52; x++) {
		 * 
		 * System.out.println("You have a " + deck[x].getFace() + " of " +
		 * deck[x].getSuit());
		 * 
		 * }
		 */
	}// closes Deck()

	public static Card getCard(int a) {
		return deck[a];

	}

	public Card[] getdeck() {

		return deck;

	}

	public static void shuffle(int t) {// shuffle

		int j = 0;
		int k = 0;
		int i = 0;
		int j2 = 0;
		int k2 = 0;
		int i2 = 0;
		for (int z = 0; z < t; z++) {
			i = (int) (Math.random() * deck.length);
			i2 = (int) (Math.random() * deck.length);
			k = deck[i].gety();
			k2 = deck[i2].gety();
			j = deck[i].getx();
			j2 = deck[i2].getx();

			deck[i] = new Card(suits[j], face[k], j, k);
			// System.out.println("You have a " + deck[i].getFace() + " of " +
			// deck[i].getSuit());
			deck[i2] = new Card(suits[j2], face[k2], j2, k2);
			// System.out.println("You have a " + deck[i2].getFace() + " of " +
			// deck[i2].getSuit());
			// System.out.println(deck.length);
		}
		for (int x = 0; x < 52; x++) {

			System.out.println("You have a " + deck[x].getFace() + " of " + deck[x].getSuit());

		}
	}// shuffle

}// closes class
