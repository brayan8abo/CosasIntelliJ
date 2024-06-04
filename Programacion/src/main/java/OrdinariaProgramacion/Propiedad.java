package OrdinariaProgramacion;

public class Propiedad {

    private String ubicacion;
    private int metros;
    private double precio;

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Propiedad(String ubicacion, int metros, double precio) {
        this.ubicacion = ubicacion;
        this.metros = metros;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "ubicacion='" + ubicacion + '\'' +
                ", metros=" + metros +
                ", precio=" + precio +
                '}';
    }
}
