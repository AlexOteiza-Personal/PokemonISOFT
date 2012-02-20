package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;

import pokemon.Pokemon;
import pokemon.PokemonData;
import pokemon.PokemonStats;
import pokemon.imagedata.BattleImage;
import pokemon.imagedata.ImageInvalidSizeException;


public class PokemonStatusPanel extends JPanel implements KeyListener{
	private static Point pokemonOrigin = new Point(10, 0);
	private Pokemon[] pokemonList = 
		{
			new Pokemon(PokemonData.Bulbasaur, 1),
			new Pokemon(PokemonData.Abra, 1),
			new Pokemon(PokemonData.Arcanine, 1)
		};
	private int pokemonIndex = 0;
	public PokemonStatusPanel(Pokemon pokemon) throws IOException, ImageInvalidSizeException {
		this.pokemonList[0] = pokemon;
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method 
		super.paintComponent(g);
		Pokemon pokemon = pokemonList[pokemonIndex];
		g.drawImage (pokemon.getImageData().getImgFront().getImage(),pokemonOrigin.x,pokemonOrigin.y, null);
		g.drawString(pokemon.getName(), 20, 100);
		g.drawString("Tipo 1: "+pokemon.getType1().toString(), 20, 120);
		if(pokemon.getType2() != null)
			g.drawString("Tipo 2: "+pokemon.getType2().toString(), 20, 140);
		PokemonStats stats = pokemon.getStats();
		g.drawString("Ataque: "+stats.getAttack(), 120, 100);
		g.drawString("Defensa: "+stats.getDefense(), 120, 120);
		g.drawString("Velocidad: "+stats.getSpeed(), 120, 140);

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(pokemonIndex < pokemonList.length-1)
			{
				pokemonIndex++;
				repaint();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(pokemonIndex > 0)
			{
				pokemonIndex--;
				repaint();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e) {}
	
}