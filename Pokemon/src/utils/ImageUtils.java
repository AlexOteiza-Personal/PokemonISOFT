package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils {
    public static BufferedImage getWdirImage(String dir)
    {
	try
	{
	    return ImageIO.read(ImageUtils.class.getResource(dir));
	}
	catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    System.err.println("Error cargando la imagen:\""+dir+"\"");
	    e.printStackTrace();
	    return null;
	}
    }
}
