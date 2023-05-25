package clases;

import java.time.LocalDateTime;

public class Mensaje {
	private Usuario autor;
	private String mensaje;
	private LocalDateTime fecha;
	
	public Mensaje(Usuario autor, String mensaje, LocalDateTime fecha) {
		super();
		this.autor = autor;
		this.mensaje = mensaje;
		this.fecha = fecha;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Mensaje de " + autor + ":\n\t" + mensaje + "\n\tFecha: " + fecha;
	}
	
	
	
}
