package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class reto1 {
	public static void main(String[] args) {
//	Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado “invertido.txt”, en el que se guardarán las frases del primero pero invertidas.
//	Mostrar en pantalla el nuevo fichero.
//	Ejemplo: texto.txt Esto es un ejemplo
//	invertido.txt olpmeje nu se otsE


		String textoEntrada = "texto.txt";
		String textoSalida = "invertido.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(textoEntrada));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(textoSalida))) {

			String line;
			while ((line = reader.readLine()) != null) {
				String[] palabras = line.split(" ");
				StringBuilder invertedLine = new StringBuilder();
				for (int i = palabras.length - 1; i >= 0; i--) {
					invertedLine.append(palabras[i]).append(" ");
				}
				writer.write(invertedLine.toString().trim());
				writer.newLine();
			}

			System.out.println("Contenido de " + textoSalida + ":");
			try (BufferedReader invertedReader = new BufferedReader(new FileReader(textoSalida))) {
				String invertedLine;
				while ((invertedLine = invertedReader.readLine()) != null) {
					System.out.println(invertedLine);
				}
			}

		} catch (IOException e) {
			System.err.println("Error al procesar los archivos: " + e.getMessage());
		}
	}
}

