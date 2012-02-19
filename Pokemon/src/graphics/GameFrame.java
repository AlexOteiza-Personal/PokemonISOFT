package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import pokemon.imagedata.InvalidImageSizeException;

public class GameFrame extends JFrame{
	BufferedImage icon;
	public GameFrame() throws IOException, InvalidImageSizeException{
		try {
			icon = ImageIO.read(getClass().getResource("/images/icon.png"));
			setIconImage(icon);
		} catch (IOException e) {
			System.err.println("Error al abrir archivo de icono");
		}
		add(new GamePanel());
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setVisible(true);
	}
}
