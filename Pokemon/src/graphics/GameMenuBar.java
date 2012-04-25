package graphics;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMenuBar extends JMenuBar {
	// Declaro los JMenu
		private JMenu fileMenu, toolMenu, helpMenu, utilitiesMenu;

		// Declaro los JMenuItem
		private JMenuItem restart, save, saveExit, exit, showHelp,
				infoAbout, ranking, changeControls;
		public GameMenuBar() {
			super();
			fileMenu = new JMenu("Archivo");
			toolMenu = new JMenu("Herramientas");
			helpMenu = new JMenu("Ayuda");
			utilitiesMenu = new JMenu("Utilidades");
			
			// menu de boton archivo
			restart = new JMenuItem("Reiniciar");
			save = new JMenuItem("Guardar");
			saveExit = new JMenuItem("Guardar y salir");
			exit = new JMenuItem("Salir");
			
			// menu herramientas
			ranking = new JMenuItem("Ver Ranking...");
			changeControls = new JMenuItem("Cambiar controles...");
			
			// menu de boton ayuda
			showHelp = new JMenuItem("Ver La Ayuda");
			infoAbout = new JMenuItem("Acerca del pokemon");
			agregar();
		}
		private void agregar() {
			// Agregamos el menu de archivo y sus respectivos botones
			add(fileMenu);
			fileMenu.add(this.restart);
			fileMenu.add(this.save);
			fileMenu.add(this.saveExit);
			fileMenu.add(this.exit);
			// Agregamos el menu de herramientas y sus respectivos botones
			add(toolMenu);
			toolMenu.add(this.ranking);
			toolMenu.add(this.utilitiesMenu);
			// Agregamos el menu de utilidades y sus respectivos botones
			add(utilitiesMenu);
			this.utilitiesMenu.add(this.changeControls);
			// Agregamos el menu de ayuda y sus respectivos botones
			add(this.helpMenu);
			helpMenu.add(this.showHelp);
			helpMenu.add(this.infoAbout);

		}
}
