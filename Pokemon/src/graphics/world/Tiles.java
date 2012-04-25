package graphics.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import javax.imageio.ImageIO;

import utils.ImageUtils;

public class Tiles {
	public static final int TILE_SIZE = 16;
	public static final int SPACING = 1;
	private static final Tiles instance = new Tiles();
	public static int NONE   = 0;
	
	public static final int GRASS_1 = 10;
	public static final int GRASS_2 = 11;
	public static final int GRASS_3 = 12;
	public static final int GRASS_4 = 13;
	public static final int GRASS_5 = 14;
	public static final int GRASS_6 = 15;
	public static final int GRASS_7 = 16;
	public static final int GRASS_8 = 17;
	public static final int GRASS_9 = 18;
	public static final int GRASS_10 = 19;
	public static final int GRASS_11 = 20;
	public static final int GRASS_12 = 21;
	
	public static final int STONE_1 = 30;
	
	public static final int TREE1_REPEAT_LEFT_UP = 200;
	public static final int TREE1_REPEAT_RIGHT_UP = 201;
	public static final int TREE1_REPEAT_LEFT_DOWN = 202;
	public static final int TREE1_REPEAT_RIGHT_DOWN = 203;

	public static final int TREE1_END_LEFT_UP = 204;
	public static final int TREE1_END_RIGHT_UP = 205;
	public static final int TREE1_END_LEFT_DOWN = 206;
	public static final int TREE1_END_RIGHT_DOWN = 207;
	
	
	private static Map<Integer,BufferedImage> imageData;
	
	private Tiles() {
		imageData = new HashMap<Integer, BufferedImage>();
		TileSet grass = new TileSet("/images/Tiles/GrassSet.png");
		TileSet tree1 = new TileSet("/images/Tiles/Tree1.png");
		imageData.put(GRASS_1, grass.getTile(0));
		imageData.put(GRASS_2, grass.getTile(1));
		imageData.put(GRASS_3, grass.getTile(2));
		imageData.put(GRASS_4, grass.getTile(3));
		imageData.put(GRASS_5, grass.getTile(4));
		imageData.put(GRASS_6, grass.getTile(5));
		imageData.put(GRASS_7, grass.getTile(6));
		imageData.put(GRASS_8, grass.getTile(7));
		imageData.put(GRASS_9, grass.getTile(8));
		imageData.put(GRASS_10, grass.getTile(9));
		imageData.put(GRASS_11, grass.getTile(10));
		imageData.put(GRASS_12, grass.getTile(11));
		
		imageData.put(TREE1_REPEAT_LEFT_UP, tree1.getTile(0));
		imageData.put(TREE1_REPEAT_RIGHT_UP, tree1.getTile(1));
		imageData.put(TREE1_REPEAT_LEFT_DOWN, tree1.getTile(4));
		imageData.put(TREE1_REPEAT_RIGHT_DOWN, tree1.getTile(5));
		
		imageData.put(TREE1_END_LEFT_UP, tree1.getTile(2));
		imageData.put(TREE1_END_RIGHT_UP, tree1.getTile(3));
		imageData.put(TREE1_END_LEFT_DOWN, tree1.getTile(6));
		imageData.put(TREE1_END_RIGHT_DOWN, tree1.getTile(7));
		
	}
	public static BufferedImage getTile(int tileno)
	{
		return imageData.get(tileno);
	}
}
