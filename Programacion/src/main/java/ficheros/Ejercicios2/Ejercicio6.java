package ficheros.Ejercicios2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class Ejercicio6 {

	public static void main(String[] args) {



		escribir(leer("C:\\dir1\\numeros.txt"));


	}

	public static String leer(String ruta) {
		String retorno = "";
		FileReader entrada = null;
		String nuevo = "";
		ArrayList<Character> numeros = new ArrayList<>();
		try {
			entrada = new FileReader(ruta);
			try {
				int c;
				char j;
				do {
					c = entrada.read();
					j = (char) c;
					if (c != -1) {
						if (isDigit(j)) {
							//System.out.println(j);
							numeros.add(j);
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
		int cero = 0, uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0, seis = 0, siete = 0, ocho = 0, nueve = 0;
		double suma = 0.0;
		String string = "";
		int moda = 0;
		for (int i = 0; i < numeros.size(); i++) {


			if (numeros.get(i) == '0') {
				cero++;
			}
			if (numeros.get(i) == '1') {
				uno++;
			}
			if (numeros.get(i) == '2') {
				dos++;
			}
			if (numeros.get(i) == '3') {
				tres++;
			}
			if (numeros.get(i) == '4') {
				cuatro++;
			}
			if (numeros.get(i) == '5') {
				cinco++;
			}

			if (numeros.get(i) == '6') {
				seis++;
			}
			if (numeros.get(i) == '7') {
				siete++;
			}
			if (numeros.get(i) == '8') {
				ocho++;
			}
			if (numeros.get(i) == '9') {
				nueve++;
			}
			string = String.valueOf(numeros.get(i));
			suma += Double.parseDouble(string);

		}
		ArrayList<Integer> contador = new ArrayList<>();
		contador.add(cero);
		contador.add(uno);
		contador.add(dos);
		contador.add(tres);
		contador.add(cuatro);
		contador.add(cinco);
		contador.add(seis);
		contador.add(siete);
		contador.add(ocho);
		contador.add(nueve);
		for (int i = 0; i < contador.size(); i++) {
			System.out.println(i + "-" + contador.get(i));
		}
		for (int i = 0; i < contador.size(); i++) {

			if (contador.get(i) >= contador.get(moda)) {
				moda = i;
			}

		}
		System.out.println("numero de moda es :");
		System.out.println(moda);
		return "El numero 0 aparece " + cero + " veces\n " +
				"El numero 1 aparece " + uno + " veces\n  " +
				"El numero 2 aparece " + dos + " veces\n  " +
				"El numero 3 aparece " + tres + " veces\n  " +
				"El numero 4 aparece " + cuatro + " veces\n  " +
				"El numero 5 aparece " + cinco + " veces\n  " +
				"El numero 6 aparece " + seis + " veces\n  " +
				"El numero 7 aparece " + siete + " veces\n  " +
				"El numero 8 aparece " + ocho + " veces\n  " +
				"El numero 9 aparece " + nueve + " veces\n  " +
				"El numero de moda es :" + moda + "\n" +
				"La media total de los numeros del archivo es :" + (suma / numeros.size());
	}

	public static void escribir(String cadena) {


		FileWriter escribiendo = null;
		try {
			escribiendo = new FileWriter("C:\\dir1\\estadistica.txt");
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
