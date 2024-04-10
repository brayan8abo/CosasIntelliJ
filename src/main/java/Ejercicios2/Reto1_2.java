package Ejercicios2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado “invertido.txt”, en el que se guardarán las frases del primero pero invertidas.
//        Mostrar en pantalla el nuevo fichero.
//        Ejemplo:
//        texto.txt Esto es un ejemplo
//        invertido.txt olpmeje nu se otsE
public class Reto1_2 {
    public static void main(String[] args) {
//        leer();
        escribir(leer());

    }

    public static String leer() {
        String moriremos;
        try (FileReader entrada = new FileReader("C:\\dir2\\prueba3\\dir4\\dir5\\texto.txt")) {
            try {
                StringBuilder SB = new StringBuilder();
                int c;
                char j ;
                do {

                    c = entrada.read();
                    j=(char)c;
                    if (c != -1) {
                        SB.append(j);
                    }

                } while (c != -1); // -1 cuando llega al final del fichero

                SB.reverse();
                moriremos = SB.toString();

            } finally {
                entrada.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return moriremos;

    }

    public static void escribir(String cadena) {
//        String cadena = " contenido añadido\n hola\nvaya por dios";
        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir2\\prueba3\\dir4\\dir5\\textoInvertido.txt");

                escribiendo.write(cadena);

            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

