import java.lang.Math;

public class Deck {// opens class

	private static Card[] deck = new Card[52]; // standard 52 card deck

	String[] suits = { "Diamonds", "Hearts", "Spades", "Clubs" };

	String[] face = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
			"King" };
	final int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

	public Deck() {// opens Deck()

		String s, f; // temp variables used to hold and populate deck. s = suits and f = face

		int i = 0;

		for (int j = 0; j < 4; j++) {// opens SUIT for

			s = suits[j];
			
			for (int k = 0; k < 13; k++) {// opens FACE loop

				deck[i] = new Card(suits[j], face[k], j, k, values[k]);

				i++;//egg

			} // closes FACE loop

		} // closes SUIT for loop
		
	
		
		shuffle(deck);
		
		for (int x = 0; x < 52; x++) {// opens for DECK

		} // closes for DECK

	}// close Deck()

	public static Card getCard(int a) {
		return deck[a];
	}

	public Card[] getdeck() {

		return deck;
	}
	
	public void shuffle(Card[] curDeck) {

		int rand;//variable to hold random numbers generated via Math.rand()
		Card temp;//variable to temporarily hold a card object

		for(int i = curDeck.length - 1; i >=0; i--) {//for
			
			rand = (int) (Math.random() * curDeck.length);//generate a rand # 0-51
			temp = curDeck[i];//temp is assigned the card at the current step
			curDeck[i] = curDeck[rand];//card index at current step is replaced with the one at rand
			curDeck[rand] = temp;//the rand spot is replaced by the card in temp
			
		}//for
		
		deck = curDeck;//place the shuffled cards back into the deck

		for(Card d: deck) {
			
			//System.out.println(d.getFace()+" of "+d.getSuit());
			
		}
	}

}// closes class