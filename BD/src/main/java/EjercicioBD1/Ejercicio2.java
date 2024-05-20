package EjercicioBD1;

/*Ejecutar el fichero empresa.sql, que creará la base de datos Empresa, compuesta
de las tablas Empleados y Departamentos.
        Hacer un programa que actualice la tabla Empleados, mediante el fichero binario datos.dat.

        El fichero, datos.dat, tiene la siguiente estructura:

        El primer campo es una cadena que contendrá una A, una B o una M (alta, baja o modificación) y dependiendo de la operación
        tendrá los siguientes campos.
        Si es una baja sólo aparecerá el código del empleado a dar de baja.
        Si es un alta, vendrán todos los datos que forman parte de la tabla Empleados que es donde se van a insertar los datos.
        Y si es una modificación, vendrá el código del empleado y el porcentaje que se subirá el salario.
        Finalmente, sacar un informe en el que aparezca:

        Nº Empleado Nombre Empleado Salario Nombre Departamento*/

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		Scanner leer = new Scanner(System.in);



		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\dir1\\datos.dat"));

			System.out.println("Cuantas veces vas a realizar la operación:  A(alta), B(baja) o M(modificación)");
			int pregunta = leer.nextInt();

			for (int i = 0; i < pregunta; i++) {

				System.out.println("Ingresa la operaciión a realizar [A] - [B] - [M]");
				System.out.println("Introduce el valor de A, B o M");

				char operacion = leer.next().toUpperCase().charAt(0);

				dos.writeChar(operacion); // escritura de caracterer de la operacion

			}



			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa_programacion", "root", "admin");
			Statement st = miConexion.createStatement();

			DataInputStream dis = new DataInputStream(new FileInputStream("C:\\dir1\\datos.dat"));

			for (int i = 0; i < pregunta; i++) {

				char operacion = dis.readChar();

				if (operacion == 'A') {
					System.out.println("Vamos a dar de alta un nuevo empleado");
					System.out.println("Ingresa un número del empleado");
					int numeroEmp = leer.nextInt();
					leer.nextLine();
					System.out.println("introduce el apellido");
					String apellido = leer.nextLine();
					System.out.println("introduce el oficio");
					String oficio = leer.nextLine();
					System.out.println("introduce el director");
					int director = leer.nextInt();
					leer.nextLine();
					System.out.println("introduce la fecha de alta en formato yyyy-mm-dd (guiones inluidos)");
					String fechaAlt = leer.nextLine();
					System.out.println("introduce el salario");
					float salario = leer.nextFloat();
					System.out.println("introduce el comision");
					float comision = leer.nextFloat();
					System.out.println("introduce el numero del departamento");
					int deptNo = leer.nextInt();
					leer.nextLine();

					final String sqlInsert = "insert into empleados (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) values (" +
							numeroEmp+",'"+apellido+"','"+oficio+"',"+director+",'"+fechaAlt+"',"+salario+","+comision+","+deptNo+");";

					st.executeUpdate(sqlInsert);
					System.out.println("el nuevo empleado ha sido dado de alta");

				}

				if (operacion == 'B') {
					System.out.println("Se va a dar de baja un empleado");
					System.out.println("introduce el numero del empleado a dar de baja");
					int numeroEmp = leer.nextInt();
					final String sqlDelete = "delete from empleados where emp_no = " + numeroEmp+";" ;

					st.executeUpdate(sqlDelete);
					System.out.println(numeroEmp+" ha sido dado de baja");
				}

				if (operacion == 'M') {
					System.out.println("MODIFICACION DE SALARIO CON UPDATE");

					System.out.println("introduce el numero del empleado");
					int numeroEmp = leer.nextInt();
					leer.nextLine();
					System.out.println("introduce el porcentaje de aumento");
					float porcentaje = leer.nextFloat();
					leer.nextLine();
					final String sqlUpdate = "update empleados set salario = (salario*"+porcentaje+"/100) + salario where emp_no = "+numeroEmp+";";
					st.executeUpdate(sqlUpdate);
					System.out.println("el nuevo salario de : "+numeroEmp+" ha sido modificado");

				}

			}






			ResultSet rs =st.executeQuery("select * from empleados");
			System.out.println("Contenido de la tabla: ");
			while (rs.next()){


				int emp_no = rs.getInt("emp_no");
				String apellido = rs.getString("apellido");
				String oficio = rs.getString("oficio");
				int dir = rs.getInt("dir");
				String fecha_alt = rs.getString("fecha_alt");
				float salario = rs.getFloat("salario");
				float comision = rs.getFloat("comision");
				int dept_no = rs.getInt("dept_no");

				System.out.println("Numero de empleado: "+emp_no+", Apellido: "+apellido+", Oficio: "+oficio+", Director: "+dir+", Fecha de alta: "+fecha_alt+", Salario: "+salario+", Comision: "+comision+", Departamento: "+dept_no);



			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
