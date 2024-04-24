package ficheros.Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO2 { //input output
    public static void main(String[] args) {
        String numeroMateria;
        String nota;

        Scanner leer = new Scanner(System.in);

        try {
            FileOutputStream fos = new FileOutputStream("C:/dir2/String.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);

            System.out.println("Ingresa un STRING");
            numeroMateria = leer.nextLine();
            while (!numeroMateria.equals("0")) {

                dos.writeUTF(numeroMateria);
                System.out.println("Ingrese otro String");
                nota = leer.nextLine();
                dos.writeUTF(nota);
                System.out.println("Ingresa un STRING (0 para acabar");
                numeroMateria = leer.nextLine();

            }
            dos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:/dir2/String.dat");
            DataInputStream dis = new DataInputStream(fis);

            while (dis.available() > 0) {
                numeroMateria = dis.readUTF();
                nota = dis.readUTF();
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
