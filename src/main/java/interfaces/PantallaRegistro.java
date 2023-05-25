package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import clases.Persona;
import clases.Usuario;
import enums.Tipos;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private Usuario usuarioRegistro;
	private JTextField campoEmailRegistro;
	private JTextField campoNombreRegistro;
	private JTextField campoApellidosRegistro;
	private JTextField campoNickRegistro;
	private JTextField campoTelefonoRegistro;
	private JPasswordField campoContraseñaRegistro;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public PantallaRegistro(Ventana v) {
		setBackground(new Color(255, 180, 104));
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 587, 0, 0};
		gridBagLayout.rowHeights = new int[]{265, 57, 0, 28, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(new Color(255, 180, 104));
		GridBagConstraints gbc_panelImagen = new GridBagConstraints();
		gbc_panelImagen.insets = new Insets(65, 0, 5, 5);
		gbc_panelImagen.fill = GridBagConstraints.BOTH;
		gbc_panelImagen.gridx = 1;
		gbc_panelImagen.gridy = 0;
		add(panelImagen, gbc_panelImagen);
		GridBagLayout gbl_panelImagen = new GridBagLayout();
		gbl_panelImagen.columnWidths = new int[]{330, 0};
		gbl_panelImagen.rowHeights = new int[]{75, 66, 0};
		gbl_panelImagen.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelImagen.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelImagen.setLayout(gbl_panelImagen);
		
		JLabel labelRegistrarse = new JLabel("REGÍSTRATE");
		GridBagConstraints gbc_labelRegistrarse = new GridBagConstraints();
		gbc_labelRegistrarse.insets = new Insets(0, 0, 5, 0);
		gbc_labelRegistrarse.gridx = 0;
		gbc_labelRegistrarse.gridy = 0;
		panelImagen.add(labelRegistrarse, gbc_labelRegistrarse);
		labelRegistrarse.setIcon(new ImageIcon("C:\\Users\\juanc\\OneDrive\\Imágenes\\Capturas de pantalla\\logoFinal1.png"));
		labelRegistrarse.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
		
		JLabel lblNewLabel = new JLabel("Bienvenidx a Around U ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.ipadx = 25;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelImagen.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(255, 180, 104));
		GridBagConstraints gbc_panelOpciones = new GridBagConstraints();
		gbc_panelOpciones.insets = new Insets(0, 0, 5, 5);
		gbc_panelOpciones.fill = GridBagConstraints.BOTH;
		gbc_panelOpciones.gridx = 1;
		gbc_panelOpciones.gridy = 1;
		add(panelOpciones, gbc_panelOpciones);
		panelOpciones.setLayout(new GridLayout(0, 3, 0, 0));
		
		final JRadioButton opcionPersona = new JRadioButton("Persona");
		opcionPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoApellidosRegistro.setVisible(true);
				campoNickRegistro.setVisible(true);
			}
		});
		opcionPersona.setBackground(new Color(255, 180, 104));
		opcionPersona.setSelected(true);
		buttonGroup.add(opcionPersona);
		panelOpciones.add(opcionPersona);
		
		final JRadioButton opcionEmpresa = new JRadioButton("Empresa");
		opcionEmpresa.setBackground(new Color(255, 180, 104));
		opcionEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoApellidosRegistro.setVisible(false);
				campoNickRegistro.setVisible(false);
			}
		});
		buttonGroup.add(opcionEmpresa);
		panelOpciones.add(opcionEmpresa);
		
		JRadioButton opcionAdmin = new JRadioButton("Admin");
		opcionAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoApellidosRegistro.setVisible(false);
				campoNickRegistro.setVisible(false);
			}
		});
		opcionAdmin.setBackground(new Color(255, 180, 104));
		buttonGroup.add(opcionAdmin);
		panelOpciones.add(opcionAdmin);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBackground(new Color(255, 180, 104));
		GridBagConstraints gbc_panelPersona = new GridBagConstraints();
		gbc_panelPersona.insets = new Insets(0, 0, 5, 5);
		gbc_panelPersona.gridx = 1;
		gbc_panelPersona.gridy = 2;
		add(panelPersona, gbc_panelPersona);
		GridBagLayout gbl_panelPersona = new GridBagLayout();
		gbl_panelPersona.columnWidths = new int[]{220, 225, 0};
		gbl_panelPersona.rowHeights = new int[]{24, 24, 24, 24, 24, 24, 0};
		gbl_panelPersona.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPersona.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPersona.setLayout(gbl_panelPersona);
		
		
		JLabel labelEmailRegistro = new JLabel("Email");
		labelEmailRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelEmailRegistro = new GridBagConstraints();
		gbc_labelEmailRegistro.fill = GridBagConstraints.BOTH;
		gbc_labelEmailRegistro.insets = new Insets(40, 0, 20, 5);
		gbc_labelEmailRegistro.gridx = 0;
		gbc_labelEmailRegistro.gridy = 0;
		panelPersona.add(labelEmailRegistro, gbc_labelEmailRegistro);
		labelEmailRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoEmailRegistro = new JTextField();
		campoEmailRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_campoEmailRegistro = new GridBagConstraints();
		gbc_campoEmailRegistro.fill = GridBagConstraints.BOTH;
		gbc_campoEmailRegistro.insets = new Insets(40, 0, 20, 0);
		gbc_campoEmailRegistro.gridx = 1;
		gbc_campoEmailRegistro.gridy = 0;
		panelPersona.add(campoEmailRegistro, gbc_campoEmailRegistro);
		campoEmailRegistro.setColumns(10);
		
		JLabel labelNombreRegistro = new JLabel("Nombre");
		labelNombreRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelNombreRegistro = new GridBagConstraints();
		gbc_labelNombreRegistro.fill = GridBagConstraints.BOTH;
		gbc_labelNombreRegistro.insets = new Insets(0, 0, 20, 5);
		gbc_labelNombreRegistro.gridx = 0;
		gbc_labelNombreRegistro.gridy = 1;
		panelPersona.add(labelNombreRegistro, gbc_labelNombreRegistro);
		labelNombreRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoNombreRegistro = new JTextField();
		campoNombreRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_campoNombreRegistro = new GridBagConstraints();
		gbc_campoNombreRegistro.fill = GridBagConstraints.BOTH;
		gbc_campoNombreRegistro.insets = new Insets(0, 0, 20, 0);
		gbc_campoNombreRegistro.gridx = 1;
		gbc_campoNombreRegistro.gridy = 1;
		panelPersona.add(campoNombreRegistro, gbc_campoNombreRegistro);
		campoNombreRegistro.setColumns(10);
		
		JLabel labelTelefonoRegistro = new JLabel("Teléfono");
		labelTelefonoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelTelefonoRegistro = new GridBagConstraints();
		gbc_labelTelefonoRegistro.fill = GridBagConstraints.BOTH;
		gbc_labelTelefonoRegistro.insets = new Insets(0, 0, 20, 5);
		gbc_labelTelefonoRegistro.gridx = 0;
		gbc_labelTelefonoRegistro.gridy = 2;
		panelPersona.add(labelTelefonoRegistro, gbc_labelTelefonoRegistro);
		labelTelefonoRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoTelefonoRegistro = new JTextField();
		campoTelefonoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_campoTelefonoRegistro = new GridBagConstraints();
		gbc_campoTelefonoRegistro.fill = GridBagConstraints.BOTH;
		gbc_campoTelefonoRegistro.insets = new Insets(0, 0, 20, 0);
		gbc_campoTelefonoRegistro.gridx = 1;
		gbc_campoTelefonoRegistro.gridy = 2;
		panelPersona.add(campoTelefonoRegistro, gbc_campoTelefonoRegistro);
		campoTelefonoRegistro.setColumns(10);
		
		JLabel labelContraseñaRegistro = new JLabel("Contraseña");
		labelContraseñaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelContraseñaRegistro = new GridBagConstraints();
		gbc_labelContraseñaRegistro.fill = GridBagConstraints.BOTH;
		gbc_labelContraseñaRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseñaRegistro.gridx = 0;
		gbc_labelContraseñaRegistro.gridy = 3;
		panelPersona.add(labelContraseñaRegistro, gbc_labelContraseñaRegistro);
		labelContraseñaRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoContraseñaRegistro = new JPasswordField();
		campoContraseñaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_campoContraseñaRegistro = new GridBagConstraints();
		gbc_campoContraseñaRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_campoContraseñaRegistro.fill = GridBagConstraints.BOTH;
		gbc_campoContraseñaRegistro.gridx = 1;
		gbc_campoContraseñaRegistro.gridy = 3;
		panelPersona.add(campoContraseñaRegistro, gbc_campoContraseñaRegistro);
		
		JLabel labelNickRegistro = new JLabel("Nick");
		labelNickRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelNickRegistro = new GridBagConstraints();
		gbc_labelNickRegistro.fill = GridBagConstraints.BOTH;
		gbc_labelNickRegistro.insets = new Insets(20, 0, 20, 5);
		gbc_labelNickRegistro.gridx = 0;
		gbc_labelNickRegistro.gridy = 4;
		panelPersona.add(labelNickRegistro, gbc_labelNickRegistro);
		labelNickRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoNickRegistro = new JTextField();
		campoNickRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_campoNickRegistro = new GridBagConstraints();
		gbc_campoNickRegistro.fill = GridBagConstraints.BOTH;
		gbc_campoNickRegistro.insets = new Insets(20, 0, 20, 0);
		gbc_campoNickRegistro.gridx = 1;
		gbc_campoNickRegistro.gridy = 4;
		panelPersona.add(campoNickRegistro, gbc_campoNickRegistro);
		campoNickRegistro.setColumns(10);
		
		JLabel labelApellidosRegistro = new JLabel("Apellidos");
		GridBagConstraints gbc_labelApellidosRegistro = new GridBagConstraints();
		gbc_labelApellidosRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_labelApellidosRegistro.gridx = 0;
		gbc_labelApellidosRegistro.gridy = 5;
		panelPersona.add(labelApellidosRegistro, gbc_labelApellidosRegistro);
		labelApellidosRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		labelApellidosRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		campoApellidosRegistro = new JTextField();
		GridBagConstraints gbc_campoApellidosRegistro = new GridBagConstraints();
		gbc_campoApellidosRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApellidosRegistro.gridx = 1;
		gbc_campoApellidosRegistro.gridy = 5;
		panelPersona.add(campoApellidosRegistro, gbc_campoApellidosRegistro);
		campoApellidosRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		campoApellidosRegistro.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 180, 104));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{369, 123, 0};
		gbl_panel.rowHeights = new int[]{33, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton botonRegistrarseRegistro = new JButton("Regístrarse");
		GridBagConstraints gbc_botonRegistrarseRegistro = new GridBagConstraints();
		gbc_botonRegistrarseRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistrarseRegistro.gridwidth = 2;
		gbc_botonRegistrarseRegistro.anchor = GridBagConstraints.NORTH;
		gbc_botonRegistrarseRegistro.insets = new Insets(40, 0, 5, 0);
		gbc_botonRegistrarseRegistro.gridx = 0;
		gbc_botonRegistrarseRegistro.gridy = 0;
		panel.add(botonRegistrarseRegistro, gbc_botonRegistrarseRegistro);
		botonRegistrarseRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoNombreRegistro.getText().toString();
				String apellidos=campoApellidosRegistro.getText().toString();
				String email=campoEmailRegistro.getText().toString();
				String contraseña=new String(campoContraseñaRegistro.getPassword());
				String nick=campoNickRegistro.getText().toString();
				int telefono=Integer.parseInt(campoTelefonoRegistro.getText());
				if(opcionPersona.isSelected()) {
					new Persona(email, nombre,  apellidos, nick, telefono, contraseña, Tipos.PERSONA);
				}else if(opcionEmpresa.isSelected()) {
					//new empresa
				}else {
					//new admin
				}
				
				JOptionPane.showMessageDialog(ventana, "Registrado correctamente","Éxito",JOptionPane.INFORMATION_MESSAGE);
				ventana.cambiarAPantalla(PantallaLogin.class); 
			}
		});
		botonRegistrarseRegistro.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		botonRegistrarseRegistro.setBackground(new Color(104, 253, 183));
		
		JButton botonLimpiar = new JButton("Limpiar");
		GridBagConstraints gbc_botonLimpiar = new GridBagConstraints();
		gbc_botonLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLimpiar.anchor = GridBagConstraints.NORTH;
		gbc_botonLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_botonLimpiar.gridx = 0;
		gbc_botonLimpiar.gridy = 1;
		panel.add(botonLimpiar, gbc_botonLimpiar);
		botonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoEmailRegistro.setText("");
				campoNombreRegistro.setText("");
				campoApellidosRegistro.setText("");
				campoNickRegistro.setText("");
				campoTelefonoRegistro.setText("");
				campoContraseñaRegistro.setText("");
			}
		});
		botonLimpiar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		botonCancelar.setBackground(new Color(255, 0, 0));
		botonCancelar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.fill = GridBagConstraints.BOTH;
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 1;
		panel.add(botonCancelar, gbc_botonCancelar);
		
	}		
}
