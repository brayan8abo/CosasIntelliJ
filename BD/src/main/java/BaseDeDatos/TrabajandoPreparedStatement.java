package BaseDeDatos;

import java.sql.*;

public class TrabajandoPreparedStatement {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/pruebas";
        final String usuario = "root";
        final String password = "admin";

        try {
            Connection miConexion = DriverManager.getConnection(url, usuario, password);

            PreparedStatement sentencia = miConexion.prepareStatement("select * from productos where nombre = ? and importado =?");
            // el ? indica que es un parametro

            sentencia.setString(1, "taladradora");
            sentencia.setBoolean(2, false);
            // el 1 hace referencia al primer ? en este caso, el primer nombre, que sea taladradrora y el 2 el segundo ? que seria importado = false

            

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + "\t" + rs.getString("nombre") + "\t" + rs.getDouble("precio") + "\t"+ rs.getBoolean("importado"));
            }

            System.out.println();

            sentencia.setString(1, "destornillador");
            sentencia.setBoolean(2, true);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + "\t" + rs.getString("nombre") + "\t" + rs.getDouble("precio") + "\t"+ rs.getBoolean("importado"));
            }


            rs.close();
            sentencia.close();
            miConexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
