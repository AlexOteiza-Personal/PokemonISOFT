package graphics.battle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class ScreenIntro {
	private int x;
	private int y;
	private int width;
	private int height;
	private int diff;
	private int alpha;
	public ScreenIntro() {
		x = 0;
		y = 0;
		width = 400;
		height = 81;
		diff = 0;
		alpha = 1;
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height-diff);
		g.fillRect(x, height+diff, width, height);
	}
	public void addDiff(int diff){
		this.diff+=diff;
	}
	
}
