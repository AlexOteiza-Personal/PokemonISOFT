package graphics.betatesting;

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


public class PokemonStatusTest extends JPanel implements KeyListener{
	private static Point pokemonOrigin = new Point(10, 0);
	private Pokemon[] pokemonList;
	private int pokemonIndex = 0;
	public PokemonStatusTest() throws IOException, ImageInvalidSizeException {
		pokemonList = new Pokemon[PokemonData.values().length];
		int i=0;
		for(PokemonData pkdata: PokemonData.values())
		{
			pokemonList[i] = new Pokemon(pkdata,1);
			i++;
		}
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
		g.drawString("Nivel: "+ pokemon.getLevel(), 120, 60);

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
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			pokemonList[pokemonIndex].levelUp();
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			pokemonList[pokemonIndex].levelDown();
			repaint();
		}
	}
	@Override
	public void keyReleased(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e) {}
	
}