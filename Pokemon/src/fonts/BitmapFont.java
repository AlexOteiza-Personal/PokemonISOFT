package fonts;

import images.ImageInvalidSizeException;

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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.accessibility.Accessible;

import org.omg.CORBA.FREE_MEM;

/**
 * 
 * @author Alejandro An implementation of a Bitmap font.
 */
public abstract class BitmapFont {
	public static final int LEFT_ALIGN = 0;
	public static final int RIGHT_ALIGN = 1;
	public static final int CENTER_ALIGN = 2;
	private Map<Character, Image> imagesAlphabet;
	private int subImageSizeX;
	private int subImageSizeY;
	private int align;
	private int nextLineOffset;

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
	 * @param subImageSizeY
	 *            Character height
	 * @throws ImageInvalidSizeException
	 *             if the image width and height are not divisible by the given
	 *             character width and height
	 */
	public BitmapFont(BufferedImage bitmapImage, FontChar[] charmap, int subImageSizeX, int subImageSizeY) {
		this(bitmapImage, charmap, subImageSizeX, subImageSizeY, subImageSizeY, LEFT_ALIGN);
	}
	public BitmapFont(BufferedImage bitmapImage, FontChar[] charmap, int subImageSizeX, int subImageSizeY, int nextLineOffset) {
		this(bitmapImage, charmap, subImageSizeX, subImageSizeY, nextLineOffset, LEFT_ALIGN);
	}

	public BitmapFont(BufferedImage bitmapImage, FontChar[] charmap, int subImageSizeX, int subImageSizeY,
			 int nextLineOffset, int align) {
		if (bitmapImage.getHeight(null) % subImageSizeY != 0
				|| bitmapImage.getWidth(null) % subImageSizeX != 0) {
			try {
				throw new ImageInvalidSizeException(bitmapImage.getWidth(null), bitmapImage.getHeight(null),
						subImageSizeX, subImageSizeY);
			} catch (ImageInvalidSizeException e) {
				e.printStackTrace();
			}
		}
		this.align = align;
		this.subImageSizeX = subImageSizeX;
		this.subImageSizeY = subImageSizeY;
		this.nextLineOffset = nextLineOffset;
		setSubimages(bitmapImage, new CharMap(charmap));
		charmap = null;
	}

	private void setSubimages(BufferedImage bitmapImage, CharMap charmap) {
		imagesAlphabet = new HashMap<Character, Image>(charmap.getSize());
		int imagenumber = 0;
		int hImagenum = bitmapImage.getWidth() / subImageSizeX;
		int vImagenum = bitmapImage.getHeight() / subImageSizeY;

		for (int i = 0; i < vImagenum; i++) {
			for (int j = 0; j < hImagenum && imagenumber < charmap.getSize(); j++, imagenumber++) {
				FontChar c = charmap.getFontChar(imagenumber);
				imagesAlphabet.put(c.getChar(), (Image) bitmapImage.getSubimage(j * subImageSizeX, i
						* subImageSizeY, c.getWidth(), subImageSizeY));
			}

		}
		charmap = null;
	}

	public void drawString(Graphics g, String text, int x, int y) {
		String[] lines = text.split("\n");
		if (align == LEFT_ALIGN) {
			drawStringLeft(g, lines, x, y);
		} else if (align == RIGHT_ALIGN) {
			drawStringRight(g, lines, x, y);
		} else if (align == CENTER_ALIGN) {
			drawStringCenter(g, lines, x, y);
		}
	}

	private void drawStringLeft(Graphics g, String[] text, int x, int y) {
		int currentx=x;
		int currenty=y;
		for (int i = 0; i < text.length; i++) {
			currentx = x;
			drawLine(g, text[i], currentx, currenty);
			currenty += nextLineOffset;
		}
	}

	private void drawStringRight(Graphics g, String[] text, int x, int y) {
		
		int currentx;
		int currenty=y;
		for (int i = 0; i < text.length; i++) {
			currentx = x - getTextWidth(text[i]);
			drawLine(g,text[i],currentx,currenty);
			currenty+=nextLineOffset;
		}
	}

	private void drawStringCenter(Graphics g, String[] text, int x, int y) {
		int currentx;
		int currenty = y;
		for (int i = 0; i < text.length; i++) {
			currentx = x - (getTextWidth(text[i])/2);
			drawLine(g,text[i],currentx,currenty);
			currenty+=nextLineOffset;
		}
	}
	private void drawLine(Graphics g, String line, int x, int y) {
		for (int j = 0; j < line.length(); j++) {
			if (line.charAt(j) != '\n')
			{
				try {
					Image character = imagesAlphabet.get(line.charAt(j));
					if (character == null)
						throw new UnsupportedCharacterException(line.charAt(j));
					g.drawImage(character, x, y, null);
					x += character.getWidth(null);
				}
				catch (UnsupportedCharacterException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	private int getTextWidth(String text)
	{
		int sum=0;
		for (int i = 0; i < text.length(); i++) {
			Image character = imagesAlphabet.get(text.charAt(i));
			if (character != null)
				sum += character.getWidth(null);
		}
		return sum;
	}
}