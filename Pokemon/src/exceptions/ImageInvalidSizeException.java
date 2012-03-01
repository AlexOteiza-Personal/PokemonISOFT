package exceptions;

public class ImageInvalidSizeException extends Exception {
	public ImageInvalidSizeException(int width, int height) {
		super("Invalid image atributes: Width = "+ width + " Height = "+height);
	}
	public ImageInvalidSizeException(int width,int height, int subimagewidth,int subimageheight)
	{
	    super("Invalid image atributes: Width = "+ width + " Height = "+height
		    + " SubImage height: "+subimageheight+" Subimage width: "+subimagewidth );
	}
}