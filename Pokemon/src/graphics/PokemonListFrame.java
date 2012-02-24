package graphics;

import utils.ImageUtils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import player.PlayerPokemonList;

public class PokemonListFrame extends JPanel {
    private PlayerPokemonList playerPokemonList;
    private BufferedImage background;
    private BufferedImage firstPokemonBox;
    private BufferedImage pokemonBox;
    public PokemonListFrame(PlayerPokemonList playerPokemonList) throws IOException
    {
	this.playerPokemonList = playerPokemonList;
	this.background = ImageUtils.getWdirImage("/images/pokemonlist/background.png");
	this.firstPokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/boxBig.png");
	this.pokemonBox = ImageUtils.getWdirImage("/images/pokemonlist/box.png");
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
	//g2.scale(2, 2);
        g.drawImage(background, 0, 0, null);
        g.drawImage(firstPokemonBox,8,26,null);
        g.drawString(playerPokemonList.getPokemon(0).getName(), 8, 26);
        g.drawImage(pokemonBox, 96, 10, null);
        g.drawImage(pokemonBox, 96, 34, null);
        g.drawImage(pokemonBox, 96, 58, null);
        g.drawImage(pokemonBox, 96, 82, null);
        g.drawImage(pokemonBox, 96, 106, null);
    }

}