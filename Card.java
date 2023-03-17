
public class Card {//opens class

	private int rank;
	private String suit;
	private String face;
	
	
	public Card(String suitIn, String faceIn) {//open constructor
		
		suit = suitIn;
		face = faceIn;
		
	}//close constructor
	
	
	public String getSuit() {
		
		return suit;
		
	}
	
	public String getFace() {
		
		return face;
		
	}
	
}//close class
