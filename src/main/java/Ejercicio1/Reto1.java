package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Reto1 {
	public static void main(String[] args) {

       /* Ejercicio 1
        Escribir un programa Java que le pida al usuario el nombre de un directorio y el nombre de un elemento. CHECK
        Compruebe si el elemento es un fichero que existe en el directorio tecleado por el usuario. Si no existe devuelve un mensaje de error y sale CHECK
        Si el elemento es un directorio debe listar su contenido (comprobar en la API cómo averiguar si es un directorio)CHECK
        Si el elemento es un fichero visualiza la longitud del fichero CHECK
        Si el elemento es un fichero pide al usuario el nombre nuevo y lo renombra. CHECK*/

		Scanner leer = new Scanner(System.in);

		System.out.println("Ingresa el nombre de un directorio");
		String directorio = leer.nextLine();

		System.out.println("Ingresa el nombre de un elemento");
		String elemento = leer.nextLine();

		File directorios = new File(directorio, elemento);
		File ficheroNuevo = new File("HolaMundillo");


		if (directorios.exists()) {
			System.out.println("Esto EXISTE");
			if (directorios.isFile()) {
				System.out.println("La longitudad del elemento es: " + directorios.length());
				if (directorios.renameTo(ficheroNuevo)) {
					System.out.println("Elemento renombrado");
				} else {
					System.out.println("Elemento NO renombrado");
				}

			}
			if (directorios.isDirectory()) {
				System.out.println("Es un directorio");
				File[] ficheros = directorios.listFiles();
				for (File fichero : ficheros) {
					System.out.println(fichero.getName());

				}

			} else {
				System.err.println("No es un directorio");
			}
		} else {
			System.err.println("Esto NO existe");
		}


	}
}
