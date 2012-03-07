package graphics;

import utils.ImageUtils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import exceptions.ImageInvalidSizeException;
import exceptions.UnsupportedCharException;
import fonts.BitmapFont;
import fonts.DialogFont;
import fonts.PokemonListFont;

import player.PlayerPokemonList;
import pokemon.Pokemon;

public class PokemonListFrame extends JPanel {
	private BitmapFont pokemonNameFont;
	private PlayerPokemonList playerPokemonList;
	private BufferedImage background;
	private BufferedImage firstPokemonBox;
	private BufferedImage pokemonBox;
	private BufferedImage pokemonBoxFill;
	private int pokemonIndex;

	public PokemonListFrame() {
		this.pokemonIndex = 0;
		this.playerPokemonList = PlayerPokemonList.getPlayerpokemonlist();
		this.background = ImageUtils.getWdirImage("/images/pokemonlist/background.png");
		this.firstPokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/boxBig.png");
		this.pokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/box.png");
		this.pokemonBoxFill = ImageUtils.getWdirImage("/images/pokemonlist/boxfill.png");
		this.pokemonNameFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokemonlist.png"));
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(2, 2);
		g.drawImage(background, 0, 0, null);
		g.drawImage(firstPokemonBox, 8, 26, null);
		pokemonNameFont.drawString(g, playerPokemonList.getPokemon(0).getName(), 30, 38);
		g.drawImage(pokemonBox, 96, 10, null);
		if (playerPokemonList.getPokemon(1) != null) {
			int x = 97, y = 11;
			Pokemon pokemon = playerPokemonList.getPokemon(1);
			g.drawImage(pokemonBoxFill, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		g.drawImage(pokemonBox, 96, 34, null);
		if (playerPokemonList.getPokemon(2) != null) {
			int x = 97, y = 35;
			Pokemon pokemon = playerPokemonList.getPokemon(2);
			g.drawImage(pokemonBoxFill, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		g.drawImage(pokemonBox, 96, 58, null);
		if (playerPokemonList.getPokemon(3) != null) {
			int x = 97, y = 59;
			Pokemon pokemon = playerPokemonList.getPokemon(3);
			g.drawImage(pokemonBoxFill, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		g.drawImage(pokemonBox, 96, 82, null);
		if (playerPokemonList.getPokemon(4) != null) {
			int x = 97, y = 83;
			Pokemon pokemon = playerPokemonList.getPokemon(4);
			g.drawImage(pokemonBoxFill, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		g.drawImage(pokemonBox, 96, 106, null);
		if (playerPokemonList.getPokemon(5) != null) {
			int x = 97, y = 107;
			Pokemon pokemon = playerPokemonList.getPokemon(5);
			g.drawImage(pokemonBoxFill, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}

	}

}