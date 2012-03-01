package graphics.betatesting;

import graphics.AlignedText;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pokedex.Pokedex;
import pokedex.PokedexData;
import pokemon.Pokemon;
import pokemon.PokemonData;
import pokemon.PokemonStats;
import exceptions.ImageInvalidSizeException;
import utils.ImageUtils;

public class PokedexTest extends JPanel implements KeyListener {
    private int xf = 12, yf = 20, id = 1, mirror = 1;
    private Pokedex pokedexList;
    private Image stats, arrow;
    private int pokemonIndex = 0;
    private AlignedText statsText = new AlignedText(AlignedText.RIGHT_ALIGN);

    public PokedexTest(){
	pokedexList = Pokedex.getPokedex();
	int i = 0, z = 0;
	// pokedexList = new PokedexData[];

	// for(PokedexData pokedexData: pokedexList ){
	// pokedexList[z]= new PokedexData(pokedexData.getName()
	// ,pokedexData.getType1(),pokedexData.getType2(),pokedexData.getDescription());
	// z++;
	// }

	this.setFocusable(true);
	this.addKeyListener(this);
	this.stats = ImageUtils.getWdirImage("/images/fondoPokedex.png");
	this.arrow = ImageUtils.getWdirImage("/images/cursorPokedex.png");

    }

    @Override
    public void paintComponent(Graphics g) {
	// TODO Auto-generated method
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	g2.scale(2, 2);// escala de la pantalla usar la misma
	g.drawImage(this.stats, 0, 0, null);
	if (mirror == 1) {
	    int x = 60, y = 30;
	    g.drawImage(this.arrow, xf, yf, null);
	    // g.drawImage(pokemon.getImageData().getImgFront().getImage(),20,4,null);
	    for (int i = 0; i <= 8; i++) {
		g.drawString(pokedexList.getPokemon(i).getName(), x, y);
		y = y + 14;
	    }
	    /*
	     * g.drawString("Tipo 1: "+pokemon.getType1().toString(), 20, 120);
	     * if(pokemon.getType2() != null)
	     * g.drawString("Tipo 2: "+pokemon.getType2().toString(), 20, 140);
	     */
	} else {
	    PokedexData pokemon = pokedexList.getPokemon(id);

	    g.drawImage(pokemon.getImageData().getImgFront().getImage(), 140,
		    12, null);
	    g.drawString(pokemon.getName(), 15, 40);
	    g.drawString(pokemon.getType1().toString(), 15, 60);
	    if (pokemon.getType2() != null)
		g.drawString(pokemon.getType2().toString(), 60, 60);
	    g.drawString(pokemon.getDescription(), 15, 100);

	}

    }

    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_RIGHT && mirror == 1) {
	    if (pokemonIndex < 8) {
		pokemonIndex++;
		repaint();
	    }
	} else if (e.getKeyCode() == KeyEvent.VK_LEFT && mirror == 1) {
	    if (pokemonIndex > 0) {
		pokemonIndex--;
		repaint();
	    }
	} else if (e.getKeyCode() == KeyEvent.VK_UP && mirror == 1) {
	    if (id > 9 || id <= 1) {
	    } else {
		yf -= 14;
		id--;
		System.out.println(id);
		repaint();
	    }
	} else if (e.getKeyCode() == KeyEvent.VK_DOWN && mirror == 1) {
	    if (id >= 9 || id < 1) {

	    } else {
		yf += 14;
		id++;
		System.out.println(id);
		repaint();
	    }
	} else if (e.getKeyCode() == KeyEvent.VK_Z) {
	    if (mirror == 1) {
		this.stats = ImageUtils
			.getWdirImage("/images/DatosPokedex.png");
		mirror++;
		repaint();
	    } else {
		repaint();
	    }

	} else if (e.getKeyCode() == KeyEvent.VK_X) {
	    if (mirror == 2) {
		this.stats = ImageUtils
			.getWdirImage("/images/fondoPokedex.png");
		mirror--;
		repaint();
	    } else {
		repaint();
	    }

	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
