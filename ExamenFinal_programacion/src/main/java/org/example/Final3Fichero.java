package org.example;

import java.io.*;
import java.util.Scanner;

public class Final3Fichero {
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

		FileOutputStream fos = new FileOutputStream(ruta); // escoger el fichero
		DataOutputStream dos = new DataOutputStream(fos); // escribir en el fichero

		nombre = "Las Rozas";
		dos.writeUTF(nombre);
		poblacion = 95071;
		dos.writeInt(poblacion);
		viviendas = 35390;
		dos.writeInt(viviendas);
		renta = 50286;
		dos.writeInt(renta);
		extension = 58.31;
		dos.writeDouble(extension);
		densidad_poblacion = poblacion / extension;
		dos.writeDouble(densidad_poblacion);
		riqueza = renta * poblacion;
		dos.writeInt(riqueza);


		nombre = "Brayan";
		dos.writeUTF(nombre);
		poblacion = 48614;
		dos.writeInt(poblacion);
		viviendas = 18925;
		dos.writeInt(viviendas);
		renta = 31360;
		dos.writeInt(renta);
		extension = 182.56;
		dos.writeDouble(extension);
		densidad_poblacion = 0;
		dos.writeDouble(densidad_poblacion);
		riqueza = 0;
		dos.writeInt(riqueza);


		nombre = "Tres Cantos";
		dos.writeUTF(nombre);
		poblacion = 46046;
		dos.writeInt(poblacion);
		viviendas = 14460;
		dos.writeInt(viviendas);
		renta = 41048;
		dos.writeInt(renta);
		extension = 37.93;
		densidad_poblacion = 0;
		dos.writeDouble(densidad_poblacion);
		riqueza = 0;
		dos.writeInt(riqueza);


		nombre = "Aranjuez";
		dos.writeUTF(nombre);
		poblacion = 58213;
		dos.writeInt(poblacion);
		viviendas = 24790;
		dos.writeInt(viviendas);
		renta = 41048;
		dos.writeInt(renta);
		extension = 41.62;
		densidad_poblacion = 0;
		dos.writeDouble(densidad_poblacion);
		riqueza = 0;
		dos.writeInt(riqueza);


		nombre = "Fuenlabrada";
		dos.writeUTF(nombre);
		poblacion = 194669;
		dos.writeInt(poblacion);
		viviendas = 70835;
		dos.writeInt(viviendas);
		renta = 22092;
		dos.writeInt(renta);
		extension = 39.45;
		dos.writeDouble(extension);
		densidad_poblacion = 0;
		dos.writeDouble(densidad_poblacion);
		riqueza = 0;
		dos.writeInt(riqueza);


		fos.close();
		dos.close();
		System.out.println("Datos ingresados correctamente");

		leer(ruta);
	}

	public static void leer(String ruta) {


		//METODO PARA VISUALIZAR DATOS DEL FICHERO


		Scanner sc = new Scanner(System.in);
		try {
			int poblacion, renta, viviendas;
			double extension, densidadPoblacion, riqueza;
			String nombre;

			FileInputStream fis = new FileInputStream(ruta); // escoger el fichero para leer
			DataInputStream dis = new DataInputStream(fis); // leer el fichero
			while (dis.available() > 0) {
				nombre = dis.readUTF();
				poblacion = dis.readInt();
				viviendas = dis.readInt();
				renta = dis.readInt();
				extension = dis.readDouble();
				densidadPoblacion = dis.readDouble();
				riqueza = dis.readDouble();

				System.out.println("Nombre : " + nombre + ", Poblacion : " + poblacion + ", Viviendas : " + viviendas + ", Renta : " + renta + ", Extension : " + extension + ", Densidad Poblacion : " + densidadPoblacion + ", Riqueza : " + riqueza);


			}

			dis.close();
			fis.close();

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			//throw new RuntimeException(e);
			System.out.println("ENTRANDO EN EL SIGUIENTE EJERCICIO");
		}
	}
}


