package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Reto1 {
    public static void main(String[] args) {

       /* Ejercicio 1
        Escribir un programa Java que le pida al usuario el nombre de un directorio y el nombre de un elemento.
        Compruebe si el elemento es un fichero que existe en el directorio tecleado por el usuario. Si no existe devuelve un mensaje de error y sale
        Si el elemento es un directorio debe listar su contenido (comprobar en la API cómo averiguar si es un directorio)
        Si el elemento es un fichero visualiza la longitud del fichero
        Si el elemento es un fichero pide al usuario el nombre nuevo y lo renombra.*/

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa el nombre de un directorio");
        String directorio = leer.nextLine();

        System.out.println("Ingresa el nombre de un elemento");
        String elemento = leer.nextLine();

        File directorios = new File(directorio, elemento);

        if (directorios.exists()) {
            System.out.println("Esto EXISTE");
            if (directorios.isDirectory()) {
                System.out.println("Es un directorio y contiene:\n");
                File[] ficheros = directorios.listFiles();
                for (File f : ficheros) {
                    System.out.println(f);
                }
                if (directorios.isFile()){
                    System.out.println("El elemento tiene una longitud de: " + elemento.length());
                }

            } else {
                System.out.println("No es un directorio");
            }
        } else {
            System.out.println("Esto NO existe");
        }





    }
}
