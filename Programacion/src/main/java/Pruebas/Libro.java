package Pruebas;

import java.time.LocalDate;

public class Libro extends FondoPrestable{

	private String autor;
	private int numPaginas;

	public Libro(String titulo, String ISBN, LocalDate fecha_publicacion, boolean isDisponible, LocalDate fechaDisponibilidad, String autor, int numPaginas) {
		super(titulo, ISBN, fecha_publicacion, isDisponible, fechaDisponibilidad);
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
}
