package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils {
    public static BufferedImage getWdirImage(String dir) throws IOException
    {
	 return ImageIO.read(ImageUtils.class.getResource(dir));
    }
}
