package ficheros.Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO { //input output
    public static void main(String[] args) {
        int numeroMateria;
        double nota;

        Scanner leer = new Scanner(System.in);

        try {
            FileOutputStream fos = new FileOutputStream("C:/dir2/String.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);

            System.out.println("Ingresa un codigo de asignatura (0 para acabar)");
            numeroMateria = leer.nextInt();
            while (numeroMateria != 0) {

                dos.writeInt(numeroMateria);
                System.out.println("Ingrese una nota");
                nota = leer.nextDouble();
                dos.writeDouble(nota);
                System.out.println("Ingresa un codigo de asignatura (0 para acabar");
                numeroMateria = leer.nextInt();

            }
            dos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:/dir2/String.dat");
            DataInputStream dis = new DataInputStream(fis);

            while (dis.available() > 0) {
                numeroMateria = dis.readInt();
                nota = dis.readDouble();
                System.out.println(numeroMateria + "\t" + nota);
            }
            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
