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
    	if(contactos.containsKey(c.getNombre().trim().toLowerCase())) {
    		System.out.println("Ya existe un contacto con ese nombre");
    		return true;
    	}
    	return false;
    }
    
    public void añadirContacto(Contacto c) {
    	
    	if(contactos.size() >= limiteContactos) {
    		System.out.println("La agenda está llena, no puedes agregar más contactos");
    		return;
    	}
    	
    	if(existeContacto(c)) {
    		System.out.println("Ya existe un contacto con ese nombre");
    		return;
    	}
    	
    	if(c.getNombre().trim().isEmpty()) {
    		System.out.println("El nombre no puede estar vacío. Ingresa un nombre:");
    		return;
    	}
    	
    	contactos.put(c.getNombre().trim().toLowerCase(), c);
    	System.out.println("Se agregó correctamente");
    }
    
    public void listarContactos() {
    	for(Contacto c : contactos.values()) {
    		System.out.println(c);
    	}
    }

	
}
