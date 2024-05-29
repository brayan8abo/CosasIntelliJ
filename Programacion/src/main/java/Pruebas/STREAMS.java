package Pruebas;

import javax.tools.FileObject;
import java.io.*;
import java.util.Scanner;

public class STREAMS {
	public static void main(String[] args) throws IOException {

		leer("C://dir1/leer.txt");
		escribirBinario();


	}

	public static void leer(String ruta) throws IOException {
		try {
			FileReader fr = new FileReader(ruta);
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void escribirBinario() {
		String ruta = "C://dir1/leer.txt";


		try {

			FileOutputStream fos = new FileOutputStream(ruta); // escoger el fichero
			DataOutputStream dos = new DataOutputStream(fos); // escribir en el fichero

			dos.writeInt(4451444);


			fos.close();

		} catch (IOException e) {
			throw new RuntimeException(e);

		}
	}
}