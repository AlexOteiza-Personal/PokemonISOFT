package fonts;

import java.awt.image.BufferedImage;

public class PokemonListFont extends BitmapFont {
    private static final FontChar[] charmap = {
    	  new FontChar(' ', 5), new FontChar('!', 4),
 			new FontChar('"', 5), new FontChar('$', 5), new FontChar('%', 5), new FontChar('&', 5),
 			new FontChar('\'', 5), new FontChar('(', 5), new FontChar(')', 5), new FontChar('+', 5),
 			new FontChar(',', 4), new FontChar('-', 5), new FontChar('.', 4), new FontChar('/', 5),
 			new FontChar('0', 5), new FontChar('1', 5), new FontChar('2', 5), new FontChar('3', 5),
 			new FontChar('4', 5), new FontChar('5', 5), new FontChar('6', 6), new FontChar('7', 5),
 			new FontChar('8', 5), new FontChar('9', 5), new FontChar(':', 5), new FontChar(';', 5),
 			new FontChar('<', 5), new FontChar('=', 5), new FontChar('>', 5), new FontChar('?', 5),
 			new FontChar('A', 5), new FontChar('B', 5), new FontChar('C', 5), new FontChar('D', 5),
 			new FontChar('E', 5), new FontChar('F', 5), new FontChar('G', 5), new FontChar('H', 5),
 			new FontChar('I', 5), new FontChar('J', 5), new FontChar('K', 5), new FontChar('L', 5),
 			new FontChar('M', 5), new FontChar('N', 5), new FontChar('O', 5), new FontChar('P', 5),
 			new FontChar('Q', 5), new FontChar('R', 5), new FontChar('S', 5), new FontChar('T', 5),
 			new FontChar('U', 5), new FontChar('V', 5), new FontChar('W', 5), new FontChar('X', 5),
 			new FontChar('Y', 5), new FontChar('Z', 5), new FontChar('\\', 5), new FontChar('^', 5),
 			new FontChar('_', 5), new FontChar('`', 5), new FontChar('a', 5), new FontChar('b', 5),
 			new FontChar('c', 5), new FontChar('d', 5), new FontChar('e', 5), new FontChar('f', 5),
 			new FontChar('g', 5), new FontChar('h', 5), new FontChar('i', 4), new FontChar('j', 5),
 			new FontChar('k', 5), new FontChar('l', 4), new FontChar('m', 5), new FontChar('n', 5),
 			new FontChar('o', 5), new FontChar('p', 5), new FontChar('q', 5), new FontChar('r', 5),
 			new FontChar('s', 5), new FontChar('t', 5), new FontChar('u', 5), new FontChar('v', 5),
 			new FontChar('w', 5), new FontChar('x', 5), new FontChar('y', 5), new FontChar('z', 5),
 			new FontChar('¿', 5), new FontChar('¡', 5), new FontChar(CharConstants.MALE, 5),
 			new FontChar(CharConstants.FEMALE, 5), new FontChar('À', 5), new FontChar('Á', 5),
 			new FontChar('Â', 5), new FontChar('Ä', 5), new FontChar('Ç', 5), new FontChar('É', 5),
 			new FontChar('È', 5), new FontChar('Ê', 5), new FontChar('Ë', 5), new FontChar('Ì', 5),
 			new FontChar('Í', 5), new FontChar('Î', 5), new FontChar('Ï', 5), new FontChar('Ò', 5),
 			new FontChar('Ó', 5), new FontChar('Ô', 5), new FontChar('Ö', 5), new FontChar('Ù', 5),
 			new FontChar('Ú', 5), new FontChar('Û', 5), new FontChar('Ü', 5), new FontChar('Ñ', 5),
 			new FontChar('à', 5), new FontChar('á', 5), new FontChar('â', 5), new FontChar('ä', 5),
 			new FontChar('ç', 5), new FontChar('è', 5), new FontChar('é', 5), new FontChar('ê', 5),
 			new FontChar('ë', 5), new FontChar('ì', 5), new FontChar('í', 5), new FontChar('î', 5),
 			new FontChar('ï', 5), new FontChar('ò', 5), new FontChar('ó', 5), new FontChar('ô', 5),
 			new FontChar('ö', 5), new FontChar('ù', 5), new FontChar('ú', 5), new FontChar('û', 5),
 			new FontChar('ü', 5), new FontChar('ñ', 5)

    };
    private static final int charsizex = 5;
    private static final int charsizey = 12;

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
