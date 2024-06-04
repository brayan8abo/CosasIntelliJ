package OrdinariaProgramacion;

public class Local extends Propiedad {

    private String negocio;


    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public Local(String ubicacion, int metros, double precio, String negocio) {
        super(ubicacion, metros, precio);
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Local " +
                "negocio = " + negocio + " ubicacion " + getUbicacion() + " precio " + getPrecio();
    }
}
