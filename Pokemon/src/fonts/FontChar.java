package fonts;

public class FontChar {
	private char character;
	private int width;

	FontChar(char character, int width) {
		this.character = character;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public char getChar() {
		return character;
	}

}
