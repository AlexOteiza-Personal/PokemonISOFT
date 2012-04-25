package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JPanel;

public abstract class Room extends JPanel{
	boolean onlyPress;
	boolean pressed = false;
	int keypressed=-1;
	
	public Room() {
		super(true);
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
}
