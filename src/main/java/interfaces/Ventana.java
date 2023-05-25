package interfaces;

import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame{
	private Usuario usuarioLogado;
	
	public Ventana() {
	
			this.setSize(600,500);
			this.setTitle("La mejor app del mundo");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setContentPane(new PantallaLogin(this));
			this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if(clase.equals(PantallaPrincipal.class)) {
			this.setContentPane(new PantallaPrincipal(this));
		}
		this.getContentPane().setVisible(true);
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}//
