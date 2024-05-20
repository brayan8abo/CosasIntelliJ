package TerceraEvaluacion;

public class CSerie extends CContenido {

    private int ID;
    private String titulo;
    private String genero;
    private int duracion;
    private String tipo;
    private Boolean isSerie;


    public CSerie(int ID, String titulo, String genero, int duracion, String tipo, Boolean isSerie) {
        super();
        this.ID = ID;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tipo = tipo;
        this.isSerie = isSerie;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getSerie() {
        return isSerie;
    }

    public void setSerie(Boolean serie) {
        isSerie = serie;
    }

    @Override
    public String toString() {
        return "CSerie " +
                "ID = " + ID +
                ", titulo = " + titulo + ", genero = " + genero + ", duracion = " + duracion +", tipo = " + tipo  + ", isSerie= " + isSerie;
    }
}
