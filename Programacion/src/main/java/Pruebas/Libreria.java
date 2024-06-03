package Pruebas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
	static Scanner leer = new Scanner(System.in);
	static ArrayList<FondoPrestable> fondosPrestables = new ArrayList<FondoPrestable>();

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		System.out.println("Bienvenidos a la libreria la FE");
		System.out.println("Tenemos varias opciones en la libreria\n1. Dar de alta.\n2. Prestar fondoPrestable.\n3. Devolver fondoPrestable.\n4. Ordenar según fecha de disponibilidad\n0. Para salir.");


		int opcion = leer.nextInt();


		switch (opcion) {
			case 1:
				System.out.println("Vamos a dar de alta un fondoPrestable");
				DarAlta();
				break;
			case 2:
				System.out.println("Vamos a prestar un fondoPrestable");
				Prestar();
				break;
			case 3:
				System.out.println("Vamos a devolver un fondoPrestable");
				Devolver();
				break;
			case 4:
				System.out.println("Vamos a ordenar por fecha de disponibilidad");
				Ordenar();
				break;
			case 0:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
		}
	}

	public static void DarAlta() {

		int numeroFondos = 0;
		System.out.println("¿Cuántos fondosPrestable deseas dar de alta?");
		numeroFondos = leer.nextInt();
		leer.nextLine();


		FondoPrestable[] fondos = new FondoPrestable[numeroFondos];


		System.out.println("Vamos a dar de alta un fondoPrestable\n Podemos dar alta un libro, o un video, ¿Qué deseas dar de alta?");
		String preguntaAlta = leer.nextLine();

		if (preguntaAlta.equalsIgnoreCase("libro")) {
			System.out.println("Vamos a dar de alta un libro");
			System.out.println("Ingresa el titulo");
			String titulo = leer.nextLine();
			System.out.println("Ingresa el autor");
			String autor = leer.nextLine();
			System.out.println("Ingresa el ISBN");
			String ISBN = leer.nextLine();
			System.out.println("Ingresa la fecha de publicacion");
			int fecha = leer.nextInt();
			int numPaginas = leer.nextInt();


			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fecha_publicacion = LocalDate.parse(String.valueOf(fecha), dt);

			fondosPrestables.add(new Libro(titulo, ISBN, fecha_publicacion, true, null, autor, numPaginas));


		}
		if (preguntaAlta.equalsIgnoreCase("video")) {
			System.out.println("Vamos a dar de alta un video");
			System.out.println("Ingresa el titulo");
			String titulo = leer.nextLine();
			System.out.println("Ingresa el director");
			String director = leer.nextLine();
			System.out.println("Ingresa el ISBN");
			String ISBN = leer.nextLine();
			System.out.println("Ingresa la fecha de publicacion");
			int fecha = leer.nextInt();
			int duracion = leer.nextInt();
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fecha_publicacion = LocalDate.parse(String.valueOf(fecha), dt);
			fondosPrestables.add(new Video(titulo, ISBN, fecha_publicacion, true, null, director, duracion));

		}
		for (int i = 0; i < fondosPrestables.size(); i++) {
			System.out.println(fondosPrestables.get(i));
		}
	}

	public static void Prestar() {
		System.out.println("Vamos a prestar un fondoPrestable");
		System.out.println("Ingresa el ISBN del fondoPrestable que deseas prestar");
		String ISBN = leer.nextLine();
		for (int i = 0; i < fondosPrestables.size(); i++) {
			if (fondosPrestables.get(i).getISBN().equalsIgnoreCase(ISBN)) {
				if (fondosPrestables.get(i).isDisponible()) {
					fondosPrestables.get(i).setDisponible(false);
					System.out.println("FondoPrestable prestado");
				} else {
					System.out.println("El fondoPrestable ya está prestado");
				}
			}
		}
		menu();
	}
	public static void Devolver() {
		System.out.println("Vamos a devolver un fondoPrestable");
		System.out.println("Ingresa el ISBN del fondoPrestable que deseas devolver");
		String ISBN = leer.nextLine();
		for (int i = 0; i < fondosPrestables.size(); i++) {
			if (fondosPrestables.get(i).getISBN().equalsIgnoreCase(ISBN)) {
				if (!fondosPrestables.get(i).isDisponible()) {
					fondosPrestables.get(i).setDisponible(true);
					System.out.println("FondoPrestable devuelto");
				} else {
					System.out.println("El fondoPrestable ya estaba devuelto");
				}
			}
		}
		menu();
	}
	public static void Ordenar() {
		System.out.println("Vamos a ordenar por fecha de disponibilidad");
        for (int i = 0; i < fondosPrestables.size(); i++) {
            if (fondosPrestables.get(i).isDisponible()) {
                System.out.println(fondosPrestables.get(i));
            }
        }
        menu();
	}
}
