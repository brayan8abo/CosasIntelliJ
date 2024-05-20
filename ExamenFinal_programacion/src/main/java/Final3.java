import java.sql.*;
import java.util.Scanner;

public class Final3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
//        Conexion a la base de datos
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";


//        Instrucciones SQL para creacion de la base de datos
        final String createBD = "create database datos_ciudades";
        final String USEDB = "use datos_ciudades";

//        Creacion de la tabla
//        final String createTableCiudades = "create table ciudades (nombre varchar (50) primary key, poblacion int, vivienvas int, renta int, extension double,densidad_poblacion double, riqueza int);";

        try {

            Connection miConexion = DriverManager.getConnection(url, usuario, password);
            Statement st = miConexion.createStatement();

            System.out.println("Bienvenido\n Deseas crear la BASE DE DATOS");
            String pregunta = leer.nextLine();
            if (pregunta.equalsIgnoreCase("si")) {
                st.execute(createBD);
                st.execute(USEDB);
            } else {
                System.out.println("Base de datos no creada");
            }

            System.out.println("Deseas crear la tabla [CIUDADES]");
            String creacion = leer.nextLine();
            if (creacion.equalsIgnoreCase("si")) {
//                st.execute(createTableCiudades);
            } else {
                System.out.println("Tabla no creada");
            }

            System.out.println("Deseas insertar datos en la tabla [CIUDADES]");
            String insertar = leer.nextLine();

            if (insertar.equalsIgnoreCase("si")) {
                System.out.println("Dime el nombre de la ciudad");
                String nombre = leer.nextLine();
                System.out.println("Dime la poblacion");
                int poblacion = leer.nextInt();
                System.out.println("Dime la viviendas");
                int viviendas = leer.nextInt();
                System.out.println("Dime la renta");
                int renta = leer.nextInt();
                System.out.println("Dime la extension");
                double extension = leer.nextDouble();
                System.out.println("Dime la densidad de la poblacion");
                double densidad = leer.nextDouble();
                System.out.println("Dime la riqueza");
                int riqueza = leer.nextInt();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
