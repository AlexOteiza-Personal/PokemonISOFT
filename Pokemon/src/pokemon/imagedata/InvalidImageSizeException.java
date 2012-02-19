package pokemon.imagedata;

public class InvalidImageSizeException extends Exception {
	public InvalidImageSizeException(int width, int height) {
		super("Invalid image atributes: Width = "+ width + " Height = "+height);
	}
}