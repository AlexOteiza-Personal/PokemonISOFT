package graphics.login;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utils.ImageUtils;

public class JLoginPanel extends JPanel {
	private BufferedImage tick;
	private BufferedImage x;
	boolean usuarioValido;
	boolean emailValido;
	boolean contrasenaCorrecta;

	public JLoginPanel() {
		this.tick = ImageUtils.getWdirImage("/images/tick.png");
		this.x = ImageUtils.getWdirImage("/images/x.png");
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		if (usuarioValido == true)
			g.drawImage(this.tick, 320, 58, null);
		else {
			g.drawImage(this.x, 320, 58, null);
			

		}
		if (emailValido == true) {
			g.drawImage(this.tick, 320, 83, null);
		} else {
			g.drawImage(this.x, 320, 83, null);

		}
		if (contrasenaCorrecta == true) {
			g.drawImage(this.tick, 320, 108, null);

			g.drawImage(this.tick, 320, 132, null);
		} else {
			g.drawImage(this.x, 320, 108, null);

			g.drawImage(this.x, 320, 132, null);
		}

	}
	public void setUsuarioValido(boolean usuarioValido) {
		this.usuarioValido = usuarioValido;
	}

	public void setEmailValido(boolean emailValido) {
		this.emailValido = emailValido;
	}

	public void setContrasenaCorrecta(boolean contrasenaCorrecta) {
		this.contrasenaCorrecta = contrasenaCorrecta;
	}
}