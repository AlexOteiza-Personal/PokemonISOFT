package graphics;

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
import pokemon.imagedata.ImageInvalidSizeException;

public class GameFrame extends JFrame{
	BufferedImage icon;
	public GameFrame() throws IOException, ImageInvalidSizeException{
	    
		try {
			icon = ImageIO.read(getClass().getResource("/images/icon.png"));
			setIconImage(icon);
		} catch (IOException e) {
			System.err.println("Error al abrir archivo de icono");
		}
		add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		setVisible(true);
	}
	
}
