package excepciones;

public class ContraseñaErroneaException extends Exception {
	public ContraseñaErroneaException(String mensaje) {
		super(mensaje);
	}
}
