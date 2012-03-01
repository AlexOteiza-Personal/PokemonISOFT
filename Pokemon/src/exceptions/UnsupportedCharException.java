package exceptions;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;

public class UnsupportedCharException extends IOException {
    public UnsupportedCharException(char c)
    {
	super("Bitmap font doesnt support drawing character '"+c+"'");
    }
}
