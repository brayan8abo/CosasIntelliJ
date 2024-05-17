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
				break;
		}

	}

	private static void insertar(String nombreBD, String nombreTabla, String nombreColumna, String valorColumna) {

	}

	public static void listarBD() {
		final String url = "jdbc:mysql://localhost:3306/sakila";
		final String usuario = "root";
		final String password = "admin";


		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();
			ResultSet rs = st.executeQuery("show databases");

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
