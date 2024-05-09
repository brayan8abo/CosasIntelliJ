package ActividadEduardoUML;

public class PistaBaloncesto extends Instalacion{

	private String nombre;

	public PistaBaloncesto(int id, double precioHora, boolean interior,String nombre) {
		super(id, precioHora, interior);

		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cancha de Baloncesto{" +
				"nombre='" + getNombre() + '\'' +
				"} " + super.toString();
	}
}
