package EjercicioBD1;

import java.sql.*;

public class segurosCoches {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/datoscoches";
		final String usuario = "root";
		final String password = "admin";
		final String instSQLcreate = "create table segurocoche (dni varchar (10), edad int, matricula varchar (8), seguro varchar (20), primary key (dni))";
		final String instSQLSelect = "select propietarios.dni,edad,matricula,precio from propietarios join coches on propietarios.dni = coches.dni;";

		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();
			ResultSet rs = st.executeQuery(instSQLSelect);

			String dni_propietario = null;
			int edad = 0;
			String matricula = null;
			double seguro = 0;
			while (rs.next()) {
				dni_propietario = rs.getString("dni");
				edad = rs.getInt("edad");
				matricula = rs.getString("Matricula");
				int precio = rs.getInt("precio");
				seguro = calcularPrecio(edad, precio);
			}

			String insertTablaSeguroCoche = "insert into segurocoche (dni,edad,matricula,seguro) values ('" + dni_propietario + "'," + edad + ",'" + matricula + "'," + seguro + ");";


//			st.executeUpdate(instSQLcreate);
			st.executeUpdate(insertTablaSeguroCoche);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
