//package EjercicioBD1;
//
//import java.sql.*;
//
//public class segurosCoches {
//	public static void main(String[] args) {
//		final String url = "jdbc:mysql://localhost:3306/datoscoches";
//		final String usuario = "root";
//		final String password = "admin";
//		final String instSQLcreate = "create table segurocoche (dni varchar (10), edad int, matricula varchar (8), seguro double, primary key (dni))";
//		final String instSQLSelect = "select propietarios.dni,edad,matricula,precio from propietarios join coches on propietarios.dni = coches.dni;";
//		final String instSQLInsert = "insert into segurocoche (dni,edad,matricula) select propietarios.dni, propietarios.edad,coches.matricula from propietarios join coches on propietarios.dni = coches.dni";
//		final String instSQLSelect2 = "select * from segurocoche";
//
//		try {
//			Connection miConexion = DriverManager.getConnection(url, usuario, password);
//			Statement st = miConexion.createStatement();
//
//
////			st.execute(instSQLcreate);
////			st.execute(instSQLInsert);
//
//
//			ResultSet rs = st.executeQuery(instSQLSelect);
//
//			while (rs.next()) {
//				String dni_propietario = rs.getString("dni");
//				int edad = rs.getInt("edad");
//				String matricula = rs.getString("matricula");
//				int precio = rs.getInt("precio");
//				final String insertSQLInsertTable = " insert into segurocoche (dni,edad,matricula,seguro) values ('" + dni_propietario + "'," + edad + ",'" + matricula + "'," + seguro + ");";
//
////				st.execute(insertSQLInsertTable);
//			}
//
//			st.execute(instSQLSelect2);
//			double porcentaje;
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String dni_propietario = rs.getString("dni");
//				int edad = rs.getInt("Edad");
//				String matricula = rs.getString("matricula");
//				double seguro = rs.getDouble("seguro");
//				if (seguro < 100) {
//					porcentaje = seguro * 5 / 100;
//					seguro = porcentaje + seguro;
//
//					String instSQLUpdateSC = "update segurocoche set seguro =" + seguro + "where matricula='" + matricula + "'";
//
//					st.execute(instSQLUpdateSC);
//
//				}
//				if (seguro > 400) {
//
//					String instSQLDelete = "delete from segurocoche where matricula=" + matricula + "'";
//
//					st.execute(instSQLDelete);
//				}
//			}
//
//
//			rs.close();
//			st.close();
//
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
