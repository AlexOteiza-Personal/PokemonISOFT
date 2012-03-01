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

import exceptions.ImageInvalidSizeException;
import exceptions.UnsupportedCharException;

/**
 * 
 * @author Alejandro An implementation of a Bitmap font.
 */
public class BitmapFont {
    private Map<Character, Image> imagesAlphabet;
    private int charsizex;
    private int charsizey;

    /**
     * 
     * @param bitmapImage
     *            Image containing the font data
     * @param charnum
     *            Number of characters
     * @param startchar
     *            The starting character
     * @param charsizex
     *            Character width
     * @param charsizey
     *            Character height
     * @throws ImageInvalidSizeException
     *             if the image width and height are not divisible by the given
     *             character width and height
     */
    public BitmapFont(BufferedImage bitmapImage, FontChar[] charmap,
	    int charsizex, int charsizey)
	    throws ImageInvalidSizeException
    {
	if (bitmapImage.getHeight(null) % charsizey != 0
		|| bitmapImage.getWidth(null) % charsizex != 0)
	{
	    throw new ImageInvalidSizeException(bitmapImage.getWidth(null),
		    bitmapImage.getHeight(null), charsizex, charsizey);
	}
	
	this.charsizex = charsizex;
	this.charsizey = charsizey;
	setSubimages(bitmapImage, new CharMap(charmap));
    }

    private void setSubimages(BufferedImage bitmapImage,CharMap charmap)
    {
	imagesAlphabet = new HashMap<Character, Image>(charmap.getSize());
	int imagenumber = 0;
	int hImagenum = bitmapImage.getWidth() / charsizex;
	int vImagenum = bitmapImage.getHeight() / charsizey;

	for (int i = 0; i < vImagenum; i++)
	{
	    for (int j = 0; j < hImagenum && imagenumber < charmap.getSize(); j++, imagenumber++)
	    {
		FontChar c = charmap.getFontChar(imagenumber);
		imagesAlphabet.put(c.getChar(),
			    (Image) bitmapImage.getSubimage(j * charsizex, i* charsizey, c.getWidth(), charsizey));
	    }

	}
    }

    public void drawString(Graphics g, int x, int y, String text)

    {

	int currentx = x;
	int currenty = y;
	for (int i = 0; i < text.length(); i++)
	{
	    if (text.charAt(i) == '\n')
	    {
		currenty += charsizey;
		currentx = x;
	    }
	    else
	    {
		try
		{
		    Image character = imagesAlphabet.get(text.charAt(i));
		    if (character == null)
			throw new UnsupportedCharException(text.charAt(i));
		    g.drawImage(character, currentx, currenty, null);
		    currentx += character.getWidth(null);
		}
		catch (UnsupportedCharException ex)
		{
		    ex.printStackTrace();
		}
	    }
	}
    }
}
