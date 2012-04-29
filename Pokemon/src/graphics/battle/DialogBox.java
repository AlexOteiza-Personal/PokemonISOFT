package graphics.battle;


import static graphics.battle.BattleFrame.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fonts.DialogFont;
import fonts.PokemonListFont;

import pokemon.PokemonAttacks;
import utils.ImageUtils;

public class DialogBox {
	private BufferedImage dialogBox;
	private BufferedImage attackBox;
	private String dialogText;
	private int x=0;
	private int y=114;
	private static final int selectXOffset = 120;
	private static final int selectYOffset = 2;
	private int attackIndex;
	private DialogFont font;
	
	private BufferedImage pointer;
	public DialogBox() {
		this.dialogText = "";
		this.attackIndex = 0;
		this.dialogBox = ImageUtils.getWdirImage("/images/battleTextBox.png");
		this.attackBox = null;
		this.font = new DialogFont(ImageUtils.getWdirImage("/images/font_white.png"));
	}
	public void paint(Graphics g){
		g.drawImage(dialogBox,x,y,null);
		if(dialogText!=null)
			font.drawString(g, dialogText, x+10, y+7);
	}
	public String getDialogText() {
		return dialogText;
	}
	public void setDialogText(String dialogText) {
		this.dialogText = dialogText;
	}
	
	public int getAttackIndex() {
		return attackIndex;
	}
	public void setAttackIndex(int attackIndex) {
		this.attackIndex = attackIndex;
	}

}
