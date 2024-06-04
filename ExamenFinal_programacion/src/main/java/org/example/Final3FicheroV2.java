package org.example;

import java.io.*;
import java.util.Scanner;

public class Final3FicheroV2 {
    static Scanner leer = new Scanner(System.in);
    static String nombre;
    static int poblacion;
    static int viviendas;
    static int renta;
    static double extension;
    static double densidad_poblacion;
    static int riqueza;

    public static void main(String[] args) throws IOException {
        insertarDatosFichero();
    }

    public static void insertarDatosFichero() throws IOException {
        System.out.println("Vamos a ingresar datos al fichero\nIngresa la ruta de datos");
        String ruta = leer.nextLine();
        FileOutputStream fos = new FileOutputStream(ruta);
        DataOutputStream dos = new DataOutputStream(fos);
        nombre = "Las Rozas";
        poblacion = 95071;
        viviendas = 35390;
        renta = 50286;
        extension = 58.31;
        densidad_poblacion = poblacion / extension;
        riqueza = renta * poblacion;
        fos.write(("Las Rozas" + "\t" + poblacion + "\t" + viviendas + "\t" + renta
                + "\t" + extension + "\t" + densidad_poblacion + "\t" + riqueza + "\n").getBytes());
        dos.writeUTF(fos.toString());
        nombre = "Colmenar Viejo";
        poblacion = 48614;
        viviendas = 18925;
        renta = 31360;
        extension = 182.56;
        densidad_poblacion = poblacion / extension;
        riqueza = renta * poblacion;
        fos.write(("Colmenar Viejo" + "\t" + poblacion + "\t" + viviendas + "\t" +
                renta + "\t" + extension + "\t" + densidad_poblacion + "\t" + riqueza + "\n").getBytes());
        dos.writeUTF(fos.toString());
        nombre = "Tres Cantos";
        poblacion = 46046;
        viviendas = 14460;
        renta = 41048;
        extension = 37.93;
        densidad_poblacion = poblacion / extension;
        riqueza = renta * poblacion;
        fos.write(("Tres Cantos" + "\t" + poblacion + "\t" + viviendas + "\t" +
                renta + "\t" + extension + "\t" + densidad_poblacion + "\t" + riqueza + "\n").getBytes());
        dos.writeUTF(fos.toString());
        nombre = "Aranjuez";
        poblacion = 58213;
        viviendas = 24790;
        renta = 26386;
        extension = 201.11;
        densidad_poblacion = poblacion / extension;
        riqueza = renta * poblacion;
        fos.write(("Aranjuez" + "\t" + poblacion + "\t" + viviendas + "\t" + renta
                + "\t" + extension + "\t" + densidad_poblacion + "\t" + riqueza + "n").getBytes());
        dos.writeUTF(fos.toString());
        nombre = "Fuenlabrada";
        poblacion = 194669;
        viviendas = 70835;
        renta = 22092;
        extension = 39.45;
        densidad_poblacion = poblacion / extension;
        riqueza = renta * poblacion;
        fos.write(("Fuenlabrada" + "\t" + poblacion + "\t" + viviendas + "\t" +
                renta + "\t" + extension + "\t" + densidad_poblacion + "\t" + riqueza + "\n").getBytes());
        dos.writeUTF(fos.toString());
        fos.close();
        dos.close();
        System.out.println("Datos ingresados correctamente");
    }
}

