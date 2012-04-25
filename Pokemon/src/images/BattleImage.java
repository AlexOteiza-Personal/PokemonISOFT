package images;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.swing.*;
import utils.ImageUtils;
public class BattleImage{
	int width = 80;
	int height = 80;
	BufferedImage image;
	public BattleImage(String filename) throws IOException{
		BufferedImage tmp = ImageUtils.getWdirImage(filename);
		int tWidth = tmp.getWidth(null);
		int tHeight = tmp.getHeight(null);
		image = tmp;
	}
	public BufferedImage getImage()
	{
		return image;
	}
}
