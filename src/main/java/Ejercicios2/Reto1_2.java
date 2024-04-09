package Ejercicios2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado “invertido.txt”, en el que se guardarán las frases del primero pero invertidas.
//        Mostrar en pantalla el nuevo fichero.
//        Ejemplo:
//        texto.txt Esto es un ejemplo
//        invertido.txt olpmeje nu se otsE
public class Reto1_2 {
    public static void main(String[] args) {
        leer();
//        escribir();

    }

    public static void leer() {
        try (FileReader entrada = new FileReader("C:\\pruebas\\archivos\\texto.txt")) {
            BufferedReader salida = new BufferedReader(entrada);
            try {
                String lineas;
                while ((lineas = salida.readLine()) != null)
                    System.out.println(lineas);
                ArrayList<String> texto = new ArrayList<>();
                texto.add(lineas);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

//    public static void escribir(ArrayList) {
//
//
//        FileWriter escribiendo = null;
//        try {
//            escribiendo = new FileWriter("C:\\dir2\\textoInvertido.txt");
//            for (int i = texto.size() - 1; i >= 0; i--) {
//                escribiendo.write(texto.size());
//            }
//            escribiendo.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}


