package fonts;

import java.awt.image.BufferedImage;

import exceptions.ImageInvalidSizeException;

public class PokemonListFont extends BitmapFont {
    private static final FontChar[] charmap = { 
    	new FontChar(' ', 5),
	    new FontChar('!', 5), new FontChar('"', 5), new FontChar('$', 5),
	    new FontChar('%', 5), new FontChar('&', 5), new FontChar('\'', 5),
	    new FontChar('(', 5), new FontChar(')', 5), new FontChar('+', 5),
	    new FontChar(',', 5), new FontChar('-', 5), new FontChar('.', 5),
	    new FontChar('/', 5), new FontChar('0', 5), new FontChar('1', 5),
	    new FontChar('2', 5), new FontChar('3', 5), new FontChar('4', 5),
	    new FontChar('5', 5), new FontChar('6', 5), new FontChar('7', 5),
	    new FontChar('8', 5), new FontChar('9', 5), new FontChar(':', 5),
	    new FontChar(';', 5), new FontChar('<', 5), new FontChar('=', 5),
	    new FontChar('>', 5), new FontChar('?', 5), new FontChar('A', 5),
	    new FontChar('B', 5), new FontChar('C', 5), new FontChar('D', 5),
	    new FontChar('E', 5), new FontChar('F', 5), new FontChar('G', 5),
	    new FontChar('H', 5), new FontChar('I', 4), new FontChar('J', 5),
	    new FontChar('K', 5), new FontChar('L', 5), new FontChar('M', 5),
	    new FontChar('N', 5), new FontChar('O', 5), new FontChar('P', 5),
	    new FontChar('Q', 5), new FontChar('R', 5), new FontChar('S', 5),
	    new FontChar('T', 4), new FontChar('U', 5), new FontChar('V', 5),
	    new FontChar('W', 5), new FontChar('X', 5), new FontChar('Y', 4),
	    new FontChar('Z', 5), new FontChar('\\', 5), new FontChar('^', 5),
	    new FontChar('_', 5), new FontChar('`', 5), new FontChar('a', 5),
	    new FontChar('b', 5), new FontChar('c', 5), new FontChar('d', 5),
	    new FontChar('e', 5), new FontChar('f', 5), new FontChar('g', 5),
	    new FontChar('h', 5), new FontChar('i', 4), new FontChar('j', 5),
	    new FontChar('k', 4), new FontChar('l', 5), new FontChar('m', 5),
	    new FontChar('n', 5), new FontChar('o', 5), new FontChar('p', 5),
	    new FontChar('q', 5), new FontChar('r', 5), new FontChar('s', 5),
	    new FontChar('t', 5), new FontChar('u', 5), new FontChar('v', 5),
	    new FontChar('w', 5), new FontChar('x', 5), new FontChar('y', 5),
	    new FontChar('z', 5), new FontChar(CharConstants.MALE, 5),
	    new FontChar(CharConstants.FEMALE, 5)

    };
    private static final int charsizex = 5;
    private static final int charsizey = 10;

    /**
     * 
     * @param bitmapImage
     * @param charsizex
     * @param charsizey
     * @throws ImageInvalidSizeException
     */
    public PokemonListFont(BufferedImage bitmapImage) {
    	super(bitmapImage, charmap, charsizex, charsizey);
    }
    public PokemonListFont(BufferedImage bitmapImage, int align) {
    	super(bitmapImage,charmap,charsizex,charsizey,align);
    }

}
