package EjercicioBD1;

import java.sql.*;
import java.util.Scanner;

//Hacer un programa en Java que cree la tabla PersonasPaises que tendrá los siguientes atributos:
//
//Id, Nombre, Apellido, Edad, NombrePais y Tamaño.

public class Paises {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/america";
		final String usuario = "root";
		final String password = "admin";
		final String instCreateTable = "create table PersonasPaises (id int auto_increment, nombre varchar (50), apellido varchar (50), edad int, nombre_pais varchar (15), tamanio varchar (15), primary key (id))";
		final String instSQLInsert = "insert into personaspaises (id,nombre,apellido,edad,nombre_pais,tamanio)" + "select persona.id, persona.nombre, persona.apellido, persona.edad, pais.nombre, pais.tamaño from persona JOIN pais  ON persona.pais = pais.id";
		final String instSQLSelect = "select * from personaspaises";
		final String instSQLUpdate = "update personaspaises set edad = edad + 1 where nombre_pais = 'costa rica'";

		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();
			ResultSet rs = st.executeQuery(instSQLSelect);


//			st.executeUpdate(instCreateTable);

//			st.executeUpdate(instSQLInsert);

			st.executeUpdate(instSQLUpdate);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" + rs.getString("apellido") + "\t" + rs.getInt("edad") + "\t" + rs.getString("nombre_pais")
						+ "\t" + rs.getString("tamanio"));
			}


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
