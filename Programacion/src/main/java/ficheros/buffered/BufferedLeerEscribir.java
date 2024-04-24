package ficheros.buffered;

import java.io.*;
import java.util.Scanner;

public class BufferedLeerEscribir {
    public static void main(String[] args) {
        String texto;
        Scanner leer = new Scanner(System.in);


        try {
            FileWriter fw = new FileWriter("C:/dir2/Buffered.txt", true);
            BufferedWriter escribir = new BufferedWriter(fw);

            do {
                System.out.println("Ingresa el texto");
                texto = leer.nextLine();
                    if(!texto.isEmpty()){
                        escribir.write(texto);
                        escribir.newLine();
                    }
            } while (!texto.isBlank());
            escribir.close();
            FileReader lecturaFR = new FileReader("C:/dir2/Buffered.txt");
            BufferedReader lecturaBR = new BufferedReader(lecturaFR);
            System.out.println("SALIDA");
            do {
                texto = lecturaBR.readLine();
                if (texto != null) {
                    System.out.println(texto);
                }
            } while (texto != null);
            lecturaBR.close();
//            escribir.write("texto con buffered");
//            escribir.write();
//            escribir.write("Segunda linea");

        } catch (IOException e) {
            System.out.println("EXCEPCIÓN");
//            throw new RuntimeException(e);
        }


    }
}
