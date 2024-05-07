package EjercicioBD1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Hacer un programa en Java que cree la tabla PersonasPaises que tendrá los siguientes atributos:
//
//Id, Nombre, Apellido, Edad, NombrePais y Tamaño.

public class Paises {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/america";
        final String usuario = "root";
        final String password = "admin";
        final String instCreateTable = "create table PersonasPaises (id int auto_increment, nombre varchar (50), apellido varchar (50), edad int, nombre_pais varchar (15), tamanio varchar (15), primary key (id))";


        try {
            Connection miConexion = DriverManager.getConnection(url, usuario, password);
            Statement st = miConexion.createStatement();

//            st.execute("create table PersonasPaises (id int auto_increment, nombre varchar (50), apellido varchar (50), edad int, nombre_pais varchar (15), tamanio varchar (15), primary key (id))");

            String instSQLInsert = "insert into personaspaises (id,nombre,apellido,edad,nombre_pais,tamanio)" + "select persona.id, persona.nombre, persona.apellido, persona.edad, pais.nombre, pais.tamaño from persona JOIN pais  ON persona.pais = pais.id";

            st.executeUpdate(instSQLInsert);





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
