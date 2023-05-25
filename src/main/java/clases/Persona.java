package clases;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

import enums.Tipos;
import utils.DAOApp;

public class Persona extends Usuario {
	private HashSet<Evento> eventosDondeAsisto;
	private String nickname;
	private LocalDateTime banHasta;
	private String apellidos;
	
	public Persona(String nombre, int telefono, String email, String contraseña, HashSet<Evento> eventosDondeAsisto,
			String nickname, LocalDateTime banHasta, String apellidos, Tipos tipo) {
		super(nombre, telefono, email, contraseña, tipo);
		this.eventosDondeAsisto = eventosDondeAsisto;
		this.nickname = nickname;
		this.banHasta = banHasta;
		this.apellidos = apellidos;
	}

	public Persona(String email, String nombre, String apellidos, String nickname, int telefono, String contraseña, Tipos tipo) {
		super(nombre, telefono, email, contraseña, tipo);
		new Usuario(nombre, telefono,  email, contraseña, Tipos.PERSONA);
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("email", email);
		columnas.put("apellidos", apellidos);
		columnas.put("nick", nickname);
	
		try {
			DAOApp.insertar("persona", columnas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.apellidos=apellidos;
		this.nickname=nickname;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public HashSet<Evento> getEventosDondeAsisto() {
		return eventosDondeAsisto;
	}
	public void setEventosDondeAsisto(HashSet<Evento> eventosDondeAsisto) {
		this.eventosDondeAsisto = eventosDondeAsisto;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public LocalDateTime getBanHasta() {
		return banHasta;
	}
	public void setBanHasta(LocalDateTime banHasta) {
		this.banHasta = banHasta;
	}
	@Override
	public String toString() {
		return this.getNombre()+"\n\t nickname: "+nickname+"\n\tEventos en los que ha estado: "+ eventosDondeAsisto 
				+ "\n\tBaneado hasta: " + banHasta;
	}
	
}
