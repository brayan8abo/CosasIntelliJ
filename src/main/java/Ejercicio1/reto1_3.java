package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class reto1_3 {
//    Escribir un programa Java que le pida al usuario el nombre de un directorio y de un fichero. CHECK
//    Compruebe si el fichero existe dentro del directorio. Si no existe devuelve un mensaje de error y sale. CHECK

//    Listar los subdirectorios del directorio CHECK
//    Listar los ficheros del directorio CHECK

//    Calcular el tamaño total de los ficheros de un directorio
//    Listar los ficheros de un directorio que empiecen por una letra en particular (utilizar el método charAt())

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);

		System.out.println("Ingresa el nombre de un directorio");
		String directorio = leer.nextLine();
		System.out.println("Ingresa el nombre de un fichero");
		String fichero = leer.nextLine();

		File archivos = new File(directorio, fichero);


		File[] subDirectorios = archivos.listFiles();


		if (archivos.exists()) {
			if (archivos.isDirectory()) {
				System.out.println("Es un directorio");
			} else {
				System.err.println("No es un directorio");
			}
			if (archivos.isFile()) {
				System.out.println("Si existen dentro del directorio");
			} else {
				System.err.println("No existe dentro del directorio");
			}
			if (archivos.isDirectory()) {
//				try {
					assert subDirectorios != null;
					for (File subDir : subDirectorios) {
						if (subDir.isDirectory()) {
							System.out.println("Los subdirectorios de este directorio son: " + subDir.getName());
						}
						reto1_3.listarArchivosRecursivo(archivos);

//						if (archivos.isDirectory()) {
//							if (archivos.isFile()) {
//								System.out.println("La suma de todos los ficheros es: " + archivos.length() + archivos.length());
//							}
//						}
					}
//				} catch (NullPointerException e) {
//					throw new NullPointerException();
//				}
			}
		}
	}

	public static void listarArchivosRecursivo(File directorio) {
		if (directorio.isDirectory()) {
			System.out.println("Archivos en el directorio " + directorio.getAbsolutePath() + ":");
			File[] archivos = directorio.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isDirectory()) {
						listarArchivosRecursivo(archivo); // Llamada recursiva si es un directorio
					} else {
						System.out.println(archivo.getName());
					}
				}
			} else {
				System.out.println("El directorio está vacío.");
			}

		}
	}

}



