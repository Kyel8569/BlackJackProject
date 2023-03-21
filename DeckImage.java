import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DeckImage {
	static BufferedImage deckImage;

	DeckImage(File image) {
		try {
			deckImage = ImageIO.read(image);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	BufferedImage getImage(int row, int column) {
		int x = column * Constants.CardConstants.CARD_WIDTH;
		int y = row * Constants.CardConstants.CARD_HEIGHT;

		BufferedImage image = new BufferedImage(Constants.CardConstants.CARD_WIDTH, Constants.CardConstants.CARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();

		g.drawImage(deckImage, 0, 0, Constants.CardConstants.CARD_WIDTH, Constants.CardConstants.CARD_HEIGHT, x, y, x + Constants.CardConstants.CARD_HEIGHT, y + Constants.CardConstants.CARD_WIDTH, null);
		return image;
	}
}

