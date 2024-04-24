package ficheros.Ejercicios2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reemplazar {
    public static void main(String[] args) {
        String direccion = "C:\\dir1\\buffered.txt";
        String contenidoModificado = leer(direccion);
        escribir(contenidoModificado, direccion);
    }

	public static String leer(String direccion) {
		StringBuilder SB = new StringBuilder();
		FileReader entrada = null;

		try {
			entrada = new FileReader(direccion);
			int c;
			while ((c = entrada.read()) != -1) {
				if (c == 'a' || c == 'e' || c == 'o' || c == 'u') {
					SB.append('*');
				} else {
					SB.append((char) c);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return SB.toString();
	}

	public static void escribir(String contenido, String direccion) {
		FileWriter salida = null;

		try {
			salida = new FileWriter(direccion);
			salida.write(contenido);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

