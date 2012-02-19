package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pokemon.Pokemon;
import pokemon.imagedata.BattleImage;
import pokemon.imagedata.ImageInvalidSizeException;


public class PokemonStatusPanel extends JPanel {
	private static Point pokemonOrigin = new Point(0, 0);
	Pokemon pokemon;
	public PokemonStatusPanel(Pokemon pokemon) throws IOException, ImageInvalidSizeException {
		this.pokemon = pokemon;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method 
		g.drawImage (pokemon.getImageData().getImgFront().getImage(),pokemonOrigin.x,pokemonOrigin.y, null);
		g.drawString(pokemon.getType1().toString(), 50, 120);
	}

	
	
}