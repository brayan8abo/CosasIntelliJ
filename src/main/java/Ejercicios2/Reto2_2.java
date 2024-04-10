package Ejercicios2;

//Realizar un programa que muestre las n primeras líneas del fichero de texto “texto.txt”.
//El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser mayor que el número de filas del fichero.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reto2_2 {
	public static void main(String[] args) {
		System.out.println(leer("C:\\dir1\\dir2\\dir3\\dir4\\pruebas.txt"));

	}

	public static String leer(String direccion) {
		Scanner leer = new Scanner(System.in);
		StringBuilder SB = new StringBuilder("");
		FileReader entrada = null;
		String nuevo = "";


		System.out.println("Ingresa un número");
		int numero = leer.nextInt();
		try {
			entrada = new FileReader(direccion);
			try {
				int c;
				do {
					c = entrada.read();
					if (c != -1) {
						nuevo += String.valueOf((char)c);
					}
					if (c == '\n') {
						numero--;
					}
				} while (c != -1 && numero != 0);
				SB.append(nuevo);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (
				FileNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		String texto = SB.toString();
		return texto;

	}
}




