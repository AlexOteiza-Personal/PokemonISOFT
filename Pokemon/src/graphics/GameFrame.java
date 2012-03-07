package graphics;

import exceptions.ImageInvalidSizeException;
import graphics.betatesting.FontTest;
import graphics.betatesting.PokedexTest;
import graphics.betatesting.PokemonStatusTest;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import player.PlayerPokemonList;
import utils.ImageUtils;

public class GameFrame extends JFrame{
    private static GameFrame mGameFrame = new GameFrame();
	BufferedImage icon;
	JPanel currentRoom;
	private GameFrame(){
		//currentRoom = new PokemonStatusTest();
		currentRoom = new PokedexTest();
		add(currentRoom);
		icon = ImageUtils.getWdirImage("/images/icon.png");
		setIconImage(icon);
		//add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		add(currentRoom);
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setVisible(true);
	}
	public static GameFrame getGameFrame()
	{
	    return mGameFrame;
	}
	public void changeRoom(RoomEnum room)
	{
	    if(room == RoomEnum.POKEDEX)
	    {
		this.remove(currentRoom);
		currentRoom = new PokedexTest();
		this.add(currentRoom);
	    }
	    else if(room == RoomEnum.POKEMONLIST)
	    {
		this.remove(currentRoom);
		currentRoom = new PokemonListFrame();
		this.add(currentRoom);
	    }
	}
}
