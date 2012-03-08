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
import javax.swing.plaf.SliderUI;

import player.PlayerPokemonList;
import pokemon.Pokemon;
import pokemon.PokemonData;
import utils.ImageUtils;

public class GameFrame extends JFrame implements KeyListener{
    private static GameFrame mGameFrame = new GameFrame();
	BufferedImage icon;
	JPanel currentRoom;
	private GameFrame(){
		//currentRoom = new PokemonStatusTest(new Pokemon(PokemonData.Pidgey,2));
		currentRoom = new PokemonListFrame();
		//currentRoom = new PokedexTest();
		add(currentRoom);
		icon = ImageUtils.getWdirImage("/images/icon.png");
		setIconImage(icon);
		//add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(490,350);
		setResizable(false);
		setFocusable(true);
		addKeyListener(this);
		setVisible(true);
	}
	public static GameFrame getGameFrame()
	{
	    return mGameFrame;
	}
	public void gotoPokemonStatus(Pokemon pokemon, int index)
	{
		if(currentRoom instanceof PokemonListFrame){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			currentRoom.setFocusable(false);
			remove(currentRoom);
			currentRoom = new PokemonStatusTest(pokemon,index);
			add(currentRoom);
			currentRoom.setFocusable(true);
			setVisible(true);
		}
	}
	public void goBack()
	{
		if(currentRoom instanceof PokemonStatusTest){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			remove(currentRoom);
			int index = ((PokemonStatusTest)currentRoom).getIndex();
			currentRoom = new PokemonListFrame(index);
			add(currentRoom);
			currentRoom.setFocusable(true);
			setVisible(true);
		}
	}
	public void startBattle()
	{
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(currentRoom instanceof Room)
		{
			Room room = (Room)currentRoom;
			room.keyAction(e);
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
