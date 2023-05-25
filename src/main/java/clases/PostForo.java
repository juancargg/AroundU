package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostForo extends Mensaje{
	private String titulo;
	private ArrayList<Respuesta> respuestas;
	
	public PostForo(Usuario autor, String mensaje, LocalDateTime fecha, String titulo,
			ArrayList<Respuesta> respuestas) {
		super(autor, mensaje, fecha);
		this.titulo = titulo;
		this.respuestas = respuestas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "PostForo [titulo=" + titulo + ", respuestas=" + respuestas + "]";
	}
	
	
	
}
