import java.sql.*;

public class controlBrayan_ochoa {
	public static void main(String[] args) throws SQLException {


		//SENTENCIAS PARA DECLARAR BASE DE DATOS, CONTRASEÑA Y USUARIO
		final String url = "jdbc:mysql://localhost:3306/tienda_programacion";
		final String usuario = "root";
		final String password = "admin";

		//Instrucciones para la creacion de la base de datos

//        final String instSQLcreate = "create database Tienda_programacion";


		// SE HACE EL USO DE LA BD
		//final String useBD = "use Tienda_programacion;";

		//Instrucciones para la creacion de una tabla

//        final String instSQLCreateFAB = "create table Fabricantes(CLFAB int Primary Key,Nombre varchar(30));";
       /* final String instSQLCreateART = "create table Articulos(\n" +
                "CLART int Primary Key,\n" +
                "Nombre varchar(30),\n" +
                "Precio int,\n" +
                "CLFAB int,\n" +
                "Foreign Key (CLFAB) References Fabricantes(CLFAB)\n" +
                "ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ")ENGINE=InnoDB;";*/

//        final String instSQLInsert = "insert into Fabricantes values(1,'Kingston'),(2,'Adata'),(3,'Logitech'),(4,'Lexar'),(5,'Seagate');";

		// se introducen todos los articulos uno por uno, debibo a un error, pero se encuentran todos los articulos
		final String instSQLInsertART = "insert into Articulos values(1,'Teclado',100,3)," +
				"(2,'Disco Duro 300Gb',500,5),(3,'Mouse',80,3),(4,'Memoria USB',140,4),(5,'Memoria Ram',290,1)," +
				"(6,'Disco Duro Extraible 250 Gb',650,5),(7,'Memoria USB',279,1),(8,'DVD Rom',450,2),(9,'CD Rom',200,2)," +
				"(10,'Tarjeta de Red',180,3)";

//        creacion de la tabla ARTFAB
        final String createTable = "create table ArtFab (nombre_articulo varchar (50), fabricante varchar (50), precio int, IVA double);";

        final String instSQLInsertarArtFab = "insert into ArtFab(nombre_art,nombre_fab,precio,IVA) values(?,?,?,?)";

		final String instSQLSelectJoin = "select articulos.nombre as nombre_art,fabricantes.nombre as nombre_fab,articulos.precio from articulos" +
				" inner join fabricantes on articulos.clfab=fabricantes.clfab ";


		try {
			Connection miConexion = DriverManager.getConnection(url, usuario, password);
			Statement st = miConexion.createStatement();


//            st.execute(instSQLcreate);
//            st.execute(useBD);
//            st.execute(instSQLCreateFAB);
//            st.execute(instSQLCreateART);
//			st.execute(instSQLInsert);
//            st.execute(instSQLInsertART);
//            st.execute(createTable);


			ResultSet rs = st.executeQuery(instSQLSelectJoin);

			while (rs.next()) {
				String nombre_art = rs.getString("nombre_art");
				String nombre_fab = rs.getString("nombre_fab");
				int precio = rs.getInt("precio");
				double IVA = calcularIVA(precio);


				//INSERTAMOS LOS DATOS EN LA TABLA ArtFab

				PreparedStatement ps = miConexion.prepareStatement(instSQLInsertarArtFab);
				ps.setString(1, nombre_art);
				ps.setString(2, nombre_fab);
				ps.setInt(3, precio);
				ps.setDouble(4, IVA);
				ps.executeUpdate();
			}
			System.out.println("tabla rellenada correctamente");
		} else {
			System.out.println("No se han insertado los datos");
		}


// MOSTRAMOS LOS DATOS DE LA TABLA ARTFAB INSERTADOS ANTERIORMENTE
		System.out.println();
		System.out.println("RESULTADO FINAL DE LA TABLA ARTFAB: ");

		ResultSet rs = st.executeQuery(instSQLSelectFinal);
		while (rs.next()) {
			String nombre_art = rs.getString("nombre_art");
			String nombre_fab = rs.getString("nombre_fab");
			int precio = rs.getInt("precio");
			double IVA = rs.getDouble("IVA");
			System.out.println("Articulo: " + nombre_art + ", Fabricante: " + nombre_fab + ", Precio: " + precio + ", IVA: " + IVA);
		}




}

public static double calcularIVA(int precio) {

	if (precio < 200) {
		precio = precio * 10 / 100;

	} else if (precio < 500) {
		precio = precio * 8 / 100;
	} else if (precio < 700) {
		precio = precio * 6 / 100;
	}
	return precio;

}


