package graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.Timer;

import javax.swing.JPanel;

import utils.ThreadUtils;

public abstract class Room extends JPanel{
	boolean onlyPress;
	boolean pressed = false;
	int keypressed=-1;
	Graphics buffer;
	Image imageBuffer;

	public Room() {
		super();
		onlyPress = false;
	}
	/* Convertimos el el key pressed para que solo ocurra cuando pulsamos el boton
	 * y no mientras, usamos la variable onlyPress para saber si queremos que ocurra
	 * solo cuando pulsamos y mientras es pulsada. Por defecto ocurrira mientras se pulse.
	 */
	public void keyPressed(KeyEvent e)
	{
		if(!pressed && onlyPress)
		{
			keypressed = e.getKeyCode();
			pressed = true;
		}
		keyPressedAction(e);
	}
	public void keyReleased(KeyEvent e)
	{
		if(keypressed==-1 || keypressed == e.getKeyCode() && onlyPress)
		{
			keypressed = -1;
			pressed = false;
		}
		keyReleasedAction(e);
	}
	protected abstract void keyPressedAction(KeyEvent e);
	protected abstract void keyReleasedAction(KeyEvent e);
	protected void setOnlyPress(boolean onlyPress)
	{
		this.onlyPress = onlyPress;
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(2, 2);
		paintRoom(g);
	}
	public abstract void paintRoom(Graphics g);
	
}
