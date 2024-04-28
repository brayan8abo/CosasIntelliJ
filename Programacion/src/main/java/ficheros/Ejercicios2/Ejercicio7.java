package ficheros.Ejercicios2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*Ejercicio 7.-

        Escribir un programa que encripte el fichero de texto “texto.txt” generando un fichero de salida con los datos encriptados.

        La encriptación consiste en reemplazar cada carácter por el tercero siguiente en el alfabeto (ej. a -> d).
        Si el carácter es la x/y/z entonces se sustituirá por la a/b/c.

        Mostrar el fichero resultante.*/
public class Ejercicio7 {

	public static void main(String[] args) {


		escribir(leer("C:\\dir1\\texto.txt"));


	}

	public static String leer(String ruta) {
		String nuevo = "";
		FileReader entrada = null;
		String añadir = "";
		ArrayList<Character> caracteres = new ArrayList<>();
		try {
			entrada = new FileReader(ruta);
			try {
				int c;
				char j;
				do {
					c = entrada.read();
					j = (char) c;
					if (c != -1) {

						//System.out.println(j);
						if (j == 'x') {
							nuevo += ('a');
						} else if (j == 'y') {
							nuevo += ('b');
						} else if (j == 'z') {
							nuevo += ('c');
						} else if (j == ' ') {
							nuevo += ' ';
						} else if (j == '\n') {
							nuevo += '\n';
						} else {
							nuevo += ((char) (j + 3));
						}


					}

				} while (c != -1);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
        /*System.out.println("ARRAY");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }*/

		return nuevo;
	}

	public static void escribir(String cadena) {


		FileWriter escribiendo = null;
		try {
			escribiendo = new FileWriter("C:\\dir1\\encriptado.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		try {
			escribiendo.write(cadena);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		try {
			escribiendo.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}


}

