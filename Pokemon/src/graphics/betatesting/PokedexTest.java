package graphics.betatesting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import pokedex.Pokedex;
import pokedex.PokedexData;
import utils.ImageUtils;
import exceptions.ImageInvalidSizeException;
import fonts.DialogFont;
import graphics.AlignedText;

public class PokedexTest extends JPanel implements KeyListener {
	private int xf = 12, yf = 20;
	private boolean inPokedexList = true;
	private DialogFont descriptionFont;
	private Pokedex pokedexList;
	private LinkedList<PokedexData> shownPokemon;
	private Image backgroundList, backgroundData, arrow;
	private int pokedexOffset = 0;
	private int shownPokemonIndex = 0;

	public PokedexTest() {
		pokedexList = Pokedex.getPokedex();
		try {
			this.descriptionFont = new DialogFont(ImageUtils.getWdirImage("/images/font_pokedex.png"));
		} catch (ImageInvalidSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pokedexList = new PokedexData[];

		// for(PokedexData pokedexData: pokedexList ){
		// pokedexList[z]= new PokedexData(pokedexData.getName()
		// ,pokedexData.getType1(),pokedexData.getType2(),pokedexData.getDescription());
		// z++;
		// }

		this.setFocusable(true);
		this.addKeyListener(this);
		this.backgroundList = ImageUtils.getWdirImage("/images/fondoPokedex.png");
		this.arrow = ImageUtils.getWdirImage("/images/cursorPokedex.png");
		this.shownPokemon = new LinkedList<PokedexData>();
		for (int i = 0; i < 9; i++)
			shownPokemon.add(pokedexList.getPokemon(i));
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(2, 2);// escala de la pantalla usar la misma
		g.drawImage(this.backgroundList, 0, 0, null);
		if (inPokedexList) {
			int x = 60, y = 30;
			g.drawImage(this.arrow, xf, yf, null);
			for (int i=0; i < 9; i++) {
				g.drawString(shownPokemon.get(i).getName(), x, y);
				y = y + 14;
			}
			/*
			 * g.drawString("Tipo 1: "+pokemon.getType1().toString(), 20, 120);
			 * if(pokemon.getType2() != null)
			 * g.drawString("Tipo 2: "+pokemon.getType2().toString(), 20, 140);
			 */
		} else {
			PokedexData pokemon = pokedexList.getPokemon(shownPokemonIndex+pokedexOffset);
			g.drawImage(pokemon.getImageData().getImgFront().getImage(), 140, 12, null);
			descriptionFont.drawString(g, pokemon.getName(), 15, 25);
			descriptionFont.drawString(g, pokemon.getType1().toString(), 15, 60);
			if (pokemon.getType2() != null)
				descriptionFont.drawString(g, pokemon.getType2().toString(), 60, 60);
			descriptionFont.drawString(g, pokemon.getDescription(), 10, 90);

		}

	}

	public void keyPressed(KeyEvent e) {
		if (inPokedexList) {
			if (e.getKeyCode() == KeyEvent.VK_UP) 
				moveUp();
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
				moveDown();
			else if (e.getKeyCode() == KeyEvent.VK_Z) 
				switchToPokemonData();
		} else {
			if (e.getKeyCode() == KeyEvent.VK_UP) 
				moveUp();
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
				moveDown();
			else if (e.getKeyCode() == KeyEvent.VK_X) {
				switchToPokedexList();
			}
		}
	}


	private void moveUp() {
		if (pokedexOffset > 0) {
			if(shownPokemonIndex > 0)
			{
				yf -= 14;
				shownPokemonIndex--;
			}
			else if(shownPokemonIndex == 0)
			{
				pokedexOffset--;
				shownPokemon.removeLast();
				shownPokemon.addFirst(pokedexList.getPokemon(pokedexOffset));
			}
			repaint();
		}
		else if(pokedexOffset == 0)
		{
			if(shownPokemonIndex > 0)
			{
				yf -= 14;
				shownPokemonIndex--;
				repaint();
			}
		}
	}
	private void moveDown()
	{
		if (pokedexOffset < pokedexList.size()-shownPokemonIndex-1) {
			if(shownPokemonIndex < shownPokemon.size()-1)
			{
				yf += 14;
				shownPokemonIndex++;
			}
			else if(shownPokemonIndex == shownPokemon.size()-1)
			{
				pokedexOffset++;
				shownPokemon.removeFirst();
				shownPokemon.addLast(pokedexList.getPokemon(pokedexOffset+shownPokemonIndex));
			}
			repaint();
		}
		// Arriba del todo
		else if(pokedexOffset == 0)
		{
			if(shownPokemonIndex > 0)
			{
				yf += 14;
				shownPokemonIndex++;
			}
			repaint();
		}
	}
	
	private void switchToPokemonData() {
		this.backgroundList = ImageUtils.getWdirImage("/images/DatosPokedex.png");
		inPokedexList = false;
		repaint();
	}
	private void switchToPokedexList() {
		this.backgroundList = ImageUtils.getWdirImage("/images/fondoPokedex.png");
		inPokedexList = true;
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
