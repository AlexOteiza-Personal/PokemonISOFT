package graphics.battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.ImageUtils;

import fonts.PokemonListFont;

public class DialogSelectBox {
	private int selectIndex;
	private int x=120;
	private int y=116;
	private static final int xTextOffset=16;
	private static final int yTextOffset=8;
	private static final int xTextSeparation=56;
	private static final int yTextSeparation=16;
	private PokemonListFont selectFont;
	private BufferedImage pointer;
	private BufferedImage selectBox;
	
	public DialogSelectBox() {
		this.selectIndex = 0;
		this.pointer = ImageUtils.getWdirImage("/images/cursorMenu.png");
		this.selectBox = ImageUtils.getWdirImage("/images/battleSelectBox.png");
		this.selectFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokedex_small.png"));
	}
	public void paint(Graphics g){
		g.drawImage(selectBox, x, y, null);
		selectFont.drawString(g, "LUCHA", x+xTextOffset, y+yTextOffset);
		selectFont.drawString(g, "MOCHILA", x+xTextOffset+xTextSeparation, y+yTextOffset);
		selectFont.drawString(g, "POKÈMON", x+xTextOffset, y+yTextOffset+yTextSeparation);
		selectFont.drawString(g, "HUIR", x+xTextOffset+xTextSeparation, y+yTextOffset+yTextSeparation);
		switch(selectIndex){
		case 0:g.drawImage(pointer, x+xTextOffset-7, y+yTextOffset+2,null);break;
		case 1:g.drawImage(pointer, x+xTextOffset+xTextSeparation-7, y+yTextOffset+2,null);break;
		case 2:g.drawImage(pointer, x+xTextOffset-7, y+yTextOffset+yTextSeparation+2,null);break;
		case 3:g.drawImage(pointer, x+xTextOffset+xTextSeparation-7, y+yTextOffset+yTextSeparation+2,null);break;
		default:break;
		}
	}
	public int getSelectIndex() {
		return selectIndex;
	}
	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}
	public void addSelectIndex(int selectIndex) {
		this.selectIndex += selectIndex;
	}
}
