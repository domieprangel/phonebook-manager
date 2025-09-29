package com.phonebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda contactos = new Agenda();
		int numMenu = 0;
		String nombre;
		String apellido;
		String telefono;
		do {
			System.out.println("MENÚ DE AGENDA TELEFÓNICA");
			System.out.println("1. Agregar contacto nuevo");
			System.out.println("2. Buscar contacto");
			System.out.println("3. Mostrar contactos guardados");
			System.out.println("4. Modificar teléfono de contacto");
			System.out.println("5. Eliminar contacto");
			System.out.println("6. Salir del menú");
			System.out.print("Escribe el número de la acción que deseas realizar: ");
			numMenu = sc.nextInt();	
			sc.nextLine();
			switch (numMenu) {
			case 1:
				System.out.println("Nombre: ");
				nombre = sc.nextLine();
				System.out.println("Apellido: ");
				apellido = sc.nextLine();
				System.out.println("Teléfono: ");
				telefono = sc.nextLine();
				Contacto contactoNuevo = new Contacto(nombre, apellido, telefono);
				contactos.añadirContacto(contactoNuevo);
				break;
			case 2:
				System.out.println("Nombre: ");
				nombre = sc.nextLine();
				System.out.println("Apellido: ");
				apellido = sc.nextLine();
				contactos.buscaContacto(nombre,apellido);
				break;
			}
			
			System.out.print("Escribe el número de la acción que deseas realizar: ");
			numMenu = sc.nextInt();	
		}while(numMenu != 6);
		System.out.println("Saliste de tu Agenda Telefónica");
		
	
	}
}
