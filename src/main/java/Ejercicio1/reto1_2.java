package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class reto1_2 {
//	Ejercicio 2
//	Escribir un programa Java que le pida al usuario el nombre de un fichero y el nombre de un directorio. CHECK

//	Compruebe si el fichero existe. Si no existe devuelve un mensaje de error y sale.
//	Comprueba si se puede leer y si se puede escribir en él
//	Visualiza la longitud del fichero
//	Borra el fichero

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);

		System.out.println("Ingresa el nombre de un fichero");
		String fichero = leer.nextLine();
		System.out.println("Ingresa el nombre de un directorio");
		String directorio = leer.nextLine();

		File files = new File(fichero, directorio);

		if (files.exists()) {
			System.out.println("Existe");
			if (files.isFile()){
				System.out.println("El fichero SÍ existe");
			} else {
				System.err.println("NO EXISTE");
			}
		}
	}
}
