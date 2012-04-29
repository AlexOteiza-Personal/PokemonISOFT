package graphics.battle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ScreenOut {
	private int x;
	private int y;
	private float alpha;

	public ScreenOut() {
		x = 0;
		y = 0;
		alpha = 0;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Composite oldComposite = g2d.getComposite();
		g2d.setColor(Color.BLACK);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SrcOver.getRule(), alpha));
		g.fillRect(0, 0, 400, 400);
		g2d.setComposite(oldComposite);
	}

	public void addAlpha(float alpha) {
		if(this.alpha+alpha>=1)
			this.alpha=1;
		else
			this.alpha += alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

}
