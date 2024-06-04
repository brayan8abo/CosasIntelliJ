package ficheros.VERSION2;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraMins {
//	2) Crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que queramos a escribir en el fichero.
//	Deberás mostrar por pantalla el mismo texto pero variando entre mayúsculas y minúsculas, es decir, si escribo «Bienvenido» deberá devolver «bIENVENIDO».
//	Si se escribe cualquier otro carácter, se quedara tal y como se escribió.
//	Deberás crear un método para escribir en el fichero el texto introducido y otro para mostrar el contenido en mayúsculas.
//	IMPORTANTE: cuando pidas por teclado una ruta con JOptionPane, no es necesario que insertes caracteres de escape.

	public static void main(String[] args) {

		String ruta= JOptionPane.showInputDialog("Introduce la ruta del fichero");
		String texto=JOptionPane.showInputDialog("Introduce el texto que quieras escribir en el fichero");
		escribirFichero(ruta, texto);

		mostrarFicheroMay(ruta);

	}

	public static void escribirFichero(String nomFich, String texto){
		try(FileWriter fw=new FileWriter(nomFich);){

			//Escribimos el texto en el fichero
			fw.write(texto);

		}catch(IOException e){
			System.out.println("Problemas en la escritura E/S "+e);
		}
	}

	public static void mostrarFicheroMay(String nomFich){
		try(FileReader fr=new FileReader (nomFich)){

			int valor=fr.read();

			while(valor!=-1){

				//Solo cambiara el caracter si es una minuscula o una mayuscula
				char caracter=(char)valor;
				if(caracter>=97 && caracter<=122){
					caracter-=32;
				}else if(caracter>=65 && caracter<=90){
					caracter+=32;
				}
				System.out.print(caracter);
				valor=fr.read();
			}

		}catch(IOException e){
			System.out.println("Problema con la E/S "+e);
		}
	}

}

