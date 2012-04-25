package graphics;

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
import fonts.BitmapFont;
import fonts.DialogFont;
import fonts.PokemonListFont;

public class PokedexFrame extends Room {
	private int xf = 12, yf = 20;
	private boolean inDescription = false;
	private PokemonListFont pokedexFontSmall;
	private DialogFont pokedexFont;
	private DialogFont descriptionFont;
	private Pokedex pokedexList;
	private LinkedList<PokedexData> shownPokemon;
	private Image backgroundList, backgroundData, arrow;
	private int pokedexOffset = 0;
	private int shownPokemonIndex = 0;

	public PokedexFrame() {
		pokedexList = Pokedex.getPokedex();
		this.pokedexFont = new DialogFont(ImageUtils.getWdirImage("/images/font_pokedex.png"));
		this.pokedexFontSmall = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokedex_small.png"),BitmapFont.RIGHT_ALIGN);
		this.descriptionFont = new DialogFont(ImageUtils.getWdirImage("/images/font_pokedex_description.png"));
		// pokedexList = new PokedexData[];

		// for(PokedexData pokedexData: pokedexList ){
		// pokedexList[z]= new PokedexData(pokedexData.getName()
		// ,pokedexData.getType1(),pokedexData.getType2(),pokedexData.getDescription());
		// z++;
		// }

		this.setFocusable(true);
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
		if (!inDescription) {
			int x = 67, y = 22;
			g.drawImage(this.arrow, xf, yf, null);
			for (int i=0; i < 9; i++) {
				PokedexData pokemon = shownPokemon.get(i);
				pokedexFontSmall.drawString(g,"N."+ pokemon.getStringId(), x-15, y);
				if(pokemon.isSeen())
					pokedexFont.drawString(g, pokemon.getName(), x+5, y-4);
				else
					pokedexFont.drawString(g, "(?)", x+5, y-4);
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
			pokedexFont.drawString(g, pokemon.getName(), 15, 25);
			pokedexFont.drawString(g, pokemon.getType1().toString(), 15, 60);
			if (pokemon.getType2() != null)
				pokedexFont.drawString(g, pokemon.getType2().toString(), 60, 60);
			descriptionFont.drawString(g, pokemon.getDescription(), 10, 90);

		}

	}

	
	public void keyPressedAction(KeyEvent e) {
		
		//////////////////////////////////////////////
		/*
		 * Test keys
		 */
		int keyCode = e.getKeyCode();
		if(keyCode == 'A')
		{
			this.pokedexList.testSetAll(true);
			this.repaint();
		}
		else if(keyCode == 'S')
		{
			this.pokedexList.testSetAll(false);
			this.repaint();
		}
		else if(keyCode > '0' && keyCode <= '9')
		{
			PokedexData pk = this.pokedexList.getPokemon(keyCode-'1');
			pk.setSeen(!pk.isSeen());
			repaint();
		}
		///////////////////////////////////////////////
		
		
		if (!inDescription) {
			if (keyCode == KeyEvent.VK_UP) 
				moveUp();
			else if (keyCode == KeyEvent.VK_DOWN) 
				moveDown();
			else if (keyCode == KeyEvent.VK_Z) 
				switchToPokemonData();
			else if (keyCode == KeyEvent.VK_X)
				GameFrame.getGameFrame().goBack();
		} else {
			// FIXME: 
			// Modificiar moveUp y moveDown en caso de estar en la descripcion
			// para que no muestren pokemon no vistos
			if (keyCode == KeyEvent.VK_UP) 
				moveUp();
			else if (keyCode == KeyEvent.VK_DOWN) 
				moveDown();
			else if (keyCode == KeyEvent.VK_X) {
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
		if(pokedexList.getPokemon(shownPokemonIndex+pokedexOffset).isSeen())
		{
			this.backgroundList = ImageUtils.getWdirImage("/images/DatosPokedex.png");
			inDescription = true;
			repaint();
		}
	}
	private void switchToPokedexList() {
		this.backgroundList = ImageUtils.getWdirImage("/images/fondoPokedex.png");
		inDescription = false;
		repaint();
	}

	@Override
	protected void keyReleasedAction(KeyEvent e) {}

}
