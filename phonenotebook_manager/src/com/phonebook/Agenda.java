package com.phonebook;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
	private Map<String, Contacto> contactos;
	private int limiteContactos;

	public Agenda() {
		this(10);
	}

	public Agenda(int limiteContactos) {
		this.limiteContactos = limiteContactos;
		this.contactos = new HashMap<>();
	}

	public boolean existeContacto(Contacto c) {
		if (contactos.containsKey(c.getNombre().trim().toLowerCase())) {
			return true;
		}
		return false;
	}

	public void añadirContacto(Contacto c) {

		if (contactos.size() >= limiteContactos) {
			System.out.println("La agenda está llena, no puedes agregar más contactos");
			return;
		}

		if (existeContacto(c)) {
			System.out.println("Ya existe un contacto con ese nombre");
			return;
		}

		if (normalizarNombre(c.getNombre()).isEmpty()) {
			System.out.println("El nombre no puede estar vacío. Ingresa un nombre:");
			return;
		}

		contactos.put(c);
		System.out.println("Se agregó correctamente");
	}

	public void listarContactos() {
		if (!contactos.isEmpty()) {
			for (Contacto c : contactos.values()) {
				System.out.println(c);
			}
		} else {
			System.out.println("No hay contactos registrados");
		}
	}

	private String normalizarNombre(Contacto c) {
		return (c.getNombre().trim() + c.getApellido().trim()).toLowerCase();
	}

	public void buscaContacto(String nombre) {
		Contacto contacto = contactos.get(normalizarNombre(nombre));
		if (contacto != null) {
			System.out.println("Telefono de " + contacto.getNombre() + ": " + contacto.getTelefono());
		} else {
			System.out.println("No se encontro el contacto de " + nombre);
		}

	}

	public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
		String nombreCompleto = nombre + " " + apellido;
		Contacto c = contactos.get(normalizarNombre(nombreCompleto));
		if (c != null) {
			c.setTelefono(nuevoTelefono);
			System.out.println("Teléfono actualizado correctamente.");
		} else {
			System.out.println("No existe un contacto con ese nombre.");
		}
	}
	
	public void espaciosLibres() {
        int libres = limiteContactos - contactos.size();
        System.out.println("Espacios libres en la agenda: " + libres);
    }

    //Eliminar contacto
    public void eliminarContacto(String nombre) {
    	if (contactos.remove(nombre) != null) {
    		System.out.println("Contacto: " + nombre + "eliminado de la lista exitosamente.");
    	} else {
    		System.out.println("No se encontró ningún contacto con el nombre " + nombre + ", nada fue eliminado.");
    	}
    	
    }
    
}
