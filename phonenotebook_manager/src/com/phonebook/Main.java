package com.phonebook;

import java.util.Scanner;

/**
 * Clase principal que contiene el punto de entrada de la aplicación (método main).
 * Implementa un menú interactivo para gestionar la Agenda de contactos.
 */
public class Main {

	/**
	 * Método principal para ejecutar la aplicación de agenda telefónica.
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Se inicializa la agenda con un límite de 2 contactos para pruebas.
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
			
			// Manejo de la opción del menú
			if (sc.hasNextInt()) {
				numMenu = sc.nextInt();
				sc.nextLine(); // Consumir el salto de línea
			} else {
				System.out.println("Entrada inválida. Por favor, introduce un número.");
				sc.nextLine(); // Consumir la entrada inválida
				numMenu = 0; // Para asegurar que el bucle continúe si la entrada es no numérica
				continue;
			}
			
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
			case 6:
				// Salir del bucle
				break;
			default:
				System.out.println("Opción inválida.");
			}
		}while(numMenu != 6);
		System.out.println("Saliste de tu Agenda Telefónica");
		sc.close();
	}
}