package graphics;


import graphics.betatesting.FontTest;
import graphics.betatesting.PokemonStatusTest;
import graphics.world.OverWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;

import player.PlayerPokemonList;
import pokemon.Pokemon;
import pokemon.PokemonData;
import utils.AudioUtils;
import utils.ImageUtils;

import sounds.Music;

public class GameFrame extends JFrame implements KeyListener{
    public static int WIDTH=496;
    public static int HEIGHT=384;
    private static GameFrame mGameFrame = new GameFrame();
    private GameMenuBar menuBar;
    private Music backgroundMusic;
	BufferedImage icon;
	JPanel currentRoom;
	private GameFrame(){
		menuBar = new GameMenuBar();
		add(menuBar);
		setJMenuBar(menuBar);
		//currentRoom = new PokemonStatusTest(new Pokemon(PokemonData.Pidgey,2));
		currentRoom = new OverWorld();
		//currentRoom = new PokedexFrame();
		add(currentRoom);
		backgroundMusic = Music.ROUTE_3;
		backgroundMusic.loop();
		icon = ImageUtils.getWdirImage("/images/icon.png");
		setIconImage(icon);
		//add(new PokemonListFrame(PlayerPokemonList.getPlayerpokemonlist()));
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		setResizable(true);	
		addKeyListener(this);
		setFocusable(true);
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
		else if(currentRoom instanceof PokedexFrame)
		{
			remove(currentRoom);
			currentRoom = new OverWorld(true,0);
			add(currentRoom);
			currentRoom.setFocusable(true);
			setVisible(true);
		}
		else if(currentRoom instanceof PokemonListFrame)
		{
			remove(currentRoom);
			currentRoom = new OverWorld(true,1);
			add(currentRoom);
			currentRoom.setFocusable(true);
			setVisible(true);
		}
	}
	public void gotoPokemonList()
	{
		remove(currentRoom);
		currentRoom = new PokemonListFrame(0);
		add(currentRoom);
		currentRoom.setFocusable(true);
		setVisible(true);
	}
	
	public void gotoPokedex() {
		remove(currentRoom);
		currentRoom = new PokedexFrame();
		add(currentRoom);
		currentRoom.setFocusable(true);
		setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * Hacemos que la Room se encarge de lo que ocurra cuando pulsamos
		 * una tecla
		 */
		if(currentRoom instanceof Room)
		{
			Room room = (Room)currentRoom;
			room.keyPressed(e);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(currentRoom instanceof Room)
		{
			Room room = (Room)currentRoom;
			room.keyReleased(e);
		}
	}
	public void changeMusic()
	{
		/*TODO: Cambiar la musica
		backgroundMusic.stop();
		try {
			backgroundMusic = AudioUtils.getAudioWdir();
			backgroundMusic.loop(-1);
		} catch (LineUnavailableException e) {
			System.err.println("No se ha detectado ningun dispositivo de audio");
		}*/
	}
	@Override
	public void keyTyped(KeyEvent e) {}

}
