package com.phonebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Agenda contactos = new Agenda(2);
		int numMenu = 0;
		String nombre;
		String apellido;
		String telefono;
		do {
			System.out.println("===============================");
			System.out.println("MENÚ DE AGENDA TELEFÓNICA");
			System.out.println("===============================");
			System.out.println("1. Agregar contacto nuevo");
			System.out.println("2. Buscar contacto");
			System.out.println("3. Mostrar contactos guardados");
			System.out.println("4. Modificar teléfono de contacto");
			System.out.println("5. Eliminar contacto");
			System.out.println("6. Salir del menú");
			System.out.println("===============================");
			System.out.print("Escribe el número de la acción que deseas realizar: ");
			numMenu = sc.nextInt();
			sc.nextLine();
			switch (numMenu) {
			case 1:
				if(contactos.hayEspacacio()) {
					System.out.print("Nombre: ");
					nombre = sc.nextLine();
					System.out.print("Apellido: ");
					apellido = sc.nextLine();
					System.out.print("Teléfono: ");
					telefono = sc.nextLine();
					Contacto contactoNuevo = new Contacto(nombre, apellido, telefono);
					contactos.anadirContacto(contactoNuevo);
				}
				
				break;
			case 2:
				System.out.print("Nombre: ");
				nombre = sc.nextLine();
				System.out.print("Apellido: ");
				apellido = sc.nextLine();
				contactos.buscaContacto(nombre,apellido);
				break;
			case 3:
				contactos.listarContactos();
				break;
			case 4:
				System.out.print("Nombre: ");
				nombre = sc.nextLine();
				System.out.print("Apellido: ");
				apellido = sc.nextLine();
				System.out.print("Teléfono Nuevo: ");
				telefono = sc.nextLine();
				contactos.modificarTelefono(nombre, apellido, telefono);
				break;
			case 5:
				System.out.print("Nombre: ");
				nombre = sc.nextLine();
				System.out.print("Apellido: ");
				apellido = sc.nextLine();
				contactos.eliminarContacto(nombre, apellido);
				break;
			default:
				System.out.println("Opción inválida.");
			}
		}while(numMenu != 6);
		System.out.println("Saliste de tu Agenda Telefónica");
		sc.close();

		
	
	}
}
