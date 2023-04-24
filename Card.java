public class Card {//opens class

	private int value;
	private String suit;
	private String face;
	private int x;
	private int y;
	
	
	public Card(String suitIn, String faceIn, int xIn, int yIn, int valueIn) {//open constructor
		
		suit = suitIn;
		face = faceIn;
		x = xIn;
		y = yIn;
		value = valueIn;
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
	public int getvalue() {//get value
		return value;
	}//get value
	public void setvalue(int newValue) {
		value = newValue;
	}
	
}//close class
