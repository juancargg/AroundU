package clases;

import java.util.HashSet;

import enums.Tipos;

public class Empresa extends Usuario{
	HashSet<Evento>eventosCreados;

	public Empresa(String nombre, int telefono, String email,String contraseña,
			Tipos tipo,  HashSet<Evento> eventosCreados) {
		super(nombre, telefono, email, contraseña, tipo);
		this.eventosCreados = eventosCreados;
	}

	public HashSet<Evento> getEventosCreados() {
		return eventosCreados;
	}

	public void setEventosCreados(HashSet<Evento> eventosCreados) {
		this.eventosCreados = eventosCreados;
	}

	@Override
	public String toString() {
		return this.getNombre() +"\n\tEventos creados: \n\t"+ eventosCreados +"\n\t";
	}
	
}
