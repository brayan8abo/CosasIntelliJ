package OrdinariaProgramacion;

import FicherosGH.ExamenFich.Alumno;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Inmobiliaria {
    static ArrayList propiedades = new ArrayList<Propiedad>();

    public static void main(String[] args) throws IOException {
        insertarDatos();
        mostrarDatos(propiedades);

    }

    public static void insertarDatos() {
        // arraylist con las propiedades


        //Se insertan dos locales, y dos pisos con los datos proporcionados
        propiedades.add(new Local("Calle Almería 12, Móstoles", 222, 143900.54, "Bar"));
        propiedades.add(new Local("Calle Mayor 20, Madrid", 100, 120600.98, "Panadería"));

        propiedades.add(new Piso("Av. de la Onu 2, Getafe", 62, 170600.27, 5));
        propiedades.add(new Piso("Calle Pez 20, Madrid", 50, 220830.42, 1));


    }

    public static void mostrarDatos(ArrayList propiedades) {
        // se ordenan por precio, mostrando los de menor precio primero
        Collections.sort(propiedades, Comparator.comparingDouble(Propiedad::getPrecio));


        for (Object objetos : propiedades) {
            System.out.println(objetos);

        }
    }

    public static void almacenarDatos(ArrayList propiedades) {

    }
    public static void modificarFicheros(){

    }
}











