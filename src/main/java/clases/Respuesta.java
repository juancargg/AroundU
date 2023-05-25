package clases;

import java.time.LocalDateTime;

public class Respuesta extends Mensaje{

	public Respuesta(Usuario autor, String mensaje, LocalDateTime fecha) {
		super(autor, mensaje, fecha);
		
	}

	@Override
	public String toString() {
		return "Respuesta []";
	}

	
	
}
