package graphics.battle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import utils.ImageUtils;

public abstract class Actor {
	private int x;
	private int y;
	private BufferedImage[] images;
	private BufferedImage shadow;
	private int imgIndex;
	private int width;
	private int height;
	private int tmpWidth;
	private int tmpHeight;
	private Color shadowColor;
	private boolean shadowed;
	private float shadowAlpha;
	private boolean visible = false;

	public Actor(int x, int y, BufferedImage image) {
		this(x, y, new BufferedImage[] { image });
	}

	public Actor(int x, int y, BufferedImage[] images) {
		this.x = x;
		this.y = y;
		this.images = images;
		this.width = images[0].getWidth();
		this.height = images[0].getHeight();
		this.tmpWidth = width;
		this.tmpHeight = height;
		this.imgIndex = 0;
		this.shadowColor = Color.BLACK;
		this.shadow = ImageUtils.getShadow(images[imgIndex], shadowColor);
		this.shadowAlpha = 0f;
	}

	public void addX(int x) {
		this.x += x;
	}

	public void addY(int y) {
		this.y += y;
	}

	public void paint(Graphics g) {
		if (visible) {
			g.drawImage(images[imgIndex], x, y, tmpWidth, tmpHeight, null);
			if (shadowed) {
				g.setColor(shadowColor);
				((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SrcOver.getRule(),
						shadowAlpha));
				g.drawImage(shadow, x, y, tmpWidth, tmpHeight, null);
				((Graphics2D) g)
						.setComposite(AlphaComposite.getInstance(AlphaComposite.SrcOver.getRule(), 1));
			}
		}
	}

	public void setScaleCenterDown(double xScale, double yScale) {
		x+= (int) ((tmpWidth-(images[0].getWidth() * xScale))/2);
		y+= (int) ((tmpHeight-(images[0].getWidth() * xScale)));
		
		tmpWidth = (int) (images[0].getWidth() * xScale);
		tmpHeight = (int) (images[0].getHeight() * yScale);
	}

	public void addSize(int addWidth, int addHeight){
		this.tmpWidth += addWidth;
		this.tmpHeight+= addHeight;
		//x -= addWidth;
		y -= addHeight;
		
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getTmpWidth() {
		return tmpWidth;
	}

	public int getTmpHeight() {
		return tmpHeight;
	}

	public void nextFrame() {
		if (imgIndex < images.length - 1)
			imgIndex++;
		else
			imgIndex = 0;
		// shadow = ImageUtils.getShadow(images[imgIndex]);
	}

	public void setShadowed(boolean shadowed) {
		this.shadowed = shadowed;
	}

	public void setShadowColor(Color shadowColor) {
		this.shadowColor = shadowColor;
		this.shadow = ImageUtils.getShadow(images[imgIndex], shadowColor);
	}

	public void setShadowAlpha(float alpha) {
		if (alpha > 0)
			this.shadowAlpha = alpha;
	}

	public void addShadowAlpha(float alpha) {
		if (this.shadowAlpha + alpha >= 0)
			this.shadowAlpha += alpha;
		else
			this.shadowAlpha = 0;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}

}
