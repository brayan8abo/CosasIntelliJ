import java.sql.*;

public class controlBrayan_ochoa {
    public static void main(String[] args) {


        //SENTENCIAS PARA DECLARAR BASE DE DATOS, CONTRASEÑA Y USUARIO
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";

        //Instrucciones para la creacion de la base de datos

        final String instSQLcreate = "create database Tienda_programacion";


        // SE HACE EL USO DE LA BD
        final String useBD = "use Tienda_programacion;";

        //Instrucciones para la creacion de una tabla

        final String instSQLCreateFAB = "create table Fabricantes(CLFAB int Primary Key,Nombre varchar(30));";
        final String instSQLCreateART = "create table Articulos(\n" +
                "CLART int Primary Key,\n" +
                "Nombre varchar(30),\n" +
                "Precio int,\n" +
                "CLFAB int,\n" +
                "Foreign Key (CLFAB) References Fabricantes(CLFAB)\n" +
                "ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ")ENGINE=InnoDB;";

        final String instSQLInsert = "insert into Fabricantes values(1,'Kingston'),(2,'Adata'),(3,'Logitech'),(4,'Lexar'),(5,'Seagate');";

        // se introducen todos los articulos uno por uno, debibo a un error, pero se encuentran todos los articulos
        final String instSQLInsertART = "insert into Articulos values(10,'Tarjeta de Red',180,3);";

//        creacion de la tabla ARTFAB
        final String createTable = "create table ArtFab (nombre_articulo varchar (50), fabricante varchar (50), precio int, IVA double);";

        String recogerDatos = "select articulos.nombre,articulos.precio from articulos join fabricantes on articulos.CLFAB = fabricantes.CLFAB;";


        try {
            Connection miConexion = DriverManager.getConnection(url, usuario, password);
            Statement st = miConexion.createStatement();


            st.execute(instSQLcreate);
            st.execute(useBD);
            st.execute(instSQLCreateFAB);
            st.execute(instSQLCreateART);
            st.execute(instSQLInsert);
            st.execute(instSQLInsertART);
            st.execute(createTable);


            ResultSet rs = st.executeQuery(recogerDatos);


            while (rs.next()) {
                String nombre_articulo = rs.getString("nombre");
                String precio = rs.getString("precio");
                System.out.println("Articulo: " + nombre_articulo + " Precio: " + precio);
            }


            st.close();
            rs.close();
            miConexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
