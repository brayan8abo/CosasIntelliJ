package GestorNotas;

import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorNotas {

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {

		Asignatura asignatura1 = new Asignatura("Ingles", "Primero");
		Asignatura asignatura2 = new Asignatura("Frances", "Primero");
		Asignatura asignatura3 = new Asignatura("Aleman", "Segundo");

		ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();

		asignatura.add(asignatura1);
		asignatura.add(asignatura2);
		asignatura.add(asignatura3);

		Profesor profesor1 = new Profesor("Jaime", "Lopez", "C/ Pez 15", "Jaime@FP.es", 684475415, "123");
		Profesor profesor2 = new Profesor("Leopoldo", "Perez", "C/ Angeles 6", "Leo@FP.es", 684475415, "123");

		Alumno alumno1 = new Alumno("Jose Miguel", "Gutierrez", "C/ Juan de la Cruz 45", "JM@FP.es", 78844515, "123");
		Alumno alumno2 = new Alumno("Brenda M", "Serrano", "C/ Oliva 15", "Brenda@FP.es", 123456789, "123");

		ArrayList<Persona> centroEstudios = new ArrayList<Persona>();

		centroEstudios.add(profesor1);
		centroEstudios.add(profesor2);
		centroEstudios.add(alumno1);
		centroEstudios.add(alumno2);

		Scanner leer = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("---[MENU GESTION DE NOTAS]---\n1. INICIAR SESION\n2. REGISTRARSE\n0. SALIR\nINGRESA UNA OPCION");
			opcion = leer.nextInt();

			switch (opcion) {
				case 1:
					inicioSesion(centroEstudios, asignatura);
					break;
				case 2:
					registro(centroEstudios);
					break;
				case 0:
					System.out.println("GRACIAS POR UTILIZAR EL GESTOR DE NOTAS");
					break;
				default:
					System.out.println("OPCION INCORRECTA");
			}

		} while (opcion != 0);

	}

	public static void registro(ArrayList<Persona> centroEstudios) {
		final int codigoProfesor = 1;
		final int codigoAlumno = 2;

		System.out.println("REGISTRO");
		System.out.println("INGRESA UNA TU CODIGO DE REGISTRO");
		Scanner leer = new Scanner(System.in);
		int opcion;
		opcion = leer.nextInt();

		if (opcion == codigoAlumno) {
			System.out.println("REGISTRO DE ALUMNO");
			System.out.println("INTRODUCE TU NOMBRE");
			leer.nextLine();
			String nombre = leer.nextLine();
			System.out.println("INTRODUCE TUS APELLIDOS");
			String apellidos = leer.nextLine();
			System.out.println("INTRODUCE TU DIRECCION");
			String direccion = leer.nextLine();
			System.out.println("INTRODUCE TU CORREO");
			String correo = leer.nextLine();
			System.out.println("INTRODUCE TU TELEFONO");
			int telefono = leer.nextInt();
			leer.nextLine();
			String contrasenia;
			String contraseniaVerificar;
			do {
				System.out.println("INTRODUCE TU CONTRASEÑA");
				contrasenia = leer.nextLine();
				System.out.println("VUELVE A INTRODUCIR TU CONTRASEÑA");
				contraseniaVerificar = leer.nextLine();

				if (!contrasenia.equals(contraseniaVerificar)) {
					System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
				}
			} while (!contrasenia.equals(contraseniaVerificar));

			if (contrasenia.equals(contraseniaVerificar)) {
				System.out.println("CONTRASENIA CORRECTA");
			}

			Alumno alumno1 = new Alumno(nombre, apellidos, direccion, correo, telefono, contrasenia);
			centroEstudios.add(alumno1);
		} else if (opcion == codigoProfesor) {
			System.out.println("REGISTRO DE PROFESOR");
			System.out.println("INTRODUCE TU NOMBRE");
			leer.nextLine();
			String nombre = leer.nextLine();
			System.out.println("INTRODUCE TUS APELLIDOS");
			String apellidos = leer.nextLine();
			System.out.println("INTRODUCE TU DIRECCION");
			String direccion = leer.nextLine();
			System.out.println("INTRODUCE TU CORREO");
			String correo = leer.nextLine();
			System.out.println("INTRODUCE TU TELEFONO");
			int telefono = leer.nextInt();
			leer.nextLine();
			String contrasenia;
			String contraseniaVerificar;
			do {
				System.out.println("INTRODUCE TU CONTRASEÑA");
				contrasenia = leer.nextLine();
				System.out.println("VUELVE A INTRODUCIR TU CONTRASEÑA");
				contraseniaVerificar = leer.nextLine();

				if (!contrasenia.equals(contraseniaVerificar)) {
					System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
				}
			} while (!contrasenia.equals(contraseniaVerificar));

			if (contrasenia.equals(contraseniaVerificar)) {
				System.out.println("CONTRASENIA CORRECTA");
			}

			Profesor profesor1 = new Profesor(nombre, apellidos, direccion, correo, telefono, contrasenia);
			centroEstudios.add(profesor1);
		}
		else {
			System.out.println("CODIGO INCORRECTO");
		}


	}

	public static void inicioSesion(ArrayList<Persona> centroEstudios, ArrayList<Asignatura> asignaturas) {
		System.out.println("INICIAR SESION");
		System.out.println("INTRODUCE TU CORREO");
		Scanner leer = new Scanner(System.in);
		String correo = leer.nextLine();
		System.out.println("INTRODUCE TU CONTRASEÑA");
		String contrasenia = leer.nextLine();

		for (int i = 0; i < centroEstudios.size(); i++) {
			if (centroEstudios.get(i).getCorreo().equals(correo) && centroEstudios.get(i).getContrasenia().equals(contrasenia)) {
				System.out.println("BIENVENIDO");
				System.out.println();

				if (centroEstudios.get(i) instanceof Alumno) {
					Alumno alumno = (Alumno) centroEstudios.get(i);
					System.out.println("QUIERES VER SUS NOTAS?");
					System.out.println("1. SI");
					System.out.println("2. NO");
					int opcion;
					opcion = leer.nextInt();
					leer.nextLine();
					if (opcion == 1) {
						alumno.verNotas();
					}
					if (opcion == 2) {
						System.out.println("HASTA LUEGO");
					}
				}

				if (centroEstudios.get(i) instanceof Profesor) {
					Profesor profesor = (Profesor) centroEstudios.get(i);
					System.out.println("1. Ingresar Nota a un Alumno");
					System.out.println("2. Ver Notas de todos los Alumnos");
					System.out.println("3. Ver Alumnos");
					System.out.println("4. Ver Profesores");
					System.out.println("0. Salir");
					int opcion;
					opcion = leer.nextInt();
					leer.nextLine();
					if (opcion == 1) {

						System.out.println("selecciona el alumno");
						for (int j = 0; j < centroEstudios.size(); j++) {

							if (centroEstudios.get(j) instanceof Alumno) {
								System.out.println((j + 1) + ". " + centroEstudios.get(j).getNombre() + " " + centroEstudios.get(j).getApellidos());
							}

							System.out.println("selecciona el alumno");
							int a = leer.nextInt();
							leer.nextLine();
							System.out.println("selecciona la asignatura");
							for (int k = 0; k < asignaturas.size(); k++) {

								System.out.println((k + 1) + ". " + asignaturas.get(k).getNombre());

							}
							int b = leer.nextInt();
							System.out.println("Introduce la nota");
							double c = leer.nextDouble();
							leer.nextLine();
							((Alumno) centroEstudios.get(a - 1)).aniadirNota(new Notas(asignaturas.get(b - 1), c));

						}

					}

					if (opcion == 2) {

						System.out.println("NOTAS DE LOS ALUMNOS :");
						for (int j = 0; j < centroEstudios.size(); j++) {

							if (centroEstudios.get(j) instanceof Alumno) {
								System.out.println((j + 1) + ". " + centroEstudios.get(j).getNombre() + " " + centroEstudios.get(j).getApellidos());
								((Alumno) centroEstudios.get(j)).verNotas();
							}
						}

					}

					if (opcion == 3) {
						System.out.println("ALUMNOS :");
						for (int j = 0; j < centroEstudios.size(); j++) {

							if (centroEstudios.get(j) instanceof Alumno) {
								System.out.println((j + 1) + ". " + centroEstudios.get(j).getNombre() + " " + centroEstudios.get(j).getApellidos());
							}

						}

					}

					if (opcion == 4) {
						System.out.println("PROFESORES :");
						for (int j = 0; j < centroEstudios.size(); j++) {
							if (centroEstudios.get(j) instanceof Profesor) {
								System.out.println((j + 1) + ". " + centroEstudios.get(j).getNombre() + " " + centroEstudios.get(j).getApellidos());
							}


						}

					}

					if (opcion == 0) {
						System.out.println("HASTA LUEGO :");

					} else {

						System.out.println("OPCION INCORRECTA");
					}
				}
			}
		}
	}

}
