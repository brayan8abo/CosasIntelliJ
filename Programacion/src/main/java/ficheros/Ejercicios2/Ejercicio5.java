package ficheros.Ejercicios2;
//Ejercicio 5.-
//Hacer un programa que pida al usuario una palabra por teclado y diga cuántas veces aparece esa palabra en el fichero "parrafo.txt".

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce una palabra:");
        String palabraBuscada = leer.nextLine().toLowerCase();
        leer("C:\\dir2\\parrafo.txt", palabraBuscada);
        leer.close();
    }

    public static void leer(String ruta, String palabraBuscada) {
        StringBuilder SB = new StringBuilder();
        FileReader entrada = null;
        ArrayList<String> palabras = new ArrayList<>();

        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                entrada = new FileReader(ruta);
                int c;
                StringBuilder palabra = new StringBuilder();

                while ((c = entrada.read()) != -1) {
                    char j = (char) c;
                    if (Character.isLetterOrDigit(j)) {
                        palabra.append(j);
                    } else {
                        if (palabra.length() > 0) {
                            palabras.add(palabra.toString());
                            palabra.setLength(0);
                        }
                    }
                    SB.append(j);
                }

                // Agregar la última palabra si es que hay una al final del archivo
                if (palabra.length() > 0) {
                    palabras.add(palabra.toString());
                }

                entrada.close();
            } else {
                System.out.println(ruta + " NO EXISTE");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.equalsIgnoreCase(palabraBuscada)) {
                contador++;
            }
        }

        System.out.println(palabraBuscada + " aparece: " + contador + " veces");

    }
}




