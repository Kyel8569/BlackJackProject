public class Card {//opens class

	private int rank;
	private String suit;
	private String face;
	private int x;
	private int y;
	
	
	public Card(String suitIn, String faceIn, int xIn, int yIn) {//open constructor
		
		suit = suitIn;
		face = faceIn;
		x = xIn;
		y = yIn;
	}//close constructor
	
	
	public String getSuit() {//get suit
		
		return suit;
		
	}//get suit
	
	public String getFace() {//get face
		
		return face;
		
	}//get face
	public int getx() {//get x
		return x;
	}//get x
	public int gety() {//get y
		return y;
	}//get y
	
}//close class
