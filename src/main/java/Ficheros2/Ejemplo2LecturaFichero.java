package Ficheros2;

import java.io.FileReader;
import java.io.IOException;

public class Ejemplo2LecturaFichero {
    public static void main(String[] args) {
        leer();


    }

    public static void leer() {
        try (FileReader entrada = new FileReader("C:/nuevo/pruebas.txt")) {
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        System.out.print((char) c);
                    }
                    entrada.close();
                } while (c != -1); // -1 cuando llega al final del fichero
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

