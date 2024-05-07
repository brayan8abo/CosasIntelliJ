import java.sql.*;

public class Ejemplo2 {

//    VISUALIZAR BASES DE DATOS
public static void main(String[] args) {
    final String url = "jdbc:mysql://localhost:3306/";
    final String usuario = "root";
    final String password = "admin";
    final String instruccionSQLverBDs = "show databases";


    try {
        Connection conexion = DriverManager.getConnection(url,usuario,password);
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(instruccionSQLverBDs);

        while(rs.next()){
            System.out.println("BD: " + rs.getString(1));
        }

//        String consulta = "create database " + "BDnueva";

//        st.executeUpdate(consulta);

        st.executeUpdate("use bdnueva");


        st.execute("drop table tabla_nueva");


        st.executeUpdate("create table if not exists Tabla_nueva (id int auto_increment, nombre varchar (50), apellido varchar (50),email varchar (70), primary key (id))");


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}
}
