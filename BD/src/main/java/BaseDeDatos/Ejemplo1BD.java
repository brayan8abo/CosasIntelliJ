package BaseDeDatos;

import java.sql.*;

public class Ejemplo1BD {
    public static void main(String[] args) {

        /*Java™ Database Connectivity*/

        try {
            final String instruccionSQLSelect = "select * from productos";
            final String instruccionSQLInsert = "insert into productos values (4,'Pistola',500,1)";
            final String instruccionSQLDelete = "delete from productos where codigo = 4";
            final String intruccionSQLUpdate = "update productos set precio = precio *2 where codigo = 2";
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "admin");// siempre se le deben pasar todo esto siempre y cuando sea en local
            Statement st = miConexion.createStatement();

//            st.executeUpdate(instruccionSQLInsert);
//            st.executeUpdate(instruccionSQLDelete);
st.executeUpdate(intruccionSQLUpdate);
            ResultSet rs = st.executeQuery(instruccionSQLSelect);



            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + "\t" + rs.getString("Nombre") + "\t" + rs.getDouble("Precio") + "\t" + rs.getBoolean("Importado")); //con el get tengo la opcion de columna o label entonces le paso el nombre de la fila
//                    System.out.println(rs.getInt("id"));/*+ rs.getString("nombre"));*/
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
