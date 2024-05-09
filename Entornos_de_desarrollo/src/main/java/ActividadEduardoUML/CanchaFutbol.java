package ActividadEduardoUML;

public class CanchaFutbol extends Instalacion {

	private String nombre;

	public CanchaFutbol(int id, double precioHora, boolean interior, String nombre) {
		super(id, precioHora, interior);

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Campo de Futbol{" +
				"nombre='" + getNombre() + '\'' +
				"} " + super.toString();
	}
}