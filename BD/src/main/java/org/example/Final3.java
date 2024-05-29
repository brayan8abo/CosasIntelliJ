package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Final3 {

    //    Conexion a la base de datos
    static final String url = "jdbc:mysql://localhost:3306/datos_ciudades";
    static final String usuario = "root";
    static final String password = "admin";
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {


//        Instrucciones SQL para creacion de la base de datos
        final String dropDB = "drop database if exists datos_ciudades";
        final String createDB = "create database datos_ciudades";
        final String USEDB = "use datos_ciudades";


        try {

            Connection miConexion = DriverManager.getConnection(url, usuario, password);
            Statement st = miConexion.createStatement();

            System.out.println("Bienvenido\n---Deseas crear la BASE DE DATOS---\n");
            String pregunta = leer.nextLine();
            if (pregunta.equalsIgnoreCase("si")) {
                st.execute(dropDB);
                st.execute(createDB);
                st.execute(USEDB);
            } else {
                System.out.println("Base de datos no creada");
            }

//                Se crea la tabla con el metodo
            crearBBDDTabla();


//            Se ingresan los datos con el metodo
            insertarDatosBBDD("Las Rozas", 95071, 35390, 50286, 82.31, calcularDensidad(95071, 58.31), calcularRiqueza(50286, 95071));
            insertarDatosBBDD("Colmenar Viejo", 48614, 18925, 31360, 182.56, calcularDensidad(48614, 182.56), calcularRiqueza(31360, 48614));
            insertarDatosBBDD("Tres Cantos", 46046, 14460, 41048, 37.93, calcularDensidad(46046, 37.93), calcularRiqueza(41048, 46046));
            insertarDatosBBDD("Aranjuez", 58213, 24790, 26386, 201.11, calcularDensidad(58213, 201.11), calcularRiqueza(26386, 58213));
            insertarDatosBBDD("Fuenlabrada", 194669, 70835, 22092, 39.45, calcularDensidad(194669, 39.45), calcularRiqueza(22092, 194669));
//           Se visualiza lo ingresado con el metodo
            visualizarBBDD();

//            Se pregunta, y se borra con la informacion pasada por el usuario
            borrarBBDD();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    Metodo para crear la tabla , donde se le pasa la informacion para conectar a la base de datos
    public static void crearBBDDTabla() throws SQLException {

        Connection miConexion = DriverManager.getConnection(url, usuario, password);
        Statement st = miConexion.createStatement();
        Scanner leer = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";


//        Sentencia SQL para la creacion de la tabla
        final String createTableCiudades = "create table ciudades (nombre varchar (50) primary key, poblacion int, viviendas int, renta int, extension double,densidad_poblacion double, riqueza int);";
        System.out.println("Deseas crear la tabla [CIUDADES]");
        String creacion = leer.nextLine();
        if (creacion.equalsIgnoreCase("si")) {
            st.execute(createTableCiudades);
        } else {
            System.out.println("Tabla no creada");
        }
    }

    //    Metodo para insertar los datos ya ingresados en la creacion
    public static void insertarDatosBBDD(String nombre, int poblacion, int viviendas, int renta, double extension, double densidad_poblacion, int riqueza) throws SQLException {
        Connection miConexion = DriverManager.getConnection(url, usuario, password);
        Statement st = miConexion.createStatement();
        Scanner leer = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";

        System.out.println("Deseas insertar datos en la tabla [CIUDADES]");
        String insertar = leer.nextLine();

//        Confirmacion por parte del usuario, siendo asi la insercion correcta de los datos
        if (insertar.equalsIgnoreCase("si")) {
            st.execute("INSERT INTO" + " ciudades VALUES ('" + nombre + "'," + poblacion + "," + viviendas + "," + renta + "," + extension + "," + densidad_poblacion + "," + riqueza + ");");

        }

    }

    //    Metodo para calcular la densidad de la poblacion
    public static double calcularDensidad(int poblacion, double extension) {
        double densidad_poblacion = poblacion / extension;
        return densidad_poblacion;

    }

    //    Metodo para calcular la riqueza
    public static int calcularRiqueza(int renta, int poblacion) {
        int riqueza = renta * poblacion;
        return riqueza;
    }

    //Metodo para visualizar los datos de la base de datos
    public static void visualizarBBDD() throws SQLException {
//        Sentencia SQL para la visualizacion
        final String mostrarInsert = "select * from ciudades";
        Connection miConexion = DriverManager.getConnection(url, usuario, password);
        Statement st = miConexion.createStatement();
        Scanner leer = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";

        System.out.println("\nDeseas ver las inserciones realizadas?");
        String pregunta = leer.nextLine();
        if (pregunta.equalsIgnoreCase("si")) {
            st.execute(mostrarInsert);
            ResultSet rs = st.executeQuery(mostrarInsert);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            }
        } else {
            System.out.println("Hasta pronto");
        }
    }

    //Metodo para borrar algun dato ingresado en la base de datos
    public static void borrarBBDD() throws SQLException {
        Connection miConexion = DriverManager.getConnection(url, usuario, password);
        Statement st = miConexion.createStatement();
        Scanner leer = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String password = "admin";

        System.out.println("\nDeseas borrar alguna ciudad?\n");
        String delete = leer.nextLine();
        if (delete.equalsIgnoreCase("si")) {
            System.out.println("Ingresa el nombre de una de las ciudades: [Las Rozas, Colmenar Viejo, Tres Cantos, Aranjuez, Fuenlabrada]\n");
            String borrar = leer.nextLine().toLowerCase();
            st.execute("delete from ciudades where nombre = '" + borrar + "'");
            System.out.println("\nLa ciudad " + borrar + " se borro exitosamente\n");
        } else {
            System.out.println("Hasta pronto");
        }

    }
}


