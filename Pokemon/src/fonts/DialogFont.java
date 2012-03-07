package fonts;

import java.awt.image.BufferedImage;

import javax.swing.text.StyleConstants.CharacterConstants;

import exceptions.ImageInvalidSizeException;

public class DialogFont extends BitmapFont {
	private static final FontChar[] charmap = { new FontChar(' ', 6), new FontChar('!', 4),
			new FontChar('"', 6), new FontChar('$', 6), new FontChar('%', 6), new FontChar('&', 6),
			new FontChar('\'', 6), new FontChar('(', 6), new FontChar(')', 6), new FontChar('+', 6),
			new FontChar(',', 4), new FontChar('-', 6), new FontChar('.', 4), new FontChar('/', 6),
			new FontChar('0', 6), new FontChar('1', 6), new FontChar('2', 6), new FontChar('3', 6),
			new FontChar('4', 6), new FontChar('5', 5), new FontChar('6', 6), new FontChar('7', 6),
			new FontChar('8', 6), new FontChar('9', 6), new FontChar(':', 6), new FontChar(';', 6),
			new FontChar('<', 6), new FontChar('=', 6), new FontChar('>', 6), new FontChar('?', 6),
			new FontChar('A', 6), new FontChar('B', 6), new FontChar('C', 6), new FontChar('D', 6),
			new FontChar('E', 6), new FontChar('F', 6), new FontChar('G', 6), new FontChar('H', 6),
			new FontChar('I', 6), new FontChar('J', 6), new FontChar('K', 6), new FontChar('L', 6),
			new FontChar('M', 6), new FontChar('N', 6), new FontChar('O', 6), new FontChar('P', 6),
			new FontChar('Q', 6), new FontChar('R', 6), new FontChar('S', 6), new FontChar('T', 6),
			new FontChar('U', 6), new FontChar('V', 6), new FontChar('W', 6), new FontChar('X', 6),
			new FontChar('Y', 6), new FontChar('Z', 6), new FontChar('\\', 6), new FontChar('^', 6),
			new FontChar('_', 6), new FontChar('`', 6), new FontChar('a', 6), new FontChar('b', 6),
			new FontChar('c', 6), new FontChar('d', 6), new FontChar('e', 6), new FontChar('f', 5),
			new FontChar('g', 6), new FontChar('h', 6), new FontChar('i', 4), new FontChar('j', 6),
			new FontChar('k', 6), new FontChar('l', 4), new FontChar('m', 6), new FontChar('n', 6),
			new FontChar('o', 6), new FontChar('p', 6), new FontChar('q', 6), new FontChar('r', 6),
			new FontChar('s', 5), new FontChar('t', 5), new FontChar('u', 5), new FontChar('v', 6),
			new FontChar('w', 6), new FontChar('x', 6), new FontChar('y', 6), new FontChar('z', 6),
			new FontChar('¿', 6), new FontChar('¡', 5), new FontChar(CharConstants.MALE, 6),
			new FontChar(CharConstants.FEMALE, 6), new FontChar('À', 6), new FontChar('Á', 6),
			new FontChar('Â', 6), new FontChar('Ä', 6), new FontChar('Ç', 6), new FontChar('É', 6),
			new FontChar('È', 6), new FontChar('Ê', 6), new FontChar('Ë', 6), new FontChar('Ì', 6),
			new FontChar('Í', 6), new FontChar('Î', 6), new FontChar('Ï', 6), new FontChar('Ò', 6),
			new FontChar('Ó', 6), new FontChar('Ô', 6), new FontChar('Ö', 6), new FontChar('Ù', 6),
			new FontChar('Ú', 6), new FontChar('Û', 6), new FontChar('Ü', 6), new FontChar('Ñ', 6),
			new FontChar('à', 6), new FontChar('á', 6), new FontChar('â', 6), new FontChar('ä', 6),
			new FontChar('ç', 6), new FontChar('è', 6), new FontChar('é', 6), new FontChar('ê', 6),
			new FontChar('ë', 6), new FontChar('ì', 6), new FontChar('í', 6), new FontChar('î', 6),
			new FontChar('ï', 6), new FontChar('ò', 6), new FontChar('ó', 6), new FontChar('ô', 6),
			new FontChar('ö', 6), new FontChar('ù', 6), new FontChar('ú', 6), new FontChar('û', 6),
			new FontChar('ü', 6), new FontChar('ñ', 6)

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
	public DialogFont(BufferedImage bitmapImage) {
		super(bitmapImage, charmap, charsizex, charsizey);
	}

	public DialogFont(BufferedImage bitmapImage, int align) {
		super(bitmapImage, charmap, charsizex, charsizey, align);
	}

}
