package graphics.world;

import fonts.DialogFont;
import graphics.GameFrame;
import graphics.PlayerOverWorld;
import graphics.Room;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import utils.ImageUtils;

public class OverWorld extends Room {
	private boolean kreleased=false;
	public static final int scale=2;
	private static int scrollSpeed = 17;
	private static int xMap = 0;
	private static int yMap = 0;
	private boolean onMenu;
	private int menuIndex;
	public int x;
	public int y;
	private World w;
	PlayerOverWorld player;
	private boolean moving = false;
	private BufferedImage menuImage;
	private BufferedImage arrowImage;
	BufferedImage[][] screenImages = new BufferedImage[2+GameFrame.HEIGHT /(16*scale)][2+GameFrame.WIDTH / (16*scale)];
	GameMap map = new GameMap();
	private DialogFont menuFont;
	private static int maxIndex = 6;

	public OverWorld()
	{
		this(false,0);
	}
	public OverWorld(boolean onMenu,int menuIndex) {
		super();
		setOnlyPress(true);
		menuFont = new DialogFont(ImageUtils.getWdirImage("/images/font_pokedex.png"));
		menuImage = ImageUtils.getWdirImage("/images/menu.png");
		arrowImage = ImageUtils.getWdirImage("/images/cursorMenu.png");
		this.onMenu = onMenu;
		this.menuIndex = menuIndex;
		x = 0;
		y = 0;
		player = new PlayerOverWorld();
		System.out.println(GameFrame.WIDTH);
		int[][] screenData = map.getMapData(xMap, yMap);

		for (int i = 0; i < screenImages.length; i++) {
			for (int j = 0; j < screenImages[i].length; j++) {
				screenImages[i][j] = Tiles.getTile(screenData[i][j]);
			}
		}
	}

	public void reloadTiles() {
		x=0;
		y=0;
		int[][] screenData = map.getMapData(xMap, yMap);
		for (int i = 0; i < screenImages.length; i++) {
			for (int j = 0; j < screenImages[i].length; j++) {
				screenImages[i][j] = Tiles.getTile(screenData[i][j]);
			}
		}
		repaint();
	}

	@Override
	public void paintRoom(Graphics g) {
		super.paint(g);
		((Graphics2D)g).scale(2, 2);
		for (int i = 0; i < screenImages.length; i++) {
			for (int j = 0; j < screenImages[i].length; j++) {
				g.drawImage(screenImages[i][j], x+(j-1)*16, y+(i-1)*16,null);
			}
		}
		if(onMenu)
		{
			g.drawImage(menuImage, 169, 0, null);
			g.drawImage(arrowImage,177, 11+(15*menuIndex),null);
			menuFont.drawString(g, "POKéDEX", 183, 8);
			menuFont.drawString(g, "POKéMON", 183, 23);
			menuFont.drawString(g, "MOCHILA", 183, 38);
			menuFont.drawString(g, "JUGADOR", 183, 53);
			menuFont.drawString(g, "GUARDAR", 183, 68);
			menuFont.drawString(g, "OPCIONES", 183, 83);
			menuFont.drawString(g, "SALIR", 183, 98);
		}
		g.dispose();
	}

	@Override
	protected void keyPressedAction(KeyEvent e) {
		if(!moving && !onMenu)
		{
			kreleased = false;
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				moveRight();
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			{
				moveLeft();
			}
			else if(e.getKeyCode()==KeyEvent.VK_UP)
			{
				moveUp();
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				moveDown();
			}
			else if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				onMenu = true;
				repaint();
			}
		}
		else if(!moving && onMenu)
		{
			if(e.getKeyCode()=='Z')
			{
				GameFrame gf = GameFrame.getGameFrame();
				switch(menuIndex)
				{
				case 0:gf.gotoPokedex();break;
				case 1:gf.gotoPokemonList();break;
				case 6:
					onMenu = false;
					repaint();
					break;
				default:break;
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_UP)
			{
				if(menuIndex>0)
				{
					menuIndex--;
					repaint();
				}
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				if(menuIndex<maxIndex)
				{
					menuIndex++;
					repaint();
				}
			}
			else if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_X)
			{
				onMenu = false;
				repaint();
			}
		}
	}

	private void moveRight() {
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!kreleased && !moving)
				{
				moving  = true;
				for (int i = 0; i < 16; i++) {
					x--;
					repaint();
					try{
					Thread.sleep(scrollSpeed);}
					catch(Exception ex){}
				}
				moving = false;
				xMap++;
				reloadTiles();
				}
			}
		});
		worker.start();
	}
	private void moveLeft() {
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!kreleased && !moving)
				{
				moving  = true;
				for (int i = 0; i < 16; i++) {
					x++;
					repaint();
					try{
					Thread.sleep(scrollSpeed);}
					catch(Exception ex){}
				}
				moving = false;
				xMap--;
				reloadTiles();
			}
			}
		});
		worker.start();
	}
	private void moveUp() {
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!kreleased && !moving)
				{
				moving  = true;
				for (int i = 0; i < 16; i++) {
					y++;
					repaint();
					try{
					Thread.sleep(scrollSpeed);}
					catch(Exception ex){}
				}
				moving = false;
				yMap--;
				reloadTiles();
			}
			}
		});
		worker.start();
	}
	private void moveDown() {
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!kreleased && !moving)
				{
				moving = true;
				for (int i = 0; i < 16; i++) {
					y--;
					repaint();
					try{
					Thread.sleep(scrollSpeed);}
					catch(Exception ex){}
				}
				moving = false;
				yMap++;
				reloadTiles();
				}
			}
		});
		worker.start();
	}
	
	public void repaint(int secs)
	{
		try {
			Thread.sleep(secs);
			repaint();
		} catch (InterruptedException e) {}
	}
	@Override
	protected void keyReleasedAction(KeyEvent e) {
		kreleased=true;
	}

}
