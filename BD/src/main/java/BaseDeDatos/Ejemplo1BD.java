package BaseDeDatos;

import java.sql.*;

public class Ejemplo1BD {
    public static void main(String[] args) {

        /*Java™ Database Connectivity*/

            try {
                Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "admin");// siempre se le deben pasar todo esto siempre y cuando sea en local
                Statement st = miConexion.createStatement();

                ResultSet rs = st.executeQuery("select * from actor");

                while (rs.next()) {
//                    System.out.println(rs.getArray("codigo") + "\t" + rs.getString("Nombre") + "\t" + rs.getDouble("Precio") + "\t" + rs.getBoolean("Importado")); //con el get tengo la opcion de columna o label entonces le paso el nombre de la fila
                    System.out.println(rs.getInt("actor_id") + "\t");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }
}
