package graphics.betatesting;


import fonts.BitmapFont;
import fonts.DialogFont;
import graphics.AlignedText;
import graphics.GameFrame;
import graphics.Room;

import images.BattleImage;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.StyledEditorKit.FontSizeAction;

import pokemon.Pokemon;
import pokemon.PokemonData;
import pokemon.PokemonStats;
import utils.ImageUtils;


public class PokemonStatusTest extends Room{
    	private BitmapFont statusFont;
	private static Point pokemonOrigin = new Point(20, 4);
	private Image stats;
	private int pokemonIndex = 0;
	private Pokemon pokemon;
	private int index;
	private AlignedText statsText = new AlignedText(AlignedText.RIGHT_ALIGN);
	public PokemonStatusTest(Pokemon pokemon,int index){
		super();
		this.index = index;
		this.pokemon = pokemon;
		this.setFocusable(true);
		this.stats = ImageUtils.getWdirImage("/images/status_1x.PNG");
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method 
		super.paintComponent(g);
		((Graphics2D)g).scale(2, 2);
		g.drawImage(this.stats, 0, 0, null);
		g.drawImage (pokemon.getImageData().getImgFront().getImage(),20,4, null);
		g.drawString(pokemon.getName(), 5, 10);
		//g.drawString("Tipo 1: "+pokemon.getType1().toString(), 20, 120);
		//if(pokemon.getType2() != null)
		//	g.drawString("Tipo 2: "+pokemon.getType2().toString(), 20, 140);
		PokemonStats stats = pokemon.getStats();
		statsText.drawString(stats.getAttack(),230, 33, g);
		statsText.drawString(stats.getDefense(), 230, 46, g);
		// Special Attack TODO
		g.drawString("-", 230-5, 59);
		// Special Defence TODO
		g.drawString("-", 230-5, 72);
		statsText.drawString(stats.getSpeed(), 230, 85, g);
		statsText.drawString(pokemon.getLevel(), 220, 478,g);
		statsText.drawString(stats.getHp(), 210, 15,g);
		g.drawString("Nivel: "+pokemon.getLevel(), 175, 99);
		
	}

	public void keyPressedAction(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == 'X')
		{
			GameFrame gf = (GameFrame)getTopLevelAncestor();
			gf.goBack();
		}
	}
	public int getIndex()
	{
		return index;
	}
	@Override
	protected void keyReleasedAction(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}