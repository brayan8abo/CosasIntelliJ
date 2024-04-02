package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class reto1_2 {
//	Ejercicio 2
//	Escribir un programa Java que le pida al usuario el nombre de un fichero y el nombre de un directorio. CHECK
//	Compruebe si el fichero existe. Si no existe devuelve un mensaje de error y sale. CHECK

//	Comprueba si se puede leer y si se puede escribir en él
//	Visualiza la longitud del fichero
//	Borra el fichero

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);

		System.out.println("Ingresa el nombre de un fichero");
		String fichero = leer.nextLine();
		System.out.println("Ingresa el nombre de un directorio");
		String directorio = leer.nextLine();

		File files = new File(directorio, fichero);

		if (files.exists()) {
			if (files.isFile()) {
				System.out.println("El fichero SÍ existe");
			} else {
				System.err.println("NO EXISTE");
			}
			if (files.canRead()) {
				System.out.println("SÍ se puede leer");
			} else {
				System.err.println("NO puede ser leido");
			}
			if (files.canWrite()){
				System.out.println("Se puede escribir aquí");
			} else {
				System.err.println("NO se puede escribir");
			}
		}

	}
}

