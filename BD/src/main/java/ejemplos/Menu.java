package ejemplos;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		System.out.println("Las bases de datos que tenemos son:");
		listarBD();
		menu();

	}

	public static void menu() {
		int opcion = 0;

		switch (opcion) {
			case 1:
				System.out.println("Las bases de datos que tenemos son:");
				listarBD();
				System.out.println("Deseas escoger alguna?");
				System.out.println("1. Si\n2. No");
				Scanner leer = new Scanner(System.in);
				opcion = leer.nextInt();
				if (opcion == 1) {
					System.out.println("Introduce el nombre de la base de datos");
                    String nombreBD = leer.nextLine();
                    System.out.println("Introduce el nombre de la tabla");
                    String nombreTabla = leer.nextLine();
                    System.out.println("Introduce el nombre de la columna");
                    String nombreColumna = leer.nextLine();
                    System.out.println("Introduce el valor de la columna");
                    String valorColumna = leer.nextLine();
                    insertar(nombreBD, nombreTabla, nombreColumna, valorColumna);
				}

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}

	}

	private static void insertar(String nombreBD, String nombreTabla, String nombreColumna, String valorColumna) {

	}

	public static void listarBD() {
		final String url = "jdbc:mysql://localhost:3306/pruebasCasa";
		final String usuario = "root";
		final String password = "admin";

		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");

			rs = st.executeQuery("show databases");


			while (rs.next()) {
				String databaseName = rs.getString(1);
				System.out.println("(-) " + databaseName );
			}



			st.close();
			miConexion.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
