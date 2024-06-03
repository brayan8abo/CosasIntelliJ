package Pruebas;

import java.time.LocalDate;

public class Video extends FondoPrestable {

	private String director;
	private int duracion;

	public Video(String titulo, String ISBN, LocalDate fecha_publicacion, boolean isDisponible, LocalDate fechaDisponibilidad, String director, int duracion) {
		super(titulo, ISBN, fecha_publicacion, isDisponible, fechaDisponibilidad);
		this.director = director;
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Video{" +
				"director='" + director + '\'' +
				", duracion=" + duracion +
				"} " + super.toString();
	}
}
