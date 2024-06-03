package Pruebas;

import java.time.LocalDate;

public class Fondo {
	private String titulo, ISBN;
	private LocalDate fecha_publicacion;

	public Fondo(String titulo, String ISBN, LocalDate fecha_publicacion) {
		this.titulo = titulo;
		this.ISBN = ISBN;
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public LocalDate getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(LocalDate fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	@Override
	public String toString() {
		return "Fondo{" +
				"titulo='" + titulo + '\'' +
				", ISBN='" + ISBN + '\'' +
				", fecha_publicacion=" + fecha_publicacion +
				'}';
	}
}
