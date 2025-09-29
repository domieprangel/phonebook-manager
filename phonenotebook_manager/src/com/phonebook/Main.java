package com.phonebook;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
public class Main {

	public static void main(String[] args) {



		Contacto contacto = new Contacto("Dom Ran", "123456878");
		Contacto contacto2 = new Contacto("Jaime", "123456878");

		Contacto contacto3 = new Contacto("Jen", "123456878");
		Agenda agenda = new Agenda();
		
		agenda.añadirContacto(contacto);
		agenda.añadirContacto(contacto2);
		agenda.añadirContacto(contacto3);
		
		agenda.listarContactos();
		
		agenda.buscaContacto("JaaaimE");

		agenda.modificarTelefono("Dom", "Ran", "123");
		agenda.espaciosLibres();
		System.out.println(contacto);
	

	}
}


