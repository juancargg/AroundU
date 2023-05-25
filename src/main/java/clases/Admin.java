package clases;

import enums.Tipos;
import excepciones.ClienteNoEncontradoException;
import excepciones.ContraseñaErroneaException;

public class Admin extends Usuario{

	public Admin(String nombre, int telefono, String email, String contraseña, Tipos tipo) {
		super(nombre, telefono, email, contraseña, tipo);
		
	}

	public Admin(String email, String contraseña) throws ClienteNoEncontradoException, ContraseñaErroneaException {
		super(email, contraseña);
		// TODO Auto-generated constructor stub
	}
	
}
