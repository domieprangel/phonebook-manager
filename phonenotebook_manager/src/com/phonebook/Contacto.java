package com.phonebook;

/**
 * Representa un contacto en la agenda telefónica con nombre, apellido y número de teléfono.
 */
public class Contacto {
	private String nombre;
	private String apellido;
	private String telefono;
	
	/**
	 * Constructor por defecto de la clase Contacto.
	 * Inicializa el contacto sin datos.
	 */
	public Contacto() {
		
	}
	
	/**
	 * Constructor que inicializa un contacto con nombre, apellido y teléfono.
	 * @param nombre El nombre del contacto.
	 * @param apellido El apellido del contacto.
	 * @param telefono El número de teléfono del contacto.
	 */
	public Contacto(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	/**
	 * Obtiene el nombre del contacto.
	 * @return El nombre del contacto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del contacto.
	 * @param nombre El nombre a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el número de teléfono del contacto.
	 * @return El número de teléfono.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del contacto.
	 * @param telefono El número de teléfono a establecer.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Obtiene el apellido del contacto.
	 * @return El apellido del contacto.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido del contacto.
	 * @param apellido El apellido a establecer.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Devuelve una representación en cadena del objeto Contacto.
	 * El formato es: Nombre Apellido - Teléfono.
	 * @return Una cadena con los detalles del contacto.
	 */
	@Override
	public String toString() {
		return nombre + " " + apellido + " - " + telefono;
	}
}