package graphics.battle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ScreenFlash {
	private float alpha;
	public ScreenFlash() {
		this.alpha = 0;
	}
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		Composite oldComposite = g2d.getComposite();
		System.out.println(alpha);
		g2d.setColor(Color.black);
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
	public void setAlpha(float alpha){
		this.alpha = alpha;
	}
}
