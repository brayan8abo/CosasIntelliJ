package Ejercicios2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Contar {


	public static void main(String[] args) {
		int lineas = 0;
		int caracteres = 0;
		int palabras = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingresa un directorio: ");
		String Ruta = scanner.nextLine();
		File file = new File(Ruta);

		if (!file.exists() || file.isDirectory()) {
			System.out.println("El archivo no existe, o es un directorio");
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String texto;
			while ((texto = reader.readLine()) != null) {
				lineas++;
				caracteres += texto.length();
				palabras += contar(texto);
			}

			System.out.println("Numero de lineas: " + lineas);
			System.out.println("Numero de caracteres: " + caracteres);
			System.out.println("Numero de palabras: " + palabras);

			scanner.close();
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

	}

	private static int contar(String lineas) {
		int palabras = 0;
		boolean isPalabra = false;
		int length = lineas.length();

		for (int i = 0; i < length; i++) {
			if (Character.isLetterOrDigit(lineas.charAt(i))) {
				if (!isPalabra) {
					isPalabra = true;
					palabras++;
				}
			} else {
				isPalabra = false;
			}
		}
		return palabras;
	}

}