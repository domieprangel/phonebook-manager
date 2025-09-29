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
	    String clave = normalizarNombre(c);
	    return contactos.containsKey(clave);
	}

	public void anadirContacto(Contacto c) {
		String clave = normalizarNombre(c);

	    if (contactos.size() >= limiteContactos) {
	        System.out.println("La agenda está llena, no puedes agregar más contactos");
	        return;
	    }

	    if (existeContacto(c)) {
	        System.out.println("Ya existe un contacto con ese nombre");
	        return;
	    }

	    if (c.getNombre().trim().isEmpty() ||c.getApellido().trim().isEmpty() || c.getTelefono().trim().isEmpty()) {
	        System.out.println("El nombre no puede estar vacío. Ingresa un nombre:");
	        return;
	    }

	    contactos.put(clave, c);
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
	
    private String normalizarNombre(String nombre, String apellido) {
        return (nombre.trim() + " " + apellido.trim()).toLowerCase();
    }

	private String normalizarNombre(Contacto c) {
		return normalizarNombre(c.getNombre(), c.getApellido());
	}

	public void buscaContacto(String nombre, String apellido) {
		String clave = normalizarNombre(nombre, apellido);
	    Contacto contacto = contactos.get(clave);
	    if (contacto != null) {
	        System.out.println("Teléfono de " + contacto.getNombre() + " " + contacto.getApellido() + ": " + contacto.getTelefono());
	    } else {
	        System.out.println("No se encontró el contacto de " + nombre + " " + apellido);
	    }
	}

	public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
		String clave = normalizarNombre(nombre, apellido);
	    Contacto c = contactos.get(clave);
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

    public void eliminarContacto(String nombre, String apellido) {
    	String clave = normalizarNombre(nombre, apellido);
    	if (contactos.remove(clave) != null) {
    		System.out.println("Contacto: " + nombre + " " + apellido + " eliminado exitosamente.");
    	} else {
    		System.out.println("No se encontró ningún contacto con el nombre " + nombre + " " + apellido);
    	}
    	
    }
    
}
