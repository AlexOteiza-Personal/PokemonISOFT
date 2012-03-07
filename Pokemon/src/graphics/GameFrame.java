package graphics;

import exceptions.ImageInvalidSizeException;
import graphics.betatesting.FontTest;
import graphics.betatesting.PokedexTest;
import graphics.betatesting.PokemonStatusTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import player.PlayerPokemonList;
import utils.ImageUtils;

public class GameFrame extends JFrame implements KeyListener{
    private static GameFrame mGameFrame = new GameFrame();
	BufferedImage icon;
	JPanel currentRoom;
	private GameFrame(){
		currentRoom = new PokemonListFrame();
		//currentRoom = new PokedexTest();
		add(currentRoom);
		icon = ImageUtils.getWdirImage("/images/icon.png");
		setIconImage(icon);
		//add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
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
		currentRoom.setFocusable(true);
		this.add(currentRoom);
		this.repaint();
	    }
	    else if(room == RoomEnum.POKEMONLIST)
	    {
		this.remove(currentRoom);
		currentRoom = new PokemonListFrame();
		this.add(currentRoom);
		this.repaint();
	    }
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == 'P')
		{
			changeRoom(RoomEnum.POKEDEX);
		}
		else if(keyCode == 'L')
		{
			changeRoom(RoomEnum.POKEMONLIST);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
