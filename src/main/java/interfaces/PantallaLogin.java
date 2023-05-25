package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import clases.Usuario;
import excepciones.ClienteNoEncontradoException;
import excepciones.ContraseñaErroneaException;
import utils.DAOApp;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaLogin extends JPanel{
	protected Usuario usuaioLogado;
	private Ventana ventana;
	private JPasswordField textContraseñaLogin;
	
	
	public PantallaLogin(Ventana v) {
		setBackground(new Color(254, 171, 103));
		this.ventana=v;
		setLayout(null);
		
		JLabel nombreApp = new JLabel("AROUND U");
		nombreApp.setIcon(new ImageIcon("C:\\Users\\juanc\\OneDrive\\Imágenes\\Capturas de pantalla\\logoFinal1.png"));
		nombreApp.setForeground(new Color(0, 33, 71));
		nombreApp.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
		nombreApp.setHorizontalAlignment(SwingConstants.CENTER);
		nombreApp.setBounds(137, 54, 331, 117);
		add(nombreApp);
		
		JLabel emailLogin = new JLabel("Email");
		emailLogin.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		emailLogin.setForeground(new Color(0, 33, 71));
		emailLogin.setToolTipText("");
		emailLogin.setHorizontalAlignment(SwingConstants.CENTER);
		emailLogin.setBounds(74, 196, 102, 26);
		add(emailLogin);
		
		JLabel contraseñaLogin = new JLabel("Contraseña");
		contraseñaLogin.setToolTipText("");
		contraseñaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contraseñaLogin.setForeground(new Color(0, 33, 71));
		contraseñaLogin.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		contraseñaLogin.setBounds(74, 250, 102, 26);
		add(contraseñaLogin);
		
		final JTextArea textEmailLogin = new JTextArea();
		textEmailLogin.setBounds(186, 201, 174, 19);
		add(textEmailLogin);
		
		textContraseñaLogin = new JPasswordField();
		textContraseñaLogin.setBounds(186, 255, 174, 19);
		add(textContraseñaLogin);
		
		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String emailLogin = textEmailLogin.getText();
				String contraseñaLogin = new String(textContraseñaLogin.getPassword());
				try {
					ventana.setUsuarioLogado(new Usuario(emailLogin, contraseñaLogin));
					JOptionPane.showMessageDialog(ventana, "Bienvenid@, " + ventana.getUsuarioLogado().getNombre(),
							"Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaPrincipal.class);
				} catch (ClienteNoEncontradoException e1) {
					JOptionPane.showMessageDialog(ventana, "El cliente no existe", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContraseñaErroneaException e2) {
					JOptionPane.showMessageDialog(ventana, "Contraseña incorrecta", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}

			}
		});
		botonAcceder.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		botonAcceder.setBackground(new Color(104, 253, 183));
		botonAcceder.setBounds(132, 298, 109, 21);
		add(botonAcceder);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		botonRegistrarse.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		botonRegistrarse.setBackground(new Color(104, 253, 183));
		botonRegistrarse.setBounds(251, 298, 109, 21);
		add(botonRegistrarse);
		
		JButton botonOlvidoContraseña = new JButton("¿Has olvidado tu contraseña?");
		botonOlvidoContraseña.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		botonOlvidoContraseña.setBounds(137, 359, 223, 21);
		botonOlvidoContraseña.setBackground(new Color(254, 171, 103));
		add(botonOlvidoContraseña);
		
		JCheckBox checkRecuerdame = new JCheckBox("Recuérdame");
		checkRecuerdame.setBackground(new Color(254, 171, 103));
		checkRecuerdame.setBounds(428, 226, 109, 21);
		add(checkRecuerdame);
		
		
		
	}
}
