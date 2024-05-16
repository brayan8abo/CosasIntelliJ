package ejemplos;

import java.sql.*;

public class MenusBD {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/pruebasCasa";
		final String usuario = "root";
		final String password = "admin";

		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");


			//String created = "CREATE DATABASE IF NOT EXISTS pruebasCasa";
			//st.executeUpdate(created);

//			String table = "create table productos (codigo int,nombre varchar (20), precio double, importado boolean, primary key (codigo))";
//			st.executeUpdate(table);

//			String insert = "insert into productos values (2, 'maquina moler', 100.5,false)";
//			st.executeUpdate(insert);


//			String created2 = "create table distribuidor (codigo int,nombre varchar (20), primary key (codigo), foreign key (codigo) references productos(codigo))";
//			st.executeUpdate(created2);

			String update = "update productos set importado = true where nombre = 'maquina moler'";
			st.executeUpdate(update);

			rs = st.executeQuery("show databases");


			while (rs.next()) {
				String databaseName = rs.getString(1);
				System.out.println("(1+1) " + databaseName );
			}



			st.close();
			miConexion.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
