package ficheros.Ejercicios2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Hacer un programa que lea los valores del fichero de texto “numeros.txt” (0 al 9) y cree el fichero “estadistica.txt”,
//donde se guarde las frecuencias, la moda (el número que aparece con mayor frecuencia) y la media.
//Ejemplo:
//numeros.txt 4 5 2 1 6 2 1 1 3 5 5 9
//estadistica.txt Número 0 – 0 veces
//Número 1 – 3 veces
//Número 9 – 1 vez
//Moda: 1 y 5 Media:3.66
public class Ejercicio6 {
    public static void main(String[] args) {
        String direccion= "C:/dir2/numeros.txt";
        leer(direccion);

    }
    public static String leer(String direccion){
       StringBuilder sb = new StringBuilder();

        try {
            FileReader fr = new FileReader(direccion);
            FileWriter fw = new FileWriter("C:/dir2/estadistica.txt");
            int c;
            while((c = fr.read()) !=-1){
                char j = (char) c;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return direccion;
    }


}
