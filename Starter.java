import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Starter extends JFrame implements ActionListener {
	Deck test = new Deck();
	private JFrame frame;
	private JLabel card = new JLabel("");
	int x;
	int y;
	int c = 0;
	private JButton button = new JButton("");

	public static void main(String[] args) {// opens main

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Starter window = new Starter();
					window.frame.setVisible(true);
					;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// closes main
	
	public Starter() {
		//System.out.println(Deck.getCard(20).gety());
		//c = 30;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800, 500);
		card.setBounds(110,111,51,70);
		button.setBounds(100,20,100,50);
		button.addActionListener(this);
		button.setText("Next");
		button.setFocusable(false);
		frame.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			x = Deck.getCard(c).getx();
			y = Deck.getCard(c).gety();
			frame.getContentPane().add(card);
			DeckImage deckImage = new DeckImage();
			BufferedImage cardImage = deckImage.getImage(x, y);
			card.setIcon(new ImageIcon(cardImage));
			System.out.println("You have a " + Deck.getCard(c).getFace() + " of " + Deck.getCard(c).getSuit());
			c++;
			if(c > test.getdeck().length -1) {
				c = 0;
			}
		}
	}

}