package ActividadEduardoUML;

import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private Instalacion instalacion;
    private Socios socio;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Articulo> articulos;

    public Reserva(int id, Instalacion instalacion, Socios socio, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.instalacion = instalacion;
        this.socio = socio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }



    // AGREGAR O ELIMINAR ARTICULOS DE LA LIST DE LA RESERVA

    public void agregarArticulos(Articulo articulo){

        this.getArticulos().add(articulo);

    }

    public void eliminarArticulo(Articulo articulo){

        this.getArticulos().remove(articulo);
    }

    public float calcularCostoTotal() {
        float costoTotal = 0;
        for (Articulo articulo : getArticulos()) {
            costoTotal += articulo.getPrecio();
        }

        //La primera operacion de (getFechaFin().getTime() - getFechaInicio().getTime()) devuelve los milisegundos luego se pasan a segundos luego a minutos y luego a horas
        // y luego se multiplica por el precio de la hora de la instalacion

        costoTotal += (getFechaFin().getTime() - getFechaInicio().getTime()) / (1000 * 60 * 60) * getInstalacion().getPrecioHora();
        return costoTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + getId() +
                ", instalacion=" + getInstalacion() +
                ", socio=" + getSocio() +
                ", fechaInicio=" + getFechaInicio() +
                ", fechaFin=" + getFechaFin() +
                ", articulos=" + getArticulos() +
                '}';
    }
}