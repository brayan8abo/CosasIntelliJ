package GestorNotas;

import java.util.ArrayList;

public class Alumno extends Persona{

	private ArrayList <Notas>  notas = new ArrayList<Notas>();


	public Alumno(String nombre, String apellidos, String direccion, String correo, int telefono, String contrasenia) {
		super(nombre, apellidos, direccion, correo, telefono, contrasenia);
	}


	public ArrayList<Notas> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Notas> notas) {
		this.notas = notas;
	}
	public void verNotas(){

		if (!this.notas.isEmpty()) {
			for (int i = 0; i < notas.size(); i++) {

				System.out.println(notas.get(i).toString());

			}
		}
		if (this.notas.isEmpty()) {
			System.out.println("NO TIENES NOTAS REGISTRADAS");
		}
	}
	public void aniadirNota(Notas nota){

		this.notas.add(nota);
	}


	@Override
	public String toString() {
		return "Profesor{" +
				"nombre='" + getNombre()+ '\'' +
				", apellidos='" + getApellidos() + '\'' +
				", direccion='" + getDireccion() + '\'' +
				", correo='" + getCorreo() + '\'' +
				", telefono=" + getTelefono() +
				", notas=" + getNotas() +
				'}';
	}
}