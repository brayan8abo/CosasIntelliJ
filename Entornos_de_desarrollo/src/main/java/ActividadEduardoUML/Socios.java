package ActividadEduardoUML;

import java.time.LocalDate;
import java.util.ArrayList;


//De los socios se almacena su nombre, dirección, teléfono y cuota
//Un socio realiza una reserva en una fecha con hora de inicio y final. Dicho socio puede realizar más de una reserva.
public class Socios {
	ArrayList<Socios> datos = new ArrayList<>();

	private String nombre;
	private String direccion;
	private int telefono;
	private double couta;


	public ArrayList<Socios> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Socios> datos) {
		this.datos = datos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public double getCouta() {
		return couta;
	}

	public void setCouta(double couta) {
		this.couta = couta;
	}

	public Socios(String nombre, String direccion, int telefono, double couta) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.couta = couta;
	}

	@Override
	public String toString() {
		final StringBuilder SB = new StringBuilder("Socios{");
		SB.append("nombre='").append(nombre).append('\'');
		SB.append(", direccion='").append(direccion).append('\'');
		SB.append(", telefono=").append(telefono);
		SB.append(", couta=").append(couta);
		SB.append('}');
		return SB.toString();
	}
}
