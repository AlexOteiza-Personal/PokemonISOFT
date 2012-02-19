package pokemon.imagedata;

public class ImageInvalidSizeException extends Exception {
	public ImageInvalidSizeException(int width, int height) {
		super("Invalid image atributes: Width = "+ width + " Height = "+height);
	}
}