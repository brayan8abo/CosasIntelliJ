package Ejercicios2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Hacer un programa, que modifique el fichero “texto.txt”, insertando un * delante de cada vocal.
//Mostrar el fichero “texto.txt” resultante.
//        Ejemplo :
//Inicialmente Texto.txt Voy a hacer una prueba
//Finalmente Texto.txt V*oy *a h*ac*er *un*a pr*u*eb*a
public class Reemplazar {
    public static void main(String[] args) {
        System.out.println(leer("C:/dir2/Buffered.txt"));

    }


    public static String leer(String direccion) {
        StringBuilder SB = new StringBuilder();
        FileReader entrada = null;
        String nuevo = "";

        try {
            entrada = new FileReader(direccion);
            try {
                int c;
                int j;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        j = (char) c;
                    }
                    if (c == 'a' || c == 'e' || c == 'o' || c == 'u') {
                        nuevo += '*';
                    }
                    nuevo += String.valueOf((char) c);
                } while (c != -1);
                SB.append(nuevo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                entrada.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String salidaNueva = SB.toString();
        return salidaNueva;
    }
}

