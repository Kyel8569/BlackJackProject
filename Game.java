import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame implements ActionListener {// opens class

	Deck deck = new Deck();
	int PHand[] = new int[Constants.getHCount()];
	int DHand[] = new int[Constants.getHCount()];

	private JFrame frame;
	JLabel DC1 = new JLabel("");
	JLabel DC2 = new JLabel("");
	JLabel PC1 = new JLabel("");
	JLabel PC2 = new JLabel("");
	JLabel PHit1 = new JLabel("");
	JLabel PHit2 = new JLabel("");
	JLabel PHit3 = new JLabel("");
	JLabel PHit4 = new JLabel("");
	JLabel PHit5 = new JLabel("");
	JLabel PHit6 = new JLabel("");
	JLabel PHit7 = new JLabel("");
	JLabel PHit8 = new JLabel("");
	JLabel PHit9 = new JLabel("");
	JLabel DHit1 = new JLabel("");
	JLabel DHit2 = new JLabel("");
	JLabel DHit3 = new JLabel("");
	JLabel DHit4 = new JLabel("");
	JLabel DHit5 = new JLabel("");
	JLabel DHit6 = new JLabel("");
	JLabel DHit7 = new JLabel("");
	JLabel DHit8 = new JLabel("");
	JLabel DHit9 = new JLabel("");
	JLabel Winner = new JLabel("");
	JLabel DOneCover = new JLabel("");
	JButton hit = new JButton();
	JButton stay = new JButton();
	JButton deal = new JButton();
	int x;
	int y;
	static int c = 0;
	int topCard = 0;
	int PC = 0;
	int DC = 0;
	int xx = 111;
	int yy = 211;
	int XX = 110;
	int YY = 111;
	int PScore = 0;
	int DScore = 0;
	boolean stayOne = false;
	boolean ace = false;
	boolean DAce = false;

	public static void main(String[] args) {// opens main

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
					;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// closes main

	public Game() {// opens game
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800, 500);

		hit.setBounds(100, 20, 100, 50);
		hit.addActionListener(this);
		hit.setText("•Hit•");
		hit.setFocusable(false);
		frame.add(hit);
		hit.setVisible(false);// hehehehe
		// ••••••••••••••
		stay.setBounds(200, 20, 100, 50);
		stay.addActionListener(this);
		stay.setText("•Stay•");
		stay.setFocusable(false);
		frame.add(stay);
		stay.setVisible(false);

		deal = new JButton();
		deal.setBounds(100, 20, 100, 50);
		deal.addActionListener(this);
		deal.setText("Deal");
		deal.setFocusable(false);
		frame.add(deal);

		JLabel cardLabel1 = new JLabel("");

		cardLabel1.setBounds(10, 11, 51, 70);
		frame.getContentPane().add(cardLabel1);
		DeckImage deckImage = new DeckImage();
		BufferedImage cardImage = deckImage.getImage(0, 15);
		cardLabel1.setIcon(new ImageIcon(cardImage));

		frame.getContentPane().add(DOneCover);
		DeckImage deckImage1 = new DeckImage();
		BufferedImage cardImage1 = deckImage1.getImage(0, 15);
		DOneCover.setIcon(new ImageIcon(cardImage1));
		DOneCover.setBounds(XX, YY, 51, 70);
		DOneCover.setVisible(false);

	}// closes game

	public void actionPerformed(ActionEvent e) {// opens action listener

		if (e.getSource() == deal) {// deal
			PScore = 0;
			DScore = 0;
			stay.setVisible(true);
			hit.setVisible(true);
			deal.setVisible(false);
			DOneCover.setVisible(true);

			PCards(c);
			c++;

			PCards(c);
			c++;

			DCards(c);
			c++;

			DCards(c);
			c++;

		} // deal

		if (e.getSource() == hit) {// hit
			// PH(c);
			PCards(c);
			c++;
			if (PC == 11) {
				hit.setEnabled(false);
			}

		} // hit

		if (e.getSource() == stay) {// stay
			hit.setEnabled(false);
			stay.setEnabled(false);
			DOneCover.setVisible(false);
			PScore();
			stayOne = true;
			while(DScore < 17) {
				DCards(c);
				c++;
				if(DC == 11) {
					System.out.println("ERROR Dealer hit");
				}
			}
			DScore();
			Winner(PScore, DScore);

		} // stay

	}// closes action listener

	private void PCards(int C) {
		PHand[PC] = C;
		// edit
		if (Deck.getCard(PHand[c]).getvalue() == 11) {
			ace = true;
		}
		int X = Deck.getCard(C).getx();
		int Y = Deck.getCard(C).gety();
		DeckImage deckImage = new DeckImage();
		BufferedImage cardImage = deckImage.getImage(X, Y);
		if (PC == 0) {
			frame.getContentPane().add(PC1);
			PC1.setIcon(new ImageIcon(cardImage));
			PC1.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 1) {
			frame.getContentPane().add(PC2);
			PC2.setIcon(new ImageIcon(cardImage));
			PC2.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 2) {
			frame.getContentPane().add(PHit1);
			PHit1.setIcon(new ImageIcon(cardImage));
			PHit1.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 3) {
			frame.getContentPane().add(PHit2);
			PHit2.setIcon(new ImageIcon(cardImage));
			PHit2.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 4) {
			frame.getContentPane().add(PHit3);
			PHit3.setIcon(new ImageIcon(cardImage));
			PHit3.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 5) {
			frame.getContentPane().add(PHit4);
			PHit4.setIcon(new ImageIcon(cardImage));
			PHit4.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 6) {
			frame.getContentPane().add(PHit5);
			PHit5.setIcon(new ImageIcon(cardImage));
			PHit5.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 7) {
			frame.getContentPane().add(PHit6);
			PHit6.setIcon(new ImageIcon(cardImage));
			PHit6.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 8) {
			frame.getContentPane().add(PHit7);
			PHit7.setIcon(new ImageIcon(cardImage));
			PHit7.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 9) {
			frame.getContentPane().add(PHit8);
			PHit8.setIcon(new ImageIcon(cardImage));
			PHit8.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		} else if (PC == 10) {
			frame.getContentPane().add(PHit9);
			PHit9.setIcon(new ImageIcon(cardImage));
			PHit9.setBounds(xx, yy, 51, 70);
			xx = xx + 51;
			PC++;
		}

		else {
			System.out.println("ERROR");
		}
		PScore();
	}

	private void DCards(int C) {
		DHand[DC] = C;
		int X = Deck.getCard(C).getx();
		int Y = Deck.getCard(C).gety();
		DeckImage deckImage = new DeckImage();
		BufferedImage cardImage = deckImage.getImage(X, Y);
		if (DC == 0) {
			DC++;
			frame.getContentPane().add(DC1);
			DC1.setIcon(new ImageIcon(cardImage));
			DC1.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 1) {
			DC++;
			frame.getContentPane().add(DC2);
			DC2.setIcon(new ImageIcon(cardImage));
			DC2.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 2) {
			DC++;
			frame.getContentPane().add(DHit1);
			DHit1.setIcon(new ImageIcon(cardImage));
			DHit1.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 3) {
			DC++;
			frame.getContentPane().add(DHit2);
			DHit2.setIcon(new ImageIcon(cardImage));
			DHit2.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 4) {
			DC++;
			frame.getContentPane().add(DHit3);
			DHit3.setIcon(new ImageIcon(cardImage));
			DHit3.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 5) {
			DC++;
			frame.getContentPane().add(DHit4);
			DHit4.setIcon(new ImageIcon(cardImage));
			DHit4.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 6) {
			DC++;
			frame.getContentPane().add(DHit5);
			DHit5.setIcon(new ImageIcon(cardImage));
			DHit5.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 7) {
			DC++;
			frame.getContentPane().add(DHit6);
			DHit6.setIcon(new ImageIcon(cardImage));
			DHit6.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 8) {
			DC++;
			frame.getContentPane().add(DHit7);
			DHit7.setIcon(new ImageIcon(cardImage));
			DHit7.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 9) {
			DC++;
			frame.getContentPane().add(DHit8);
			DHit8.setIcon(new ImageIcon(cardImage));
			DHit8.setBounds(XX, YY, 51, 70);
			XX = XX + 51;
		} else if (DC == 10) {
			frame.getContentPane().add(DHit9);
			DHit9.setIcon(new ImageIcon(cardImage));
			DHit9.setBounds(XX, YY, 51, 70);
			DC++;
		} else {
			System.out.println("ERROR");
		}
		if (Deck.getCard(DHand[C]).getvalue() == 11) {
			DAce = true;
			System.out.println(Deck.getCard(DHand[C]).getvalue()+" "+Deck.getCard(DHand[C]).getFace());
		}
		DScore();
	}

	private void PScore() {
		int score = 0;
		for (int i = 0; i < PC; i++) {
			score = score + Deck.getCard(PHand[i]).getvalue();
			// System.out.println(score);
			PScore = score;
		}
		if (score > 21 && ace) {
			// System.out.println(score);
			aceCheck(PC);
		}
		// System.out.println(score);

	}

	private void DScore() {
		int score = 0;
		for (int i = 0; i < DC; i++) {
			score = score + Deck.getCard(DHand[i]).getvalue();
			// System.out.println(score);
			DScore = score;
		}
		//System.out.println(DAce);
		if (score > 21 && DAce) {
			//System.out.println("Test");
			aceCheck(DC);
		}
	}

	private void aceCheck(int hand) {

		if (!stayOne) {
			// System.out.println("test");
			for (int i = 0; i < hand; i++) {
				int value = Deck.getCard(PHand[i]).getvalue();
				if (value == 11) {
					Deck.getCard(PHand[i]).setvalue(1);
					ace = false;
				}
				ace = false;

			}
			PScore();
		} else if (stayOne) {
			//System.out.println("dealer ace test");
			for (int i = 0; i < hand; i++) {
				int value = Deck.getCard(DHand[i]).getvalue();
				if (value == 11) {
					Deck.getCard(DHand[i]).setvalue(1);
					DAce = false;
				}
				DAce = false;
			}
			DScore();
		}
	}

	private void Winner(int Player, int Dealer) {

		if (Player > 21) {
			System.out.println("Player Busts");
		} else if (Dealer > 21) {
			System.out.println("Dealer Busts");
		} else if (Player > Dealer) {
			System.out.println("Player Wins greater");
		} else if (Dealer > Player) {
			System.out.println("Dealer Wins greater");
		}
		if (Player == 21 && Dealer != 21) {
			System.out.println("Player Wins 21");
		} else if (Dealer == 21) {
			System.out.println("Dealer Wins 21");
		}
		 System.out.println("Player Score: " + Player);
		 System.out.println("Dealer Score: " + Dealer);
	}

	/*
	 * private void Shuffle(int t){ Card temp; for(int q = 0; q < t; q++){
	 * 
	 * for(int l = Constants.getdeckCount() - 1; l >= 0; l--){ int rand = (int)
	 * (Math.random() * Constants.getdeckCount()); temp = Deck.getCard(l); deck[l] =
	 * deck[rand]; deck[rand] = temp; } } }
	 */

}// closes class
