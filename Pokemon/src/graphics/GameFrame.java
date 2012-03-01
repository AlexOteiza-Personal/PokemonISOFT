package graphics;

import exceptions.ImageInvalidSizeException;
import graphics.betatesting.PokemonStatusTest;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import player.PlayerPokemonList;
import pokemon.Pokemon;
import pokemon.PokemonData;

public class GameFrame extends JFrame{
	BufferedImage icon;
	public GameFrame() throws IOException, ImageInvalidSizeException{
	    
		add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		//add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setVisible(true);
	}
	
}
