package GestorNotas;

import java.util.ArrayList;

public class Profesor extends Persona {

	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public Profesor(String nombre, String apellidos, String direccion, String correo, int telefono, String contrasenia) {
		super(nombre, apellidos, direccion, correo, telefono, contrasenia);
	}


	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Profesor{" +
				"nombre='" + getNombre()+ '\'' +
				", apellidos='" + getApellidos() + '\'' +
				", direccion='" + getDireccion() + '\'' +
				", correo='" + getCorreo() + '\'' +
				", telefono=" + getTelefono() +
				",alumnos=" + getAlumnos() +
				'}';
	}
}
