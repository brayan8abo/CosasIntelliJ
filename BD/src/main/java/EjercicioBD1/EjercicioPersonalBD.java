package EjercicioBD1;

import java.sql.*;

public class EjercicioPersonalBD {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/personal";
        final String usuario = "root";
        final String password = "admin";

//        final String createDB = "create database Personal";
        /*final String createTable = "CREATE TABLE Departamento(\n" +
                "Dept_no int PRIMARY KEY,\n" +
                "Nombre VARCHAR(15),\n" +
                "Ubicacion VARCHAR(15)\n" +
                ");";*/

        /*final String createTable2 ="CREATE TABLE Empleado (\n" +
                "Emp_no VARCHAR(4) PRIMARY KEY,\n" +
                "Nombre VARCHAR(25),\n" +
                "Salario int,\n" +
                "Dept_no int NOT NULL,\n" +
                "Foreign Key (Dept_no) REFERENCES Departamento(Dept_no)\n" +
                "on delete cascade on update cascade\n" +
                ");";*/

        /*final String insertTable1 = "INSERT INTO Departamento VALUES (10,'CONTABILIDAD','SEVILLA')," +
                "(20,'INVESTIGACION','MADRID')," +
                "(30,'VENTAS','BARCELONA')," +
                "(40,'PRODUCCION','BILBAO');";*/

        /*final String insertTable2 = "INSERT INTO Empleado VALUES ('7369','SANCHEZ',1040,20)," +
                "('7499','ARROYO',1500,30)," +
                "('7521','SALA',1625,30)," +
                "('7566','JIMENEZ',3500,40)," +
                "('7654','MARTIN',1600,30)," +
                "('7698','NEGRO',3005,30)," +
                "('7782','CEREZO',2885,10)," +
                "('7788','GIL',3000,20)," +
                "('7839','REY',4100,10)," +
                "('7844','TOVAR',1350,30)," +
                "('7876','ALONSO',1430,40)," +
                "('7900','JIMENO',1335,30)," +
                "('7902','FERNANDEZ',3000,20)," +
                "('7934','MUÑOZ',1690,10);";*/

//        final String createTableOfice = "create table OficinaEmpleados (id int not null auto_increment primary key, nombre_empleado varchar (50), nombre_depto  varchar(50), salario int, comision double);";
    final String recolectaDatos = "select empleado.nombre, as nombreEmpleado, departamento.nombre as nombreDepto, empleado,salario from empleado empleado inner join departamento as departamento on empleado.dept_no = departamento.dept_no;";

        try {
            Connection miConexion = DriverManager.getConnection(url, usuario, password);
            Statement st = miConexion.prepareStatement("use Personal");
//            st.executeUpdate(createDB);
//            st.execute(createTable);
//            st.execute(createTable2);

//            st.executeUpdate(insertTable1);
//            st.execute(insertTable2);

//            st.execute(createTableOfice);
            ResultSet rs = st.executeQuery(recolectaDatos);

            while (rs.next()){
                String nombre_estado = rs.getString("nombre");
                String nombre_departamento = rs.getString("departamento");
                int salario = rs.getInt("salario");

                PreparedStatement ps = miConexion.prepareStatement("insert into OficinasEmpleados (nombre_empleado, nombre_depto, salario) values (?, ?, ?)");
                ps.setString(1, "nombre_empleado");
                ps.setString(2, "nombre_depto");
                ps.setInt(3, salario);
                ps.executeUpdate();

            }

            st.close();
            miConexion.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
