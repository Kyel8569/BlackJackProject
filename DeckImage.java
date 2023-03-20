import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class DeckImage {
	final int WIDTH = 51;
	final int HEIGHT = 70;
	static BufferedImage deckImage;

	DeckImage() {
		InputStream stream = getClass().getResourceAsStream("cards.png");
		try {
			deckImage = ImageIO.read(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	BufferedImage getImage(int row, int column) {
		int x = column * WIDTH;
		int y = row * HEIGHT;

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();

		g.drawImage(deckImage, 0, 0, WIDTH, HEIGHT, x, y, x + WIDTH, y + HEIGHT, null);
		return image;
	}
}

