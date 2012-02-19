package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pokemon.Pokemon;
import pokemon.PokemonStats;
import pokemon.imagedata.BattleImage;
import pokemon.imagedata.ImageInvalidSizeException;


public class PokemonStatusPanel extends JPanel{
	private static Point pokemonOrigin = new Point(10, 0);
	Pokemon pokemon;
	public PokemonStatusPanel(Pokemon pokemon) throws IOException, ImageInvalidSizeException {
		this.pokemon = pokemon;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method 
		g.drawImage (pokemon.getImageData().getImgFront().getImage(),pokemonOrigin.x,pokemonOrigin.y, null);
		g.drawString(pokemon.getName(), 20, 100);
		g.drawString("Tipo 1: "+pokemon.getType1().toString(), 20, 120);
		g.drawString("Tipo 2: "+pokemon.getType2().toString(), 20, 140);
		PokemonStats stats = pokemon.getStats();
		g.drawString("Ataque: "+stats.getAttack(), 120, 100);
		g.drawString("Defensa: "+stats.getDefense(), 120, 120);
		g.drawString("Velocidad: "+stats.getSpeed(), 120, 140);
	}
	
}