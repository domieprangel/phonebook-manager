package com.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public boolean hayEspacacio() {
	    if (contactos.size() >= limiteContactos) {
	        System.out.println("La agenda está llena, no puedes agregar más contactos");
	        return false;
	    }
	    return true;
	}
	
	public void anadirContacto(Contacto c) {
		String clave = normalizarNombre(c);


	    if (existeContacto(c)) {
	        System.out.println("Ya existe un contacto con ese nombre");
	        return;
	    }

	    if (c.getNombre().trim().isEmpty() ||c.getApellido().trim().isEmpty() || c.getTelefono().trim().isEmpty()) {
	        System.out.println("\nNo se recibio la informacion requerida\n");
	        return;
	    }

	    contactos.put(clave, c);
	    System.out.println("\n~Se agregó correctamente~\n");

	}

	public void listarContactos() {
		 if (!contactos.isEmpty()) {
		        // Convertimos los valores del HashMap a una lista
		        List<Contacto> lista = new ArrayList<>(contactos.values());

		        // Ordenamos por nombre + apellido (ignorando mayúsculas/minúsculas)
		        lista.sort((c1, c2) -> {
		            String nombre1 = c1.getNombre() + " " + c1.getApellido();
		            String nombre2 = c2.getNombre() + " " + c2.getApellido();
		            return nombre1.compareToIgnoreCase(nombre2);
		        });

		        // Usamos el for-each clásico como en tu código original
		        for (Contacto c : lista) {
		            System.out.println(c); // se aprovecha el toString()
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
