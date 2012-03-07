package graphics.betatesting;

import java.awt.Graphics;

import javax.swing.JPanel;

import utils.ImageUtils;

import fonts.BitmapFont;
import fonts.DialogFont;
import fonts.PokemonListFont;

public class FontTest extends JPanel{
	private PokemonListFont littleFont = new PokemonListFont(ImageUtils.getWdirImage("/images/font_pokemonlist.png"));
	private DialogFont normalFont= new DialogFont(ImageUtils.getWdirImage("/images/font_black.png"));
	private DialogFont centerFont= new DialogFont(ImageUtils.getWdirImage("/images/font_black.png"),BitmapFont.CENTER_ALIGN);
	private DialogFont rightFont = new DialogFont(ImageUtils.getWdirImage("/images/font_black.png"),BitmapFont.RIGHT_ALIGN);
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		littleFont.drawString(g, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 0);
		normalFont.drawString(g, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 20);
		normalFont.drawString(g, "Este esto es un texto alineado\na la izquierda", 70, 40);
		centerFont.drawString(g, "Esto es un texto alineado en el\ncentro mola un huevo", 140, 80);
		rightFont.drawString(g, "Y este a la derecha\neste mola mas", 200, 120);
	}
}
