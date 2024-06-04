package ficheros.VERSION2;

import javax.swing.*;
import java.io.*;

public class Letras {
//	3) Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (solo la ruta, sin fichero al final).
//	Debes copiar el contenido de los dos ficheros en uno, este tendrá el nombre de los dos ficheros separados por un guion bajo, este se guardara en la ruta donde le hayamos indicado por teclado.
//	Para unir los ficheros en uno, crea un método donde le pases como parámetro todas las rutas. En este método,
//	aparte de copiar debe comprobar que si existe el fichero de destino, nos muestre un mensaje informándonos de si queremos sobrescribir el fichero. Te recomiendo usar la clase File y JOptionPane.
//	Por ejemplo, si tengo un fichero A.txt con «ABC» como contenido, un fichero B.txt con «DEF» y una ruta de destino D:\, el resultado sera un fichero llamado A_B.txt en la ruta D:\ con el contenido «ABCDEF».
//	Puedes crear submétodos para realizar la copia de ficheros, piensa también como podrias optimizar esta copia, si los ficheros tuvieran mucho contenido.
//	Recuerda que debes controlar las excepciones que puedan aparecer. En caso de error, mostrar una ventana de dialogo con información del error.
public static void main(String[] args) {

	//Introducimos los datos
	String rutaFichero1= JOptionPane.showInputDialog("Indica la ruta del primer fichero");
	String rutaFichero2=JOptionPane.showInputDialog("Indica la ruta del segundo fichero");
	String rutaDestino=JOptionPane.showInputDialog("Indica la ruta donde quieres guardarlo");

	//Creamos dos objetos File para que nos sea mas sencillo manejarlos
	File fichero1=new File(rutaFichero1);
	File fichero2=new File(rutaFichero2);

	//Troceamos el el nombre del primer fichero para que se quede sin extension
	String primerFichero=fichero1.getName().substring(0, fichero1.getName().length()-4);

	//Crear el nombre de salida del fichero
	String nombreFicheroFinal=primerFichero+"_"+fichero2.getName();

	rutaDestino+=nombreFicheroFinal;

	File destino=new File(rutaDestino);

	UneFicheros(fichero1, fichero2, destino);

}

	public static void UneFicheros (File fich1, File fich2, File destino){

		try (BufferedReader br=new BufferedReader(new FileReader(fich1));
			 BufferedReader br2=new BufferedReader(new FileReader(fich2))){

			int eleccion=-1;

			if(destino.exists()){
				eleccion=JOptionPane.showConfirmDialog(null, "El fichero ya existe, ¿Quieres sobrescribir el fichero "+destino.getName()+"?",
						"Sobrescribir",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
			if(eleccion!=JOptionPane.CANCEL_OPTION){

				/*
				 * Lo creamos aquí, ya que si lo hacemos arriba
				 * siempre existira porque se crea al abrir el Stream
				 */

				BufferedWriter bw=new BufferedWriter(new FileWriter(destino));

				//Copiamos el contenido al fichero destino
				copiar(bw, br);
				copiar(bw, br2);

			}
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private static void copiar(BufferedWriter bw, BufferedReader br) throws IOException{

		String linea=br.readLine();
		while(linea!=null){

			bw.write(linea);

			linea=br.readLine();
		}

	}
}




