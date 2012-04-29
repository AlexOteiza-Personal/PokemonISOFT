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

import fonts.BitmapFont;
import fonts.DialogFont;
import fonts.PokemonListFont;

import player.PlayerPokemonList;
import pokemon.Pokemon;

public class PokemonListFrame extends Room{
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
	private boolean inSwitchMode;
	private int switchIndex;
	private BufferedImage pokemonBoxFillSwitch;
	private BufferedImage pokemonBoxSwitch;
	private BufferedImage firstPokemonSwitch;
	private BufferedImage firstPokemonSwitchSelect;
	private static int menuIndex = 2;

	public PokemonListFrame()
	{
		this(0);
	}
	
	public PokemonListFrame(int index) {
		this.pokemonIndex = index;
		this.selected = false;
		this.inSwitchMode = false;
		this.boxSelectIndex = 0;
		this.playerPokemonList = PlayerPokemonList.getPlayerpokemonlist();
		this.fx = FSTARTX;
		this.fy = FSTARTY;
		
		pokemonListSize = playerPokemonList.size();
		
		this.background = ImageUtils.getWdirImage("/images/pokemonlist/background.png");
		this.firstPokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/boxBig.png");
		this.firstPokemonSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxBigSelect.png");
		this.firstPokemonSwitch = ImageUtils.getWdirImage("/images/pokemonlist/boxBigSwith.png");
		this.firstPokemonSwitchSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxBigSwitchSelect.png");
		this.pokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/box.png");
		this.pokemonBoxSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxSelect.png");
		this.pokemonBoxSwitch = ImageUtils.getWdirImage("/images/pokemonlist/boxSwitch.png");
		this.pokemonBoxFill = ImageUtils.getWdirImage("/images/pokemonlist/boxfill.png");
		this.pokemonBoxFillSelect = ImageUtils.getWdirImage("/images/pokemonlist/boxfillSelect.png");
		this.pokemonBoxFillSwitch = ImageUtils.getWdirImage("/images/pokemonlist/boxfillSwitch.png");
		this.textBox = ImageUtils.getWdirImage("/images/pokemonlist/textBox.png");
		this.arrow = ImageUtils.getWdirImage("/images/pokemonlist/arrow.png");	
		this.pokemonNameFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokemonlist.png"));
		this.switchIndex = 0;
	}

	public void paintRoom(Graphics g) {
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
			{
				if(inSwitchMode)
					g.drawImage(firstPokemonSwitchSelect, x, y, null);
				else
					g.drawImage(firstPokemonSelect, x, y, null);
					
			}
			else if(inSwitchMode && switchIndex == 0)
			{
				g.drawImage(firstPokemonSwitch, x, y, null);
			}
			else
				g.drawImage(firstPokemonBox, x, y, null);
			pokemonNameFont.drawString(g, pokemon.getName(), 30, 38);
		}
		
		int x = 96, y = 10;
		for(int i=1;i<6;i++)
		{
			if (playerPokemonList.getPokemon(i) != null) {
				Pokemon pokemon = playerPokemonList.getPokemon(i);
				if(i == pokemonIndex)
				{
					g.drawImage(pokemonBoxSelect, x, y, null);
					if(inSwitchMode)
						g.drawImage(pokemonBoxFillSwitch, x+2, y+2, null);
					else
						g.drawImage(pokemonBoxFillSelect, x+2, y+2, null);
				}
				else if(inSwitchMode && i == switchIndex)
				{
					g.drawImage(pokemonBoxSwitch, x, y, null);
					g.drawImage(pokemonBoxFillSwitch, x+2, y+2, null);
				}
				else
				{
					g.drawImage(pokemonBox, x, y, null);
					g.drawImage(pokemonBoxFill, x+1, y+1, null);
				}
					pokemonNameFont.drawString(g, pokemon.getName(), x + 22, y + 5);
			}
			else g.drawImage(pokemonBox, 96, 10, null);
			y+=24;
		}
		
		if(selected)
		{
			g.drawImage(textBox, 146, 97, null);
			g.drawImage(arrow, fx, fy, null);
		}
		
	}

	public void keyPressedAction(KeyEvent e) {
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
					GameFrame gf = (GameFrame)getTopLevelAncestor();
					gf.gotoPokemonStatus(playerPokemonList.getPokemon(pokemonIndex),pokemonIndex);
				}
				if(boxSelectIndex == SELECT_SWITCH)
				{
					inSwitchMode = true;
					selected = false;
					switchIndex = pokemonIndex;
					repaint();
				}
				if(boxSelectIndex == SELECT_EXIT)
				{
					selected = false;
					fy = FSTARTY;
					boxSelectIndex = 0;
					repaint();
				}
			}
			else if(inSwitchMode)
			{
				if(pokemonIndex != switchIndex)
				{
					playerPokemonList.switchPokemon(pokemonIndex,switchIndex);
				}
				inSwitchMode = false;
				repaint();
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
			else if(inSwitchMode)
			{
				inSwitchMode = false;
				repaint();
			}
			else
			{
				GameFrame.getGameFrame().goBack();
			}
		}
		System.out.println("Pokemon Index: "+pokemonIndex+"\nBox Index: "+boxSelectIndex);
	}

	public int getMenuIndex() {
		return menuIndex;
	}


	@Override
	protected void keyReleasedAction(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}