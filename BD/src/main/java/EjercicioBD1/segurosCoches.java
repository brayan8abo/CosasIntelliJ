package EjercicioBD1;

import java.sql.*;

public class segurosCoches {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/datoscoches";
		final String usuario = "root";
		final String password = "admin";
		final String instSQLcreate = "create table segurocoche (dni varchar (10), edad int, matricula varchar (8), seguro double, primary key (dni))";
		final String instSQLSelect = "select propietarios.dni,edad,matricula,precio from propietarios join coches on propietarios.dni = coches.dni;";
		final String instSQLInsert = "insert into segurocoche (dni,edad,matricula) select propietarios.dni, propietarios.edad,coches.matricula from propietarios join coches on propietarios.dni = coches.dni";


		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();



//			st.execute(instSQLcreate);
			st.execute(instSQLInsert);



			ResultSet rs = st.executeQuery(instSQLSelect);

			while (rs.next()){
				String dni_propietario = rs.getString("dni");
				int edad = rs.getInt("edad");
				String matricula = rs.getString("matricula");
				int precio = rs.getInt("precio");
				double seguro = calcularSeguro(edad,precio);
				final String insertSQLInsertTable = " insert into segurocoche (dni,edad,matricula,seguro) values ('" + dni_propietario + "'," + edad + ",'" + matricula + "'," + seguro + ");";
			}




		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private static double calcularSeguro(int edad, double precioCoche) {
		if (edad < 40) {
			return precioCoche * 0.02;
		} else {
			return precioCoche * 0.01;
		}
	}
}
