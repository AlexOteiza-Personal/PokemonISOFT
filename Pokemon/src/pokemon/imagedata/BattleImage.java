package pokemon.imagedata;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.swing.*;
public class BattleImage{
	int width = 80;
	int height = 80;
	BufferedImage image;
	public BattleImage(String filename) throws IOException, InvalidImageSizeException{
		BufferedImage tmp = ImageIO.read(getClass().getResource(filename));
		int tWidth = tmp.getWidth(null);
		int tHeight = tmp.getHeight(null);
		if(tWidth != width || tHeight != height)
			throw new InvalidImageSizeException(tWidth,tHeight);
		else
			image = tmp;
	}
	public BufferedImage getImage()
	{
		return image;
	}
}
