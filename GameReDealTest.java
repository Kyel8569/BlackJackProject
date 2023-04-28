import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameReDealTest extends JFrame implements ActionListener {// opens class

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
	JLabel PS = new JLabel("");
	JLabel DS = new JLabel("");
	JLabel DOneCover = new JLabel("");
	JButton hit = new JButton();
	JButton stay = new JButton();
	JButton deal = new JButton();
	JButton redeal = new JButton("•Redeal•");
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
	boolean bust = false;

	JLabel testy = new JLabel("");

	public static void main(String[] args) {// opens main

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameReDealTest window = new GameReDealTest();
					window.frame.setVisible(true);
					;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// closes main

	public GameReDealTest() {// opens game
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
		
		redeal.setBounds(100, 20, 100, 50);
		redeal.addActionListener(this);
		redeal.setFocusable(false);
		frame.add(redeal);
		redeal.setVisible(false);

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

		Winner.setBounds(10, 300, 400, 15);
		frame.add(Winner);
		Winner.setVisible(false);
		PS.setBounds(10, 237, 100, 15);
		frame.add(PS);
		PS.setVisible(false);
		DS.setBounds(10, 137, 100, 15);
		frame.add(DS);
		DS.setVisible(false);
		
		testy.setBounds(300,20,1000,50);
		testy.setText("BOBERT");
		testy.setFont(new Font("Serif", Font.PLAIN, 55));
		frame.add(testy);

	}// closes game

	public void actionPerformed(ActionEvent e) {// opens action listener

		if (e.getSource() == deal) {// deal
			PScore = 0;
			DScore = 0;
			stay.setVisible(true);
			hit.setVisible(true);
			deal.setVisible(false);
			DOneCover.setVisible(true);
			/*
			 * max hand possible PCards(c); c++; PCards(c); c++; PCards(c); c += 11;
			 * PCards(c); c++; PCards(c); c++; PCards(c); c += 11; PCards(c); c++;
			 * PCards(c); c++; PCards(c); c += 11; PCards(c); c++; PCards(c); c++;
			 */

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

			if (PC == 11) {
				hit.setEnabled(false);
			}
			PCards(c);
			c++;
			if (bust) {
				hit.setEnabled(false);
				stay.setEnabled(false);
				DOneCover.setVisible(false);
				PScore();
				DScore();
				Winner(PScore, DScore);
			}

		} // hit

		if (e.getSource() == stay) {// stay
			hit.setEnabled(false);
			stay.setEnabled(false);
			DOneCover.setVisible(false);
			PScore();
			stayOne = true;
			while (DScore < 17) {
				DCards(c);
				c++;
				if (DC == 11) {
					System.out.println("ERROR Dealer hit");
				}
			}
			DScore();
			Winner(PScore, DScore);
		} // stay
		if(e.getSource() == redeal) {
			reset();
			
			stay.setVisible(true);
			hit.setVisible(true);
			hit.setEnabled(true);
			stay.setEnabled(true);
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
		}

	}// closes action listener

	private void PCards(int C) {
		PHand[PC] = C;
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
			System.out.println("ERROR player card");
		}
		PScore();

		// PHit9 = null;//clears a variable
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
			System.out.println("ERROR dealer card");
		}
		DScore();
	}

	private void PScore() {
		int score = 0;
		for (int i = 0; i < PC; i++) {
			score = score + Deck.getCard(PHand[i]).getvalue();
			// System.out.println(score);
			if (Deck.getCard(PHand[i]).getvalue() == 11) {
				ace = true;
			}
			PScore = score;
		}
		if (score > 21 && !ace) {
			bust = true;
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
			if (Deck.getCard(DHand[i]).getvalue() == 11) {
				DAce = true;
				// System.out.println(Deck.getCard(DHand[i]).getvalue()+"
				// "+Deck.getCard(DHand[i]).getFace());
			}
			DScore = score;
		}
		// System.out.println(DAce);
		if (score > 21 && DAce) {
			// System.out.println("Test");
			aceCheck(DC);
		}
	}

	private void aceCheck(int hand) {
		int i = 0;
		if (!stayOne) {

			while (i < hand && ace) {
				int value = Deck.getCard(PHand[i]).getvalue();
				if (value == 11) {
					Deck.getCard(PHand[i]).setvalue(1);
					ace = false;
				}
				i++;
			}
			ace = false;
			PScore();
		} else if (stayOne) {

			while (i < hand && DAce) {// while
				int value = Deck.getCard(DHand[i]).getvalue();
				if (value == 11) {// if
					Deck.getCard(DHand[i]).setvalue(1);
					DAce = false;
				} // if
				i++;
			} // while
			DAce = false;
			DScore();
		}
	}

	private void Winner(int Player, int Dealer) {

		Winner.setVisible(true);
		PS.setVisible(true);
		DS.setVisible(true);
		String win = null;
		if (Player > 21) {
			win = "Player Busts";
		} else if (Dealer > 21) {
			win = "Dealer Busts";
		} else if (Player > Dealer) {
			win = "Player Wins greater";
		} else if (Dealer > Player) {
			win = "Dealer Wins greater";
		} else if (Dealer == Player) {
			win = "Robert said PUSH!!";
		} else {
			System.out.println("ERROR Winner");
		}
		if (Player == 21 && Dealer != 21) {
			win = "Player Wins 21";
		} else if (Dealer == 21) {
			win = "Dealer Wins 21";
		}
		PS.setText("Player Score: " + Player);
		DS.setText("Dealer Score: " + Dealer);

		Winner.setText(win);
		hit.setVisible(false);
		stay.setVisible(false);
		redeal.setVisible(true);
	}

	private void reset() {
		PScore = 0;
		DScore = 0;
		DC1.setIcon(null);
		DC2.setIcon(null);
		PC1.setIcon(null);
		PC2.setIcon(null);
		PHit1.setIcon(null);
		PHit2.setIcon(null);
		PHit3.setIcon(null);
		PHit4.setIcon(null);
		PHit5.setIcon(null);
		PHit6.setIcon(null);
		PHit7.setIcon(null);
		PHit8.setIcon(null);
		PHit9.setIcon(null);
		DHit1.setIcon(null);
		DHit2.setIcon(null);
		DHit3.setIcon(null);
		DHit4.setIcon(null);
		DHit5.setIcon(null);
		DHit6.setIcon(null);
		DHit7.setIcon(null);
		DHit8.setIcon(null);
		DHit9.setIcon(null);
		Winner.setText("");
		PS.setText("");
		DS.setText("");
		x = 0;
		y = 0;
		c = 0;
		topCard = 0;
		PC = 0;
		DC = 0;
		xx = 111;
		yy = 211;
		XX = 110;
		YY = 111;
		stayOne = false;
		ace = false;
		DAce = false;
		bust = false;
		deck = new Deck();
	}
}// closes class
