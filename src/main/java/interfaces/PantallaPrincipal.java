package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class PantallaPrincipal extends JPanel{
	private Ventana ventana;
	public PantallaPrincipal(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelBienvenido = new JLabel("Bienvenid@, "+ventana.getUsuarioLogado().getNombre());
		add(labelBienvenido, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JScrollBar scrollBar = new JScrollBar();
		add(scrollBar, BorderLayout.CENTER);
	}
	
}
