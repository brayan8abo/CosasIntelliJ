package Ficheros2;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo3EscrituraFichero {
    public static void main(String[] args) {
        escribir();

    }
    public static void escribir(){
        String cadena = " contenido añadido\n hola\nvaya por dios";
        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:/dir2/dir3/2.txt", true);
            for (int i = 0; i < cadena.length(); i++) {
                escribiendo.write(cadena.charAt(i));
            }
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
