package graphics;

import javax.swing.JFrame;

public class Skeleton extends JFrame{
	public Skeleton() {
		add(new Board());
		setTitle("Pokemon Isoft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setVisible(true);
	}
}
