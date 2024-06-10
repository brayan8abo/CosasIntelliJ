package OrdinariaProgramacion;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Inmobiliaria {
    static ArrayList propiedades = new ArrayList<Propiedad>();

    public static void main(String[] args) throws IOException {
        insertarDatos();
        mostrarDatos(propiedades);
        almacenarDatos(propiedades);
        modificarFicheros();


    }

    public static void mostrarDatos(ArrayList propiedades) {
        // se ordenan por precio, mostrando los de menor precio primero
        Collections.sort(propiedades, Comparator.comparingDouble(Propiedad::getPrecio));


//        for (Object objetos : propiedades) {
//            System.out.println(objetos);
//
//        }

        for (int i = propiedades.size() - 1; i >= 0; i--) {
            System.out.println(propiedades.get(i).toString());
        }

        //listo
    }

    public static void insertarDatos() {
        // arraylist con las propiedades


        //Se insertan dos locales, y dos pisos con los datos proporcionados
        propiedades.add(new Local("Calle Almería 12, Móstoles", 222, 143900.54, "Bar"));
        propiedades.add(new Local("Calle Mayor 20, Madrid", 100, 120600.98, "Panadería"));

        propiedades.add(new Piso("Av. de la Onu 2, Getafe", 62, 170600.27, 5));
        propiedades.add(new Piso("Calle Pez 20, Madrid", 50, 220830.42, 1));


    }

    public static void almacenarDatos(ArrayList propiedades) {

        ArrayList<Piso> pisos = new ArrayList<>();
        ArrayList<Local> locales = new ArrayList<>();

        for (int i = 0; i < propiedades.size(); i++) {

            if (propiedades.get(i) instanceof Piso) {

                pisos.add((Piso) propiedades.get(i));


            }
            if (propiedades.get(i) instanceof Local) {

                locales.add((Local) propiedades.get(i));


            }
        }
        serializarPiso(pisos);
        serializarLocal(locales);


    }

    public static void serializarPiso(ArrayList<Piso> pisos) {
        try {


            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir2\\pisos.bin"));
            escribirFichero.writeObject(pisos);
            escribirFichero.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void serializarLocal(ArrayList<Local> locales) {
        try {


            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir2\\locales.bin"));
            escribirFichero.writeObject(locales);
            escribirFichero.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void modificarFicheros() {
        leerPisos();
        leerLocales();
        ObjectInputStream recuperarFichero = null;
        try {
            recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir2\\pisos.bin"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ArrayList<Piso> pisos = (ArrayList<Piso>) recuperarFichero.readObject();
            System.out.println("PISOS:");
            for (Piso piso : pisos) {
                System.out.println(piso.toString());

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            recuperarFichero.close();
            recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir2\\locales.bin"));
            ArrayList<Local> locales = (ArrayList<Local>) recuperarFichero.readObject();
            recuperarFichero.close();
            System.out.println("LOCALES:");
            for (Local locale : locales) {
                System.out.println(locale.toString());

            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }

    public static void leerPisos() {
        try {


            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir2\\pisos.bin"));
            ArrayList<Piso> pisos = (ArrayList<Piso>) recuperarFichero.readObject();
            recuperarFichero.close();

            for (int i = 0; i < pisos.size(); i++) {

                double pocentaje = pisos.get(i).getPrecio() * 5 / 100;

                pisos.get(i).setPrecio(pisos.get(i).getPrecio() + pocentaje);
//                System.out.println(pisos.get(i).toString());

            }
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir2\\pisos.bin"));
            escribirFichero.writeObject(pisos);
            escribirFichero.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void leerLocales() {
        try {


            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir2\\locales.bin"));
            ArrayList<Local> locales = (ArrayList<Local>) recuperarFichero.readObject();
            recuperarFichero.close();

            for (int i = 0; i < locales.size(); i++) {

                double pocentaje = locales.get(i).getPrecio() * 5 / 100;

                locales.get(i).setPrecio(locales.get(i).getPrecio() + pocentaje);
//                System.out.println(locales.get(i).toString());

            }
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir2\\locales.bin"));
            escribirFichero.writeObject(locales);
            escribirFichero.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}











