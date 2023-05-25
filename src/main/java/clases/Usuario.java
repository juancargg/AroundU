package clases;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashSet;

import enums.Tipos;
import excepciones.ClienteNoEncontradoException;
import excepciones.ContraseñaErroneaException;
import utils.DAOApp;

public class Usuario extends CosaConNombre{
	private int telefono;
	private String email;
	private String contraseña;
	private Tipos tipo;
	
	public Usuario(String nombre, int telefono, String email, String contraseña, Tipos tipo) {
		super(nombre);
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("email", email);
		columnas.put("password", contraseña);
		columnas.put("nombre", nombre);
		columnas.put("telefono", telefono);
		columnas.put("tipo", ""+tipo+"");
		try {
			DAOApp.insertar("usuario", columnas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.telefono = telefono;
		this.email = email;
		this.contraseña=contraseña;
		this.tipo=tipo;
	}
	
	public Usuario(String email, String contraseña) throws ClienteNoEncontradoException, ContraseñaErroneaException {
		LinkedHashSet<String> columnaBusqueda = new LinkedHashSet<String>();
		columnaBusqueda.add("email");
		columnaBusqueda.add("nombre");
		columnaBusqueda.add("telefono");
		columnaBusqueda.add("password");
		
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("email", email);
		
		try {
			if (DAOApp.consultar("usuario", columnaBusqueda, restricciones).isEmpty()) {
				throw new ClienteNoEncontradoException("El email no está registrado");
			} else {
				restricciones.put("password", contraseña);
				if (DAOApp.consultar("usuario", columnaBusqueda, restricciones).isEmpty()) {
					throw new ContraseñaErroneaException("La contraseña es incorrecta");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			this.email=(String) DAOApp.consultar("usuario", columnaBusqueda, restricciones).get(0);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.nombre=(String) DAOApp.consultar("usuario", columnaBusqueda, restricciones).get(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.telefono=(Integer) DAOApp.consultar("usuario", columnaBusqueda, restricciones).get(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Usuario: "+this.getNombre() +"\n\tTelefono: "+ telefono + "\n\tEmail: " + email+"\n\tTipo: "+tipo;
	}
	
	
	
}
