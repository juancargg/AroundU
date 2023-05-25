package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import enums.Categoria;

public class Evento extends CosaConNombre{
	
	public LocalDateTime fecha;
	public Categoria categoria;
	public String descripcion;
	public Foro foro;
	public BufferedImage imagen;
	
	public Evento(String nombre, LocalDateTime fecha, Categoria categoria, String descripcion, Foro foro,
			BufferedImage imagen) {
		super(nombre);
		this.fecha = fecha;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.foro = foro;
		this.imagen = imagen;
	}
	/***
	 * constructor sin imagen por si quieren meter un evento sin ella
	 * @param nombre String con el nombre del evento
	 * @param fecha LocalDateTime con la fecha del evento
	 * @param categoria Enum con la categoria del evento
	 * @param descripcion String para un descripcion del evento
	 * @param foro Foro para los comentarios de los usuarios
	 */
	public Evento(String nombre, LocalDateTime fecha, Categoria categoria, String descripcion, Foro foro) {
		super(nombre);
		this.fecha = fecha;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.foro = foro;
	}
	
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Foro getForo() {
		return foro;
	}
	public void setForo(Foro foro) {
		this.foro = foro;
	}
	public BufferedImage getImagen() {
		return imagen;
	}
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "EVENTO: "+this.getNombre()+"\n\tFecha: " + fecha + "\n\tCategoria: " + categoria 
				+ "\n\tDescripcion: " + descripcion + "Foro: \n\t\t" + foro
				+ "\n" + imagen;
	}
	
	
	
	

}
