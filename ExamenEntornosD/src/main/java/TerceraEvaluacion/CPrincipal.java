package TerceraEvaluacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CPrincipal {
    public static void main(String[] args) {

        CPelicula pelicula1 = new CPelicula(1, "Dead Pool", "Comedia", 180, "Pelicula", true);
        CSerie serie1 = new CSerie(2, "Principe de BelAir", "Comedia", 60, "Serie", true);


        ArrayList<CContenido> contenidos = new ArrayList<CContenido>();

        contenidos.add(pelicula1);
        contenidos.add(serie1);

        CUsuario usuario1 = new CUsuario("Brayan", "brayan8a@outlook.es", "12345");
        CUsuario usuario2 = new CUsuario("Noel", "Noeldomse@gmail.com", "12345");

        ArrayList<CUsuario> users = new ArrayList<>();
        users.add(usuario1);
        users.add(usuario2);


        calificacion(contenidos);


    }

    public static void calificacion(ArrayList<CContenido> contenidos) {
        int id;
        ArrayList<Integer> calificaciones = new ArrayList<>();

        System.out.println("\t---Calificacion de contenido---\n");
        Scanner leer = new Scanner(System.in);


        System.out.println("\tLos contenidos que tenemos son:\n");
        for (CContenido contenido : contenidos) {
            System.out.println(contenido.toString());
        }

        try {
            System.out.println("\nSelecciona el IDENTIFICADOR del contenido de preferencia\n");
            id = leer.nextInt();

            if (id == 1) {
                System.out.println(contenidos.get(0).toString());
            } else if (id == 2) {
                System.out.println(contenidos.get(1).toString());
            } else {
                System.out.println("Contenido no encontrado");
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("[ERROR]: Debes ingresar un número de IDENTIFICADOR");
        }


        int calificacion = 0;
        if (id == 1 || id == 2) {
            System.out.print("\nIngrese la calificacion (1-5):\n ");
            calificacion = leer.nextInt();
            calificaciones.add(calificacion);
        }


            if (calificacion >= 1 && calificacion <= 5) {
                System.out.println("Calificacion: " + calificacion + " estrellas");
            } else {
                System.out.println("Calificacion invalida. Debe ser un numero entre 1 y 5.");
            }


            String respuesta;
            do {
                System.out.println("Desea calificar otro contenido? (si/no)");
                respuesta = leer.next();
                if (respuesta.equalsIgnoreCase("si")) {
                    calificacion(contenidos);
                } else if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("\nHasta pronto!");
                } else {
                    System.out.println("Respuesta invalida, Por favor, ingrese 'si' o 'no'.");
                    respuesta = leer.nextLine();
                }
            } while (respuesta == "no");


        }
    }

