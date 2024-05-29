package Pruebas;

import java.io.*;

public class EscribirFichero {
	public static void main(String[] args) {


		String mensaje = "Esta frase es un prueba para la ordinaria";


		String MensajeLeido = "";

		String ruta = "C://dir1/prueba1.txt";


		String mensajeLeido;
		try {
			FileWriter fw = new FileWriter(ruta); // escribir
			fw.write(mensaje);
			fw.close();

//			FileReader fr = new FileReader(ruta); // leer
//			int c;
//			while ((c = fr.read()) != -1) {
//				MensajeLeido += (char) c;
//			}
//			System.out.println(MensajeLeido);
//			fr.close();

			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr); // almacenamos y leemos de la ruta
			mensajeLeido = br.readLine();


		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("El mensaje guardado es: " + mensajeLeido);

	}
}
