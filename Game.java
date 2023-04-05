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
	JLabel DealerC1 = new JLabel("");
	JLabel DealerC2 = new JLabel("");
	JLabel PlayerC1 = new JLabel("");
	JLabel PlayerC2 = new JLabel("");
	JLabel PlayerHit = new JLabel("");
	JLabel PlayerHit2 = new JLabel("");
	JLabel PlayerHit3 = new JLabel("");
	JLabel PlayerHit4 = new JLabel("");
	JLabel PlayerHit5 = new JLabel("");
	JLabel PlayerHit6 = new JLabel("");
	JLabel PlayerHit7 = new JLabel("");
	JLabel PlayerHit8 = new JLabel("");
	JLabel PlayerHit9 = new JLabel("");
	JLabel DealerHit = new JLabel("");
	JLabel DealerHit2 = new JLabel("");
	JLabel DealerHit3 = new JLabel("");
	JLabel DealerHit4 = new JLabel("");
	JLabel DealerHit5 = new JLabel("");
	JLabel DealerHit6 = new JLabel("");
	JLabel DealerHit7 = new JLabel("");
	JLabel DealerHit8 = new JLabel("");
	JLabel DealerHit9 = new JLabel("");
	// JLabel Winner = new JLabel("");
	JLabel DOneCover = new JLabel("");
	JButton hit = new JButton();
	JButton stay = new JButton();
	JButton deal = new JButton();
	int x;
	int y;
	int c = 0;

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
		hit.setText("Hit");
		hit.setFocusable(false);
		frame.add(hit);
		hit.setVisible(false);//hehehehe
		//•
		stay.setBounds(100, 20, 100, 50);
		stay.addActionListener(this);
		stay.setText("Stay");
		stay.setFocusable(false);
		frame.add(stay);
		stay.setVisible(false);
		
	}// closes game

	public void actionPerformed(ActionEvent e) {// opens action listener

	}// closes action listener

}// closes class
