package images;

public class ImageInvalidSizeException extends Exception {
	public ImageInvalidSizeException(int width, int height) {
		super("Invalid size: "+width+"px x "+height+"px");
	}

	public ImageInvalidSizeException(int width, int height, int subImageSizeX, int subImageSizeY) {
		super("Invalid size: "+width+"px x "+height+"px"+ " with subImage dimensions: "+subImageSizeX+"px x "+subImageSizeY+"px");
	}
}
