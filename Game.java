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
	// JLabel Winner = new JLabel("");
	JLabel DOneCover = new JLabel("");
	JButton hit = new JButton();
	JButton stay = new JButton();
	JButton deal = new JButton();
	int x;
	int y;
	int c = 0;
	int topCard = 0;
	int PC = 0;
	int DC = 0;
	int xx = 111;
	int yy = 211;

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
		DOneCover.setBounds(110, 111, 51, 70);
		DOneCover.setVisible(false);

	}// closes game

	public void actionPerformed(ActionEvent e) {// opens action listener

		if (e.getSource() == deal) {// deal

			stay.setVisible(true);
			hit.setVisible(true);
			deal.setVisible(false);
			DOneCover.setVisible(true);

			c = (int) (Math.random() * 52);
			x = Deck.getCard(c).getx();
			y = Deck.getCard(c).gety();
			PCards(x, y);

			c = (int) (Math.random() * 52);
			x = Deck.getCard(c).getx();
			y = Deck.getCard(c).gety();
			PCards(x, y);

		} // deal
		
		if (e.getSource() == hit) {// hit
			
			c = (int) (Math.random() * 52);
			x = Deck.getCard(c).getx();
			y = Deck.getCard(c).gety();
			PCards(x, y);
			
		} // hit
		
		if (e.getSource() == stay) {// stay

		} // stay
		
	}// closes action listener

	private void PCards(int X, int Y) {
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
			System.out.println("Error");
		}
	}

	private void DCards(int X, int Y) {
		DeckImage deckImage = new DeckImage();
		BufferedImage cardImage = deckImage.getImage(X, Y);
	}

}// closes class
