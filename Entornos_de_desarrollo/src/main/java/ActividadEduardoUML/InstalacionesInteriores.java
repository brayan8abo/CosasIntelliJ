package ActividadEduardoUML;
//Analizar el sistema de gestión de reservas un centro de instalaciones deportivas:
//Tiene diferentes instalaciones: piscinas, gimnasios, pistas de tenis, canchas de baloncesto, campo de futbol; dichas instalaciones tienen nombre, precio por hora...
//Las instalaciones interiores tienen gasto por luz, y las exteriores mantenimiento del campo, y estas últimas según el horario también gasto por iluminación.
//De los socios se almacena su nombre, dirección, teléfono y cuota
//- Un socio realiza una reserva en una fecha con hora de inicio y final. Dicho socio puede realizar más de una reserva.
// Se pueden alquilar, junto a la reserva de la instalación, artículos como balones, raquetas... La reserva tendrá asociado ninguno o varios artículos alquilados.
public class InstalacionesInteriores extends Instalaciones {

	private double gastoLuz;


	public double getGastoLuz() {
		return gastoLuz;
	}

	public void setGastoLuz(double gastoLuz) {
		this.gastoLuz = gastoLuz;
	}

	public InstalacionesInteriores(String nombre, double precioxHora, double gastoLuz) {
		super(nombre, precioxHora);
		this.gastoLuz = gastoLuz;
	}

	@Override
	public String toString() {
		final StringBuilder SB = new StringBuilder("InstalacionesInteriores{");
		SB.append("gastoLuz=").append(gastoLuz);
		SB.append('}');
		return SB.toString();
	}
}
