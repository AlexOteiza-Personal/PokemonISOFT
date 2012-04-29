package graphics.login;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.HeadlessException;

import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;

public class Registro extends JDialog implements KeyListener {

	private JLoginPanel contentPane;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblRepiteContrasea;
	private JPasswordField passwordField;
	private JLabel lblSexo;
	private JPasswordField passwordField_2;
	private Connection unaConexion = DriverManager.getConnection(
			"jdbc:mysql://li-001.servers.agrs700.com/pokemon", "root",
			"vaquero1992700");
	private JComboBox comboBox;

	/**
	 * Launch the application. HOMBRE=0, MUJER=1
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Registro(Frame parent) throws SQLException {
		super(parent);
		// conectamos con la base de datos
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setModal(true);
		setBounds(100, 100, 430, 273);

		super.setTitle("Registro");
		contentPane = new JLoginPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(134, 105, 180, 20);
		contentPane.add(passwordField);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(134, 130, 180, 20);
		contentPane.add(passwordField_2);
		passwordField_2.setColumns(10);

		comboBox = new JComboBox();
		comboBox.addItem(new String("Hombre"));
		comboBox.addItem(new String("Mujer"));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		comboBox.setBounds(134, 157, 73, 20);
		contentPane.add(comboBox);
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(0, 0, 0, 0);
		contentPane.add(verticalStrut);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(24, 58, 60, 14);
		contentPane.add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(134, 55, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(24, 83, 48, 14);
		contentPane.add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setBounds(134, 80, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(24, 108, 80, 14);
		contentPane.add(lblContrasea);

		JLabel lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setForeground(Color.WHITE);
		lblRegistroDeUsuario.setBounds(24, 11, 171, 14);
		contentPane.add(lblRegistroDeUsuario);

		lblRepiteContrasea = new JLabel("Repite Contraseña:");
		lblRepiteContrasea.setForeground(Color.WHITE);
		lblRepiteContrasea.setBounds(24, 133, 111, 14);
		contentPane.add(lblRepiteContrasea);

		/*
		 * Habilitar intro con funcion de tabulador Set forwardKeys =
		 * getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
		 * Set backwardKeys =
		 * getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS);
		 * setFocusTraversalKeys
		 * (KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,java
		 * .util.Collections.EMPTY_SET); Set newForwardKeys = new
		 * HashSet(forwardKeys);
		 * newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		 * setFocusTraversalKeys
		 * (KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,newForwardKeys);
		 */

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(228, 205, 89, 23);
		contentPane.add(btnEnviar);
		ActionListener listenerEnviar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (validarUsuario(textField.getText()) == true
							&& textField.getText().length() > 0
							&& validarEmail(textField_1.getText())
							&& textField_1.getText().length() > 0
							&& validarpass(passwordField.getText(),
									passwordField_2.getText())) {
						java.sql.PreparedStatement stmt = unaConexion
								.prepareStatement("INSERT INTO user VALUES(?,?,?)");
						stmt.setString(1, textField.getText());
						stmt.setString(2, passwordField.getText());
						stmt.setString(3, textField_1.getText());
						stmt.executeUpdate();
						java.sql.PreparedStatement stmt2 = unaConexion
								.prepareStatement("INSERT INTO user_rank(username,is_male) VALUES(?,?)");
						stmt2.setString(1, textField.getText());
						stmt2.setInt(2, comboBox.getSelectedIndex());
						stmt2.executeUpdate();
						JOptionPane.showMessageDialog(null,
								"Registro realizado");
					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		};
		btnEnviar.addActionListener(listenerEnviar);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setBounds(24, 160, 111, 14);
		contentPane.add(lblSexo);

		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(Registro.class
				.getResource("/images/pokeball.JPG")));
		label.setBounds(0, 0, 425, 241);
		contentPane.add(label);
		Dimension tamFrame = this.getSize();// para obtener las dimensiones del
		// frame
		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// pantalla
		setLocation((tamPantalla.width - tamFrame.width) / 2,
				(tamPantalla.height - tamFrame.height) / 2);

		textField_1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
				try {
					if (validarUsuario(textField.getText())) {
						// cambiar a tick el usuario
						contentPane.setUsuarioValido(true);
						repaint();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
			}
		});

		passwordField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
				try {
					if (validarEmail(textField_1.getText())) {
						// cambiar a tick el email
						contentPane.setEmailValido(true);
						repaint();

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
			}
		});
	}

	private boolean validarpass(String text, String text2) {
		// TODO Auto-generated method stub
		if (text.equals(text2)) {
			contentPane.setContrasenaCorrecta(true);
			repaint();
			return true;
		} else
			contentPane.setContrasenaCorrecta(false);

		return false;
	}

	boolean validarUsuario(String elUsr) throws IOException {
		try {
			if (elUsr.length() == 0) {
				JOptionPane.showMessageDialog(null,
						"El usuario tiene que tener caracteres");
				contentPane.setUsuarioValido(false);
				repaint();
				return false;
			} else {
				// Preparamos la consulta
				Statement instruccionSQL = unaConexion.createStatement();
				ResultSet resultadosConsulta = instruccionSQL
						.executeQuery("SELECT * FROM user WHERE username='"
								+ elUsr + "'");

				if (resultadosConsulta.first()) {// si existe devuelve false, si
					contentPane.setUsuarioValido(false);
					repaint();
					JOptionPane.showMessageDialog(null, "El usuario ya existe");
					// no existe devuelve true
					return false; // usuario validado correctamente
				} else {

					return true; // usuario validado incorrectamente
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	boolean validarEmail(String Email) throws IOException, Exception {

		Pattern expresion = Pattern
				.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		Matcher mat = expresion.matcher(Email);
		if (mat.find()) {// miramos si el email es correcto mediante la
							// expresion regular,si es correcta realizamos la
							// query
			// Preparamos la consulta
			Statement instruccionSQL = unaConexion.createStatement();
			ResultSet resultadosConsulta = instruccionSQL
					.executeQuery("SELECT * FROM user WHERE email='" + Email
							+ "'");
			if (resultadosConsulta.first()) { // si es valido el primer reg. hay
												// una fila, tons el usuario y
												// su pw
												// existen
				JOptionPane.showMessageDialog(null, "El email ya existe");
				contentPane.setUsuarioValido(false);
				return false; // usuario validado correctamente
			} else {
				contentPane.setUsuarioValido(true);
				repaint();

				return true; // usuario validado incorrectamente
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"El correo no es valido,introduzca uno correcto");
			return false;// devuelve false si no es correcta el email
		}

	}

	public void keyPressedAction(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			System.out.println("asdfasdf");
			try {
				validarUsuario(textField.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				validarEmail(textField_1.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		/*
		 * 
		 * if(e.getKeyCode()==KeyEvent.VK_TAB){
		 * System.out.println("asdfasdfas"); try {
		 * System.out.println("pulsado"); validarUsuario(textField.getText());
		 * try { validarEmail(textField_1.getText()); } catch (Exception e1) {
		 * // TODO Auto-generated catch block e1.printStackTrace(); } } catch
		 * (IOException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 * 
		 * }
		 */
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}