package graphics.battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.ImageUtils;

public class PlayerActor extends Actor{

	public PlayerActor() {
		super(240,50,ImageUtils.getSubImages(ImageUtils.getWdirImage("/images/player_male_animation.png"), 64, 64, 4));
	}
}
