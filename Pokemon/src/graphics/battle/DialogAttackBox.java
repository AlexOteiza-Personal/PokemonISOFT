package graphics.battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pokemon.PokemonAttacks;
import pokemon.attacks.Attack;

import utils.ImageUtils;

import fonts.PokemonListFont;

public class DialogAttackBox {
	private int attackIndex;
	private int x=0;
	private int y=114;
	
	private static final int xTextOffset=16;
	private static final int yTextOffset=10;
	private static final int xTextSeparation=72;
	private static final int yTextSeparation=16;
	
	private static final int xSecondBox=160;
	private static final int xSecondTextOffset=8;
	private static final int ySecondTextOffset=11;
	private static final int xPPTextSeparation=35;
	
	
	private PokemonListFont selectFont;
	private BufferedImage pointer;
	private BufferedImage attackBox;
	private PokemonAttacks attacks;
	
	public DialogAttackBox(PokemonAttacks attacks) {
		this.attackIndex = 0;
		this.pointer = ImageUtils.getWdirImage("/images/cursorMenu.png");
		this.attackBox = ImageUtils.getWdirImage("/images/attackSelectBox.png");
		this.selectFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokedex_small.png"));
		this.attacks = attacks;
	}
	public void paint(Graphics g){
		g.drawImage(attackBox, x, y, null);
		Attack attack1 = attacks.getAttack(0);
		Attack attack2 = attacks.getAttack(1);
		Attack attack3 = attacks.getAttack(2);
		Attack attack4 = attacks.getAttack(3);
		if(attack1!=null)
			selectFont.drawString(g, attack1.getName(), x+xTextOffset, y+yTextOffset);
		else
			selectFont.drawString(g, "-", x+xTextOffset, y+yTextOffset);
		if(attack2!=null)
			selectFont.drawString(g, attack2.getName(), x+xTextOffset+xTextSeparation, y+yTextOffset);
		else
			selectFont.drawString(g, "-", x+xTextOffset+xTextSeparation, y+yTextOffset);
		if(attack3!=null)
			selectFont.drawString(g, attack3.getName(), x+xTextOffset, y+yTextOffset+yTextSeparation);
		else
			selectFont.drawString(g, "-", x+xTextOffset, y+yTextOffset+yTextSeparation);
		
		if(attack4!=null)
			selectFont.drawString(g, attack4.getName(), x+xTextOffset+xTextSeparation, y+yTextOffset+yTextSeparation);
		else
			selectFont.drawString(g, "-", x+xTextOffset+xTextSeparation, y+yTextOffset+yTextSeparation);
		
		Attack selectedAttack = getSelectedAttack();
		selectFont.drawString(g, "PP", x+xSecondBox+xSecondTextOffset, y+ySecondTextOffset);
		selectFont.drawString(g, selectedAttack.getCurrentPP()+"/"+selectedAttack.getMaxPP(), x+xSecondBox+xSecondTextOffset+xPPTextSeparation, y+ySecondTextOffset);
		selectFont.drawString(g, "TIPO/"+selectedAttack.getType(), x+xSecondBox+xSecondTextOffset, y+ySecondTextOffset+yTextSeparation);
		selectFont.drawString(g, "1234567890", 10, 100);
		switch(attackIndex){
		case 0:g.drawImage(pointer, x+xTextOffset-7, y+yTextOffset+2,null);break;
		case 1:g.drawImage(pointer, x+xTextOffset+xTextSeparation-7, y+yTextOffset+2,null);break;
		case 2:g.drawImage(pointer, x+xTextOffset-7, y+yTextOffset+yTextSeparation+2,null);break;
		case 3:g.drawImage(pointer, x+xTextOffset+xTextSeparation-7, y+yTextOffset+yTextSeparation+2,null);break;
		default:break;
		}
	}
	public int getAttackIndex() {
		return attackIndex;
	}
	public void setAttackIndex(int attackIndex) {
		this.attackIndex = attackIndex;
	}
	public void addAttackIndex(int attackIndex) {
		this.attackIndex += attackIndex;
	}
	public Attack getSelectedAttack(){
		return this.attacks.getAttack(attackIndex);
	}
}
