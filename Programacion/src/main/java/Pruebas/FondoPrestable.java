package Pruebas;

import java.time.LocalDate;

public class FondoPrestable extends Fondo {
	private boolean isDisponible;
	private LocalDate fechaDisponibilidad = null;

	public FondoPrestable(String titulo, String ISBN, LocalDate fecha_publicacion, boolean isDisponible, LocalDate fechaDisponibilidad) {
		super(titulo, ISBN, fecha_publicacion);
		this.isDisponible = true;
		this.fechaDisponibilidad = null;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean disponible) {
		isDisponible = disponible;
	}

	public LocalDate getFechaDisponibilidad() {
		return fechaDisponibilidad;
	}

	public void setFechaDisponibilidad(LocalDate fechaDisponibilidad) {
		this.fechaDisponibilidad = fechaDisponibilidad;
	}

	public boolean prestar() {
		if (this.isDisponible()) {

			this.setDisponible(false);
			setFechaDisponibilidad(LocalDate.now().plusDays(15));
			System.out.println("Se presto :" + this.getTitulo());
			return true;
		}
		System.out.println(this.getTitulo() + " esta no disponible");
		return false;

	}

	public boolean devolver() {
		if (this.isDisponible()) {

			this.setDisponible(true);
			setFechaDisponibilidad(null);
			System.out.println("Se devuelve :" + this.getTitulo());
			return true;
		} else {
			System.out.println(this.getTitulo() + " no se puede devolver");
			return false;

		}
	}

	@Override
	public String toString() {
		return "FondoPrestable{" +
				"isDisponible=" + isDisponible +
				", fechaDisponibilidad=" + fechaDisponibilidad +
				'}';
	}
}