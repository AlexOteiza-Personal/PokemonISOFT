package fonts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuContainer;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;

import javax.accessibility.Accessible;

import org.omg.CORBA.FREE_MEM;

import exceptions.ImageInvalidSizeException;
import exceptions.UnsupportedCharException;

/**
 * 
 * @author Alejandro An implementation of a Bitmap font.
 */
public class BitmapFont {
	private Map<Character, Image> imagesAlphabet;
	private int subImageSizeX;
	private int subImageSizey;

	/**
	 * 
	 * @param bitmapImage
	 *            Image containing the font data
	 * @param charnum
	 *            Number of characters
	 * @param startchar
	 *            The starting character
	 * @param subImageSizeX
	 *            Character width
	 * @param subImageSizey
	 *            Character height
	 * @throws ImageInvalidSizeException
	 *             if the image width and height are not divisible by the given
	 *             character width and height
	 */
	public BitmapFont(BufferedImage bitmapImage, FontChar[] charmap, int subImageSizeX, int subImageSizey)

	{
		if (bitmapImage.getHeight(null) % subImageSizey != 0 || bitmapImage.getWidth(null) % subImageSizeX != 0) {
			try {
				throw new ImageInvalidSizeException(bitmapImage.getWidth(null), bitmapImage.getHeight(null),
						subImageSizeX, subImageSizey);
			} catch (ImageInvalidSizeException e) {
				e.printStackTrace();
			}
		}

		this.subImageSizeX = subImageSizeX;
		this.subImageSizey = subImageSizey;
		setSubimages(bitmapImage, new CharMap(charmap));
		charmap = null;
	}

	private void setSubimages(BufferedImage bitmapImage, CharMap charmap) {
		imagesAlphabet = new HashMap<Character, Image>(charmap.getSize());
		int imagenumber = 0;
		int hImagenum = bitmapImage.getWidth() / subImageSizeX;
		int vImagenum = bitmapImage.getHeight() / subImageSizey;

		for (int i = 0; i < vImagenum; i++) {
			for (int j = 0; j < hImagenum && imagenumber < charmap.getSize(); j++, imagenumber++) {
				FontChar c = charmap.getFontChar(imagenumber);
				imagesAlphabet.put(c.getChar(), (Image) bitmapImage.getSubimage(j * subImageSizeX, i * subImageSizey,
						c.getWidth(), subImageSizey));
			}

		}
		charmap = null;
	}

	public void drawString(Graphics g,String text, int x, int y)

	{

		int currentx = x;
		int currenty = y;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '\n') {
				currenty += subImageSizey;
				currentx = x;
			} else {
				try {
					Image character = imagesAlphabet.get(text.charAt(i));
					if (character == null)
						throw new UnsupportedCharException(text.charAt(i));
					g.drawImage(character, currentx, currenty, null);
					currentx += character.getWidth(null);
				} catch (UnsupportedCharException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
