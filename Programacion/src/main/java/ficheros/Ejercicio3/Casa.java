package ficheros.Ejercicio3;

import java.io.Serializable;

public class Casa implements Serializable {
//    dirección
//•    portal
//•    piso
//•    localidad
//•    código postal
//•    metros cuadrados
//•    número de habitaciones

    private String direccion;
    private int portal;
    private int piso;
    private String localidad;
    private int codigoPostal;
    private int metrosCuadradros;
    private int numeroHabitaciones;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPortal() {
        return portal;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getMetrosCuadradros() {
        return metrosCuadradros;
    }

    public void setMetrosCuadradros(int metrosCuadradros) {
        this.metrosCuadradros = metrosCuadradros;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Casa(String direccion, int portal, int piso, String localidad, int codigoPostal, int metrosCuadradros, int numeroHabitaciones) {
        this.direccion = direccion;
        this.portal = portal;
        this.piso = piso;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.metrosCuadradros = metrosCuadradros;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", portal=" + portal +
                ", piso=" + piso +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", metrosCuadradros=" + metrosCuadradros +
                ", numeroHabitaciones=" + numeroHabitaciones +
                '}';
    }
}
