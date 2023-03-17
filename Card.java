
public class Card {//opens class

	private int rank;
	private String suit;
	private String face;
	
	
	public Card(String suitIn, String faceIn) {//open constructor
		
		suit = suitIn;
		face = faceIn;
		
	}//close constructor
	
	
	public String getSuit() {//opens getSuit()
		
		return suit;
		
	}//close getSuit()
	
	public String getFace() {//open getFace()
		
		return face;
		
	}//close getFace()
	
}//close class
