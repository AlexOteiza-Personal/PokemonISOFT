package graphics.battle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fonts.DialogFont;
import fonts.PokemonListFont;
import graphics.GameFrame;
import graphics.Room;

import battle.Battle;

import pokemon.Pokemon;
import sounds.Music;
import sounds.Sound;
import sounds.SoundData;
import utils.ImageUtils;
import utils.ThreadUtils;

public class BattleFrame extends Room {

	private Battle battle;
	private DialogBox dialogBox;
	private ScreenIntro screenIntro;
	private ScreenFlash screenFlash;

	private boolean waitingInput = false;
	private static int status;

	/* Status */
	protected static final int SCREEN_FLASH = 1;
	protected static final int SCREEN_OUT = 2;
	protected static final int START_BATTLE = 5;
	protected static final int SEND_PLAYER_POKEMON = 6;
	protected static final int SELECT_ACTION = 10;
	protected static final int SELECT_ATTACK = 11;
	protected static final int SELECT_ESCAPE = 12;
	protected static final int ESCAPE_FAIL = 20;
	protected static final int ESCAPE_SUCCESS = 21;
	
	
	private PlayerActor player;
	private PlayerPokemonActor playerPokemon;
	private PlayerPokemonActor enemyPokemon;
	private DialogSelectBox selectBox;
	private Sound click;
	private Sound pokeball;
	private ScreenOut screenOut;
	private DialogAttackBox attackBox;

	public BattleFrame(Pokemon pokemon) throws Exception {
		this.battle = new Battle(pokemon);
		this.playerPokemon = new PlayerPokemonActor(battle.getPlayerPokemon(), 20, 34, false);
		this.enemyPokemon = new PlayerPokemonActor(pokemon, -70, 10, true);
		this.dialogBox = new DialogBox();
		this.selectBox = new DialogSelectBox();
		this.attackBox = new DialogAttackBox(battle.getPlayerPokemon().getAttacks());
		this.player = new PlayerActor();
		this.click = new Sound("/sounds/click.wav");
		this.pokeball = new Sound("/sounds/pokeball.wav");
		this.screenFlash = new ScreenFlash();
		this.screenIntro = new ScreenIntro();
		this.screenOut = new ScreenOut();
		GameFrame.setMusic(Music.WILD_BATTLE);
		status = SCREEN_FLASH;
		flash();
	}

	@Override
	public void paintRoom(Graphics g) {
		if (status == SCREEN_FLASH) {
			screenFlash.paint(g);
		} 
		else if (status == SCREEN_OUT) {
			enemyPokemon.paint(g);
			playerPokemon.paint(g);
			dialogBox.paint(g);
			screenOut.paint(g);
		}
		else if (status == START_BATTLE) {
			enemyPokemon.paint(g);
			playerPokemon.paint(g);
			player.paint(g);
			dialogBox.paint(g);
			screenIntro.paint(g);
		} else if (status == SEND_PLAYER_POKEMON || status == ESCAPE_SUCCESS || status == ESCAPE_FAIL) {
			enemyPokemon.paint(g);
			playerPokemon.paint(g);
			player.paint(g);
			dialogBox.paint(g);
		} else if (status == SELECT_ATTACK) {
			enemyPokemon.paint(g);
			playerPokemon.paint(g);
			attackBox.paint(g);
		}
		else if (status == SELECT_ACTION) {
			enemyPokemon.paint(g);
			playerPokemon.paint(g);
			player.paint(g);
			dialogBox.paint(g);
			selectBox.paint(g);
		}
	}

