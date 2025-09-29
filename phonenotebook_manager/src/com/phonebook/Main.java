package com.phonebook;

public class Main {

	public static void main(String[] args) {
		Contacto contacto = new Contacto("", "123456878");
		Agenda agenda = new Agenda();
		
		agenda.añadirContacto(contacto);

	}

}
