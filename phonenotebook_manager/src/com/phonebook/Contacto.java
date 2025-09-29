package com.phonebook;

public class Contacto {
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Contacto() {
		
	}
	
	public Contacto(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " - " + telefono;
	}
}
