package ficheros.AccesoRandomEjemplos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Aleatorio2 {
    static RandomAccessFile fich = null;
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);


        int posicion;
        long tamanno;
        int numero;

        try {
            fich = new RandomAccessFile("C:\\dir2\\enteros.dat", "rw");
            tamanno = fich.length() / 4;
            System.out.println("El fichero tiene " + tamanno + " enteros");

            do {
                System.out.println("Posicion invalida (>=1 y <=" + tamanno);
                posicion = leer.nextInt();

            } while (posicion < 1 || posicion > tamanno);
            posicion--;
            fich.seek(posicion* 4L); // un entero ocupa 4 bytes
            System.out.println("Valor " + fich.readInt());
            System.out.println("Ingresar un nuevo valor");
            numero= leer.nextInt();
            fich.seek(fich.getFilePointer()-4);
            fich.writeInt(numero);
            System.out.println("Contenido de fichero");
            mostarFich();
            fich.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mostarFich(){
        int numero;
        try {
            fich.seek(0);
            while (true){
                numero=fich.readInt();
                System.out.println(numero);
            }
        } catch (EOFException e){} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
