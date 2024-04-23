package ActividadEduardoUML;

import java.time.LocalDate;

public class Reservas extends Socios {

    private LocalDate fechaReserva;
    private LocalDate finReserva;
    private LocalDate horaReserva;
    private String articulos;

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFinReserva() {
        return finReserva;
    }

    public void setFinReserva(LocalDate finReserva) {
        this.finReserva = finReserva;
    }

    public LocalDate getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalDate horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getArticulos() {
        return articulos;
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public Reservas(String nombre, String direccion, int telefono, double couta, LocalDate fechaReserva, LocalDate finReserva, LocalDate horaReserva, String articulos) {
        super(nombre, direccion, telefono, couta);
        this.fechaReserva = fechaReserva;
        this.finReserva = finReserva;
        this.horaReserva = horaReserva;
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        final StringBuilder SB = new StringBuilder("Reservas{");
        SB.append("fechaReserva=").append(fechaReserva);
        SB.append(", finReserva=").append(finReserva);
        SB.append(", horaReserva=").append(horaReserva);
        SB.append(", articulos='").append(articulos).append('\'');
        SB.append('}');
        return SB.toString();
    }
}
