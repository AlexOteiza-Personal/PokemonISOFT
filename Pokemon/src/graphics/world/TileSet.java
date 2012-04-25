package graphics.world;

import java.awt.image.BufferedImage;

import utils.ImageUtils;

// Group of tiles
public class TileSet {
	private BufferedImage[] images;

	public TileSet(String dir) {
		BufferedImage img = ImageUtils.getWdirImage(dir);
		int hImgnum = img.getWidth() / Tiles.TILE_SIZE;
		int vImgnum = img.getHeight() / Tiles.TILE_SIZE;
		images = new BufferedImage[hImgnum * vImgnum];
		System.out.println("hImgnum="+hImgnum+"vImgnum"+vImgnum);
		
		for (int i = 0, imgno = 0; i < vImgnum; i++) {
			for (int j = 0; j < hImgnum; j++, imgno++) {
				images[imgno] = img.getSubimage(j * 16, i * 16, Tiles.TILE_SIZE, Tiles.TILE_SIZE);
			}
		}
	}

	public BufferedImage getTile(int index) {
		System.out.println(images[index]);
		return images[index];
	}
}
