package fonts;

import java.awt.image.BufferedImage;

import javax.swing.text.StyleConstants.CharacterConstants;

import exceptions.ImageInvalidSizeException;

public class DialogFont extends BitmapFont {
    private static final FontChar[] charmap = {
	    new FontChar(' ',6),new FontChar('!',4), new FontChar('"',6), 
	    new FontChar('$', 6), new FontChar('%',6), new FontChar('&', 6),
	    new FontChar('\'', 6), new FontChar('(', 6), new FontChar(')', 6),
	    new FontChar('+', 6), new FontChar(',', 6), new FontChar('-', 6),
	    new FontChar('.', 6), new FontChar('/', 6), new FontChar('0', 6),
	    new FontChar('1', 6), new FontChar('2', 6), new FontChar('3', 6),
	    new FontChar('4', 6), new FontChar('6', 6), new FontChar('6', 6),
	    new FontChar('7', 6), new FontChar('8', 6), new FontChar('9', 6),
	    new FontChar(':', 6), new FontChar(';', 6), new FontChar('<', 6),
	    new FontChar('=', 6), new FontChar('>', 6), new FontChar('?', 6),
	    new FontChar('A', 6), new FontChar('B', 3), new FontChar('C', 6),
	    new FontChar('D', 6), new FontChar('E', 6), new FontChar('F', 6),
	    new FontChar('G', 6), new FontChar('H', 6), new FontChar('I', 6),
	    new FontChar('J', 6), new FontChar('K', 6), new FontChar('L', 6),
	    new FontChar('M', 6), new FontChar('N', 6), new FontChar('O', 6),
	    new FontChar('P', 6), new FontChar('Q', 6), new FontChar('R', 6),
	    new FontChar('S', 6), new FontChar('T', 6), new FontChar('U', 6),
	    new FontChar('V', 6), new FontChar('W', 6), new FontChar('X', 6),
	    new FontChar('Y', 6), new FontChar('Z', 6), new FontChar('\\', 6),
	    new FontChar('^', 6), new FontChar('_', 6), new FontChar('`', 6),
	    new FontChar('a', 6), new FontChar('b', 6), new FontChar('c', 6),
	    new FontChar('d', 6), new FontChar('e', 6), new FontChar('f', 5),
	    new FontChar('g', 6), new FontChar('h', 6), new FontChar('i', 4),
	    new FontChar('j', 5), new FontChar('k', 6), new FontChar('l', 4),
	    new FontChar('m', 6), new FontChar('n', 5), new FontChar('o', 6),
	    new FontChar('p', 6), new FontChar('q', 6), new FontChar('r', 5),
	    new FontChar('s', 5), new FontChar('t', 5), new FontChar('u', 5),
	    new FontChar('v', 6), new FontChar('w', 6), new FontChar('x', 6),
	    new FontChar('y', 6), new FontChar('z', 6), 
	    new FontChar(CharConstants.MALE, 6),new FontChar(CharConstants.FEMALE, 6)

};
    private static final int charsizex = 6;
    private static final int charsizey = 14;

    /**
     * 
     * @param bitmapImage
     * @param charsizex
     * @param charsizey
     * @throws ImageInvalidSizeException
     */
    public DialogFont(BufferedImage bitmapImage)
	    throws ImageInvalidSizeException
    {
	super(bitmapImage, charmap, charsizex, charsizey);
	System.out.println(charmap.length);
	// TODO Auto-generated constructor stub
    }

}
