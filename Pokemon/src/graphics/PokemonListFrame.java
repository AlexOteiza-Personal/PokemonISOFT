package graphics;

import utils.ImageUtils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import exceptions.ImageInvalidSizeException;
import exceptions.UnsupportedCharException;
import fonts.BitmapFont;
import fonts.DialogFont;
import fonts.PokemonListFont;

import player.PlayerPokemonList;
import pokemon.Pokemon;

public class PokemonListFrame extends JPanel implements KeyListener{
	private BitmapFont pokemonNameFont;
	private int pokemonIndex;
	private int pokemonListSize;
	private boolean selected;
	private int boxSelectIndex;
	private final static int FSTARTX = 154;
	private final static int FSTARTY = 108;
	private final static int SELECT_SHOWDATA = 0;
	private final static int SELECT_SWITCH = 1;
	private final static int SELECT_EXIT = 2;
	private int fx,fy;
	private PlayerPokemonList playerPokemonList;
	private BufferedImage background;
	private BufferedImage firstPokemonBox;
	private BufferedImage firstPokemonSelect;
	private BufferedImage pokemonBox;
	private BufferedImage pokemonBoxFill;
	private BufferedImage pokemonBoxSelect;
	private BufferedImage pokemonBoxFillSelect;
	private BufferedImage textBox;
	private BufferedImage arrow;

	public PokemonListFrame() {
		this.pokemonIndex = 0;
		this.selected = false;
		this.boxSelectIndex = 0;
		this.playerPokemonList = PlayerPokemonList.getPlayerpokemonlist();
		this.fx = FSTARTX;
		this.fy = FSTARTY;
		
		pokemonListSize = playerPokemonList.size();
		
		this.background = ImageUtils.getWdirImage("/images/pokemonlist/background.png");
		this.firstPokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/boxBig.png");
		this.firstPokemonSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxBigSelect.png");
		this.pokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/box.png");
		this.pokemonBoxSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxSelect.png");
		this.pokemonBoxFill = ImageUtils.getWdirImage("/images/pokemonlist/boxfill.png");
		this.pokemonBoxFillSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxfillSelect.png");
		this.textBox = ImageUtils.getWdirImage("/images/pokemonlist/textBox.png");
		this.arrow = ImageUtils.getWdirImage("/images/pokemonlist/arrow.png");	
		this.pokemonNameFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokemonlist.png"));
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(2, 2);
		g.drawImage(background, 0, 0, null);
		
		if(playerPokemonList.getPokemon(0) != null)
		{
			int x = 8, y = 26;
			g.drawImage(pokemonBox, 96, 10, null);
			Pokemon pokemon = playerPokemonList.getPokemon(0);
			if(pokemonIndex == 0)
				g.drawImage(firstPokemonSelect, x, y, null);
			else
				g.drawImage(firstPokemonBox, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), 30, 38);
		}
		
		if (playerPokemonList.getPokemon(1) != null) {
			int x = 96, y = 10;
			Pokemon pokemon = playerPokemonList.getPokemon(1);
			if(pokemonIndex == 1)
			{
				g.drawImage(pokemonBoxSelect, x, y, null);
				g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
			}
			else
			{
				g.drawImage(pokemonBox, x, y, null);
				g.drawImage(pokemonBoxFill, x+1, y+1, null);
			}
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		else g.drawImage(pokemonBox, 96, 10, null);
		
		if(playerPokemonList.getPokemon(2) != null)
		{
			int x = 96, y = 34;
			Pokemon pokemon = playerPokemonList.getPokemon(2);
			if(pokemonIndex == 2)
			{
				g.drawImage(pokemonBoxSelect, x, y, null);
				g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
			}
			else
			{
				g.drawImage(pokemonBox, x, y, null);
				g.drawImage(pokemonBoxFill, x+1, y+1, null);
			}
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		else g.drawImage(pokemonBox, 96, 34, null);
		
		if(playerPokemonList.getPokemon(3) != null)
		{
			int x = 96, y = 58;
			Pokemon pokemon = playerPokemonList.getPokemon(3);
			if(pokemonIndex == 3)
			{
				g.drawImage(pokemonBoxSelect, x, y, null);
				g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
			}
			else
			{
				g.drawImage(pokemonBox, x, y, null);
				g.drawImage(pokemonBoxFill, x+1, y+1, null);
			}
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		else g.drawImage(pokemonBox, 96, 58, null);
		
		if(playerPokemonList.getPokemon(4) != null)
		{
			int x = 96, y = 82;
			Pokemon pokemon = playerPokemonList.getPokemon(4);
			if(pokemonIndex == 4)
			{
				g.drawImage(pokemonBoxSelect, x, y, null);
				g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
			}
			else
			{
				g.drawImage(pokemonBox, x, y, null);
				g.drawImage(pokemonBoxFill, x+1, y+1, null);
			}
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		else g.drawImage(pokemonBox, 96, 82, null);
		
		if(playerPokemonList.getPokemon(5) != null)
		{
			int x = 96, y = 106;
			Pokemon pokemon = playerPokemonList.getPokemon(5);
			if(pokemonIndex == 5)
			{
				g.drawImage(pokemonBoxSelect, x, y, null);
				g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
			}
			else
			{
				g.drawImage(pokemonBox, x, y, null);
				g.drawImage(pokemonBoxFill, x+1, y+1, null);
			}
			pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
		}
		else g.drawImage(pokemonBox, 96, 106, null);
		
		if(selected)
		{
			g.drawImage(textBox, 146, 97, null);
			g.drawImage(arrow, fx, fy, null);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP)
		{
			if(selected)
			{
				if(boxSelectIndex <= 0)
				{
					fy = 140;
					boxSelectIndex = 2;
					repaint();
				}
				else
				{
					fy -= 16;
					boxSelectIndex --;
					repaint();
				}
			}
			else
			{
				if(pokemonIndex <= 0)
				{
					pokemonIndex = pokemonListSize-1;
					repaint();
				}
				else
				{
					pokemonIndex--;
					repaint();
				}
			}
		}
		else if(keyCode == KeyEvent.VK_DOWN)
		{
			if(selected)
			{
				if(boxSelectIndex >= 2)
				{
					fy = FSTARTY;
					boxSelectIndex = 0;
					repaint();
				}
				else
				{
					fy += 16;
					boxSelectIndex ++;
					repaint();
				}
			}
			else
			{
				if(pokemonIndex >= pokemonListSize-1)
				{
					pokemonIndex = 0;
					repaint();
				}
				else
				{
					pokemonIndex++;
					repaint();
				}
			}
		}
		else if(keyCode == 'Z')
		{
			if(selected)
			{
				if(boxSelectIndex == SELECT_SHOWDATA)
				{
					//TODO
				}
				if(boxSelectIndex == SELECT_SWITCH)
				{
					
				}
				if(boxSelectIndex == SELECT_EXIT)
				{
					selected = false;
					fy = FSTARTY;
					boxSelectIndex = 0;
					repaint();
				}
			}
			else
			{
				selected = true;
				fy = FSTARTY;
				boxSelectIndex = 0;
				repaint();
			}
		}
		else if(keyCode == 'X')
		{
			if(selected)
			{
				selected = false;
				fy = FSTARTY;
				boxSelectIndex = 0;
				repaint();
			}
		}
		System.out.println("Pokemon Index: "+pokemonIndex+"\nBox Index: "+boxSelectIndex);
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}