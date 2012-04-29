package utils;

import java.awt.Color;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
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
    public static BufferedImage getShadow(BufferedImage img, Color color){
    	
    	System.out.println(img.getColorModel());
    	
    	BufferedImage shadow = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
    	
    	int shadowColor = color.getRGB();
    	
    	int[] pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null,0,img.getWidth());
    	for (int i=0;i<pixels.length;i++) {
    		if(pixels[i]!=16777215)
    			pixels[i] = shadowColor;
		}
    	
    	shadow.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels,0,img.getWidth());
    	//rs.setPixels(0, 0, img.getWidth(), img.getHeight(), pixels);
    	//BufferedImage image = new BufferedImage(img.getColorModel(), rs, false, null);
    	return shadow;
    }
	public static BufferedImage[] getSubImages(BufferedImage source, int width, int height, int imageNum) {
		BufferedImage[] subImages = new BufferedImage[imageNum];
		int nWImages = source.getWidth()/width;
		int nHImages = source.getHeight()/height;
		for (int i = 0,index=0; i < nHImages && index<imageNum; i++) {
			for (int j = 0; j < nWImages; j++,index++) {
				subImages[index] = source.getSubimage(width*j, height*i, width, height);
			}
		}
		return subImages;
	}
}
