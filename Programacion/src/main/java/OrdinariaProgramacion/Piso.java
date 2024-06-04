package OrdinariaProgramacion;

public class Piso extends Propiedad {

    private int planta;

    public Piso(String ubicacion, int metros, double precio, int planta) {
        super(ubicacion, metros, precio);
        this.planta = planta;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    @Override
    public String toString() {
        return "Piso " +
                " planta = " + planta +
               " ubicacion " + getUbicacion()+ " precio " + getPrecio();
    }
}
