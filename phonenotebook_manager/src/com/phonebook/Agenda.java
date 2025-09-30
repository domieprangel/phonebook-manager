package com.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa una agenda telefónica que almacena objetos Contacto.
 * Utiliza un HashMap para almacenar los contactos, donde la clave es el nombre 
 * y apellido normalizado (minúsculas, sin espacios extra).
 */
public class Agenda {
	private Map<String, Contacto> contactos;
	private int limiteContactos;

	/**
	 * Constructor por defecto. Inicializa la agenda con un límite de 10 contactos.
	 */
	public Agenda() {
		this(10);
	}

	/**
	 * Constructor que permite especificar el límite de contactos.
	 * @param limiteContactos El número máximo de contactos que puede almacenar la agenda.
	 */
	public Agenda(int limiteContactos) {
		this.limiteContactos = limiteContactos;
		this.contactos = new HashMap<>();
	}

	/**
	 * Verifica si un contacto ya existe en la agenda, basándose en su nombre y apellido.
	 * @param c El objeto Contacto a verificar.
	 * @return true si el contacto ya existe, false en caso contrario.
	 */
	public boolean existeContacto(Contacto c) {
	    String clave = normalizarNombre(c);
	    return contactos.containsKey(clave);
	}

	/**
	 * Verifica si hay espacio disponible para añadir un nuevo contacto.
	 * @return true si la agenda no ha alcanzado su límite, false si está llena.
	 */
	public boolean hayEspacacio() {
	    if (contactos.size() >= limiteContactos) {
	        System.out.println("La agenda está llena, no puedes agregar más contactos");
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Añade un contacto a la agenda si hay espacio y no existe previamente.
	 * Imprime mensajes de estado si el contacto ya existe, faltan datos, o se añade correctamente.
	 * @param c El objeto Contacto a añadir.
	 */
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

	/**
	 * Muestra por consola todos los contactos guardados en la agenda.
	 * Los contactos se listan ordenados alfabéticamente por nombre y apellido.
	 * Si la agenda está vacía, imprime un mensaje.
	 */
	public void listarContactos() {
		 if (!contactos.isEmpty()) {
		        // Convertimos los valores del HashMap a una lista para poder ordenarlos
		        List<Contacto> lista = new ArrayList<>(contactos.values());

		        // Ordenamos por nombre + apellido (ignorando mayúsculas/minúsculas)
		        lista.sort((c1, c2) -> {
		            String nombre1 = c1.getNombre() + " " + c1.getApellido();
		            String nombre2 = c2.getNombre() + " " + c2.getApellido();
		            return nombre1.compareToIgnoreCase(nombre2);
		        });

		        // Imprimimos cada contacto usando su método toString()
		        for (Contacto c : lista) {
		            System.out.println(c);
		        }
		    } else {
		        System.out.println("No hay contactos registrados");
		    }
	}
	
    /**
     * Normaliza el nombre y apellido para usarlo como clave en el mapa (minúsculas y sin espacios extra).
     * @param nombre El nombre del contacto.
     * @param apellido El apellido del contacto.
     * @return La clave normalizada.
     */
    private String normalizarNombre(String nombre, String apellido) {
        return (nombre.trim() + " " + apellido.trim()).toLowerCase();
    }

	/**
	 * Normaliza el nombre y apellido de un objeto Contacto para usarlo como clave.
	 * @param c El objeto Contacto.
	 * @return La clave normalizada.
	 */
	private String normalizarNombre(Contacto c) {
		return normalizarNombre(c.getNombre(), c.getApellido());
	}

	/**
	 * Busca un contacto en la agenda por nombre y apellido e imprime su teléfono.
	 * @param nombre El nombre del contacto a buscar.
	 * @param apellido El apellido del contacto a buscar.
	 */
	public void buscaContacto(String nombre, String apellido) {
		String clave = normalizarNombre(nombre, apellido);
	    Contacto contacto = contactos.get(clave);
	    if (contacto != null) {
	        System.out.println("Teléfono de " + contacto.getNombre() + " " + contacto.getApellido() + ": " + contacto.getTelefono());
	    } else {
	        System.out.println("No se encontró el contacto de " + nombre + " " + apellido);
	    }
	}

	/**
	 * Modifica el número de teléfono de un contacto existente.
	 * @param nombre El nombre del contacto.
	 * @param apellido El apellido del contacto.
	 * @param nuevoTelefono El nuevo número de teléfono a asignar.
	 */
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
	
	/**
	 * Imprime el número de espacios libres restantes en la agenda.
	 */
	public void espaciosLibres() {
        int libres = limiteContactos - contactos.size();
        System.out.println("Espacios libres en la agenda: " + libres);
    }

    /**
     * Elimina un contacto de la agenda utilizando su nombre y apellido.
     * @param nombre El nombre del contacto a eliminar.
     * @param apellido El apellido del contacto a eliminar.
     */
    public void eliminarContacto(String nombre, String apellido) {
    	String clave = normalizarNombre(nombre, apellido);
    	if (contactos.remove(clave) != null) {
    		System.out.println("Contacto: " + nombre + " " + apellido + " eliminado exitosamente.");
    	} else {
    		System.out.println("No se encontró ningún contacto con el nombre " + nombre + " " + apellido);
    	}
    	
    }
}