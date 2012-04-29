package graphics.login;

import graphics.GameFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class LoginFrame extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField txtUser, txtPass;
	private JLabel lblUser, lblPass;
	private JButton btnAceptar, btnCancelar, btnJugar, btnRegistrarse;

	public LoginFrame() {
		setTitle("Login Usuarios");

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create the tab pages
		createPage1();
		createPage2();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("          Usuario Registrado          ", panel1);
		tabbedPane.addTab(
				"                      Invitado                     ", panel2);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
	}

	public void createPage1() {
		panel1 = new JPanel();
		panel1.add(Box.createVerticalStrut(50));
		panel1.setLayout(new FlowLayout());
		txtUser = new JTextField(10); // numero de caracteres maximo en el
										// cuadro de texto
		lblUser = new JLabel("Usuario: ");
		txtUser.setToolTipText("Escriba su nombre de usuario");

		panel1.add(lblUser);
		panel1.add(txtUser);

		txtPass = new JPasswordField(10);// numero de caracteres maximo en el
											// cuadro de texto
		lblPass = new JLabel("Contraseña: ");
		txtPass.setToolTipText("Escriba su contraseña");

		panel1.add(lblPass);// añadimos la etiqueta lblpass
		panel1.add(txtPass);// añadimos el cammpo de texto txtPass

		btnAceptar = new JButton("Aceptar");
		// establecer Boton aceptar por defecto
		getRootPane().setDefaultButton(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		panel1.add(btnAceptar);
		panel1.add(btnCancelar);
		ActionListener escuchadorbtnAceptar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					// chekar si el usuario escrbio el nombre de usuario y pw
					if (txtUser.getText().length() > 0 && txtPass.getText().length() > 0) {
						// Si el usuario si fue validado correctamente
						if (validarUsuario(txtUser.getText(), txtPass.getText())) 
						{
							// Codigo para mostrar la ventana principal
							setVisible(false);
							// ARRANCAR EL JUEGO
							GameFrame.getGameFrame();
						} else {
							JOptionPane
									.showMessageDialog(null,
											"El nombre de usuario y/o contrasenia no son validos.");
							txtUser.setText(""); // limpiar campos
							txtPass.setText("");

							txtUser.requestFocusInWindow();
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Debe escribir nombre de usuario y contraseña.\n"
										+ "NO puede dejar ningun campo vacio");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		btnAceptar.addActionListener(escuchadorbtnAceptar); // Asociar
															// escuchador para
															// el boton Aceptar

		// Agregar listener al boton Cancelar
		ActionListener listenerCancelar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0); // terminar el programa
			}
		};
		btnCancelar.addActionListener(listenerCancelar); // Asociar escuchador
															// para el boton
															// Cancelar
		setSize(400, 170); // Tamanio del Frame
		setResizable(false); // que no se le pueda cambiar el tamanio
		// Centrar la ventana de autentificacion en la pantalla
		Dimension tamFrame = this.getSize();// para obtener las dimensiones del
											// frame
		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize(); // para
																				// obtener
																				// el
																				// tamaño
																				// de
																				// la
																				// pantalla
		setLocation((tamPantalla.width - tamFrame.width) / 2,
				(tamPantalla.height - tamFrame.height) / 2); // para
																// posicionar
		setVisible(true); // Hacer visible al frame

	} // fin de constructor

	// Metodo que conecta con el servidor MYSQL y valida los usuarios
	boolean validarUsuario(String elUsr, String elPw) throws IOException {
		try {
			// conectamos con la base de datos
			Connection unaConexion = DriverManager.getConnection(
					"jdbc:mysql://li-001.servers.agrs700.com/pokemon", "root",
					"vaquero1992700");
			// Preparamos la consulta
			Statement instruccionSQL = unaConexion.createStatement();
			ResultSet resultadosConsulta = instruccionSQL
					.executeQuery("SELECT * FROM user WHERE username='" + elUsr
							+ "' AND password='" + elPw + "'");

			if (resultadosConsulta.first()) // si es valido el primer reg. hay
											// una fila, tons el usuario y su pw
											// existen
				return true; // usuario validado correctamente
			else
				return false; // usuario validado incorrectamente

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void createPage2() {
		panel2 = new JPanel();
		panel2.add(Box.createVerticalStrut(90));
		panel2.setLayout(new FlowLayout());

		btnJugar = new JButton("Jugar");
		btnRegistrarse = new JButton("Registrarse");
		btnJugar.setToolTipText("Solo los usuarios registrados podran guardar puntuaciones ni partidas, registrese");

		panel2.add(btnJugar);
		panel2.add(btnRegistrarse);
		ActionListener listenerJugar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// terminar el programa
				GameFrame.getGameFrame();
			}
		};
		btnJugar.addActionListener(listenerJugar);
		final JFrame frame = this;
		ActionListener listenerRegistro = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// terminar el programa
				
				Registro registro;
				try {
					registro = new Registro(frame);
					registro.setVisible(true);

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Conexion fallida, puede que no tenga conexion a internet intentelo de nuevo");
					
					e.printStackTrace();
				}
				
			}
		};
		btnRegistrarse.addActionListener(listenerRegistro);
	}

}