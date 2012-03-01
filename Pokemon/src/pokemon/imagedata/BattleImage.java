package pokemon.imagedata;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import exceptions.ImageInvalidSizeException;

import sun.swing.*;
import utils.ImageUtils;
public class BattleImage{
	int width = 80;
	int height = 80;
	BufferedImage image;
	public BattleImage(String filename) throws IOException, ImageInvalidSizeException{
		BufferedImage tmp = ImageUtils.getWdirImage(filename);
		int tWidth = tmp.getWidth(null);
		int tHeight = tmp.getHeight(null);
		if(tWidth != width || tHeight != height)
			throw new ImageInvalidSizeException(tWidth,tHeight);
		else
			image = tmp;
	}
	public BufferedImage getImage()
	{
		return image;
	}
}
