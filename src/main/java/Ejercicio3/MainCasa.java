package Ejercicio3;


import java.io.*;
import java.util.ArrayList;

public class MainCasa {
    public static void main(String[] args) {

        ArrayList<Casa> casas = new ArrayList<>();

        Casa casa1 = new Casa("Egipto 28", 28, 2, "Madrid", 28037, 80, 3);
        Casa casa2 = new Casa("Zubieta", 6, 3, "Madrid", 28037, 60, 2);
        casas.add(casa1);
        casas.add(casa2);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("casas.dat"))) {
            oos.writeObject(casas);
            System.out.println("Datos de las casas guardados en el archivo casas.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("casas.dat"))) {
            ArrayList<Casa> casasLeidas = (ArrayList<Casa>) ois.readObject();
            System.out.println("Datos de las casas leídos desde el archivo:");
            for (Casa casa : casas) {
                System.out.println(casa);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}