package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pokemon.imagedata.BattleImage;
import pokemon.imagedata.InvalidImageSizeException;


public class GamePanel extends JPanel {
	Image icon;
	BattleImage battleImage;
	public GamePanel() throws IOException, InvalidImageSizeException {
		icon = new ImageIcon(getClass().getResource("/images/icon.png")).getImage();
		battleImage = new BattleImage("/images/pokemon/front/001.png");
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method 
		g.drawImage(battleImage.getImage(), 0, 0, null);
	}
	
}