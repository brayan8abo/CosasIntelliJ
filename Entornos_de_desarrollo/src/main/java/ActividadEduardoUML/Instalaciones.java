package ActividadEduardoUML;

//Analizar el sistema de gestión de reservas un centro de instalaciones deportivas:
//Tiene diferentes instalaciones: piscinas, gimnasios, pistas de tenis, canchas de baloncesto, campo de futbol; dichas instalaciones tienen nombre, precio por hora...
//Las instalaciones interiores tienen gasto por luz, y las exteriores mantenimiento del campo, y estas últimas según el horario también gasto por iluminación.
//- De los socios se almacena su nombre, dirección, teléfono y cuota
//- Un socio realiza una reserva en una fecha con hora de inicio y final. Dicho socio puede realizar más de una reserva.
// Se pueden alquilar, junto a la reserva de la instalación, artículos como balones, raquetas... La reserva tendrá asociado ninguno o varios artículos alquilados.

public class Instalaciones {
	private String nombre;
	private double precioxHora;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioxHora() {
		return precioxHora;
	}

	public void setPrecioxHora(double precioxHora) {
		this.precioxHora = precioxHora;
	}

	public Instalaciones(String nombre, double precioxHora) {
		this.nombre = nombre;
		this.precioxHora = precioxHora;
	}

	@Override
	public String toString() {
		final StringBuilder SB = new StringBuilder("Instalaciones{");
		SB.append("nombre=").append(nombre).append('\'');
		SB.append(", precioxHora=").append(precioxHora);
		SB.append('}');
		return SB.toString();
	}
}