	public synchronized void flash() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 8; i++) {
					screenFlash.setAlpha(0);
					for (int j = 0; j < 7; j++) {
						screenFlash.addAlpha(0.1f);
						repaint();
						ThreadUtils.sleep(50);
					}

				}
				screenFlash.addAlpha(1f);
				status = START_BATTLE;
				ThreadUtils.sleep(60);
				for (int i = 1; i < 30; i++) {
					screenIntro.addDiff(i);
					repaint();
					ThreadUtils.sleep(30);
				}
				appearPokemon();

			}
		});
		t.start();
	}

	private void appearPokemon() {
		enemyPokemon.setShadowed(true);
		enemyPokemon.setShadowAlpha(0.5f);
		enemyPokemon.setVisible(true);
		player.setVisible(true);
		for (int i = 0; i < 215; i++) {
			enemyPokemon.addX(1);
			player.addX(-1);
			repaint();
			ThreadUtils.sleep(9);
		}
		for (int i = 0; i < 9; i++) {
			enemyPokemon.addShadowAlpha(-0.1f);
			repaint();
			ThreadUtils.sleep(15);
		}
		if (battle.getEnePokemon().getSoundData() != null)
			battle.getEnePokemon().getSoundData().play();
		dialogBox.setDialogText(battle.getDialog(Battle.POKEMON_APPEAR));
		repaint();
		ThreadUtils.sleep(600);

		waitingInput = true;

	}

	private void sendPlayerPokemon() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				waitingInput=false;
				status = SEND_PLAYER_POKEMON;
				dialogBox.setDialogText(battle.getDialog(Battle.PLAYER_SEND_POKEMON));
				repaint();
				ThreadUtils.sleep(200);

				for (int i = 0; i < 110; i++) {
					player.addX(-1);
					if (i == 20)
						player.nextFrame();
					else if (i == 50)
						player.nextFrame();
					else if (i == 65)
						player.nextFrame();
					repaint();
					ThreadUtils.sleep(7);
				}
				showPlayerPokemon();
			}
		});
		t.start();
	}

	private void showPlayerPokemon() {

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				pokeball.play();
				ThreadUtils.sleep(300);
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						battle.getPlayerPokemon().getSoundData().play();
					}
				});t2.start();
				
				playerPokemon.setShadowAlpha(1.0f);
				playerPokemon.setShadowColor(new Color(0xfa70ac));
				playerPokemon.setShadowed(true);
				playerPokemon.setVisible(true);
				playerPokemon.setScaleCenterDown(0.1, 0.1);
				repaint();
				double scale = 0.35;
				// playerPokemon.setScale(0.2, 0.2);
				for (int i = 0; i < 7; i++) {
					scale += 0.1;
					playerPokemon.setScaleCenterDown(scale, scale);
					repaint();
					ThreadUtils.sleep(25);
				}
				playerPokemon.setScaleCenterDown(1,1);
				ThreadUtils.sleep(100);
				for (int i = 0; i < 9; i++) {
					playerPokemon.addShadowAlpha(-0.1f);
					repaint();
					ThreadUtils.sleep(25);
				}
				ThreadUtils.sleep(300);
				waitingInput = true;
				status = SELECT_ACTION;
				dialogBox.setDialogText(battle.getDialog(Battle.SELECT_ACTION));
				repaint();
			}
		});
		t.start();
	}

	@Override
	protected void keyPressedAction(KeyEvent e) {
		if (waitingInput) {

			if (e.getKeyCode() == 'Z') {
				if (status == START_BATTLE) {
					sendPlayerPokemon();
				}
				else if (status == SELECT_ACTION) {
					int selectIndex = selectBox.getSelectIndex();
					if(selectIndex==0){
						status = SELECT_ATTACK;
						dialogBox.setDialogText(battle.getDialog(SELECT_ACTION));
						repaint();
					}
					else if (selectIndex==1) {
						//TODO
					}
					else if (selectIndex==2) {
						//TODO
					}
					else if (selectIndex==3) {
						status = SELECT_ESCAPE;
						startEscape();
					}
				}
				else if (status == SELECT_ATTACK) {
					
				}
				else if (status == ESCAPE_FAIL) {
					status = SELECT_ACTION;
					repaint();
				}
				else if (status == ESCAPE_SUCCESS) {
					status = SCREEN_OUT;
					repaint();
					escape();
				}
			}
			else if (e.getKeyCode() == 'X') {
				if(status == SELECT_ATTACK)
				{
					status = SELECT_ACTION;
					repaint();
				}
			}
			if (status == SELECT_ACTION) {
				int selectIndex = selectBox.getSelectIndex();
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (selectIndex == 0 || selectIndex == 2)
						selectBox.addSelectIndex(1);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (selectIndex == 1 || selectIndex == 3)
						selectBox.addSelectIndex(-1);
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (selectIndex == 2 || selectIndex == 3)
						selectBox.addSelectIndex(-2);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (selectIndex == 0 || selectIndex == 1)
						selectBox.addSelectIndex(2);
				}
				repaint();
				ThreadUtils.sleep(50);
			}
			else if (status == SELECT_ATTACK) {
				int selectIndex = attackBox.getAttackIndex();
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (selectIndex == 0 || selectIndex == 2)
						attackBox.addAttackIndex(1);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (selectIndex == 1 || selectIndex == 3)
						attackBox.addAttackIndex(-1);
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (selectIndex == 2 || selectIndex == 3)
						attackBox.addAttackIndex(-2);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (selectIndex == 0 || selectIndex == 1)
						attackBox.addAttackIndex(2);
				}
				repaint();
				ThreadUtils.sleep(50);
			}
		}
	}

	private void startEscape() {
		ThreadUtils.sleep(100);
		if(battle.escape())
		{
			status = ESCAPE_SUCCESS;
			dialogBox.setDialogText(battle.getDialog(ESCAPE_SUCCESS));
		}
		else
		{
			status = ESCAPE_FAIL;
			dialogBox.setDialogText(battle.getDialog(ESCAPE_FAIL));
		}
		waitingInput = true;
		repaint();
		
	}
	private void escape(){
		Thread t = new Thread(new Runnable() {
			@Override
			
			
			public void run() {
				GameFrame.stopMusicGradually();
				ThreadUtils.sleep(450);
				for (int i = 0; i < 10; i++) {
					screenOut.addAlpha(0.1f);
					repaint();
					ThreadUtils.sleep(75);
				}

			}
		});t.start();
	}

	@Override
	protected void keyReleasedAction(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static int getStatus() {
		return status;
	}

}
