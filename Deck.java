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
public class Deck {// opens class

	private static Card[] deck = new Card[52];

	String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
	String[] face = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
			"King"};

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

		
		//show all cards just for testing purposes
		for (int x = 0; x < 52; x++) {

			System.out.println("You have a " + deck[x].getFace() + " of " + deck[x].getSuit());

		}

	}// closes Deck()
	
	public static Card getCard(int a) {
		return deck[a];
		
	}
	
	public Card[] getdeck() {
		
		return deck;
		
		
	}

}// closes class
