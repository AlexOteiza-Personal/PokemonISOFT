package fonts;

public class UnsupportedCharacterException extends Exception{

	public UnsupportedCharacterException(char character) {
		super(Character.toString(character));
	}
}
