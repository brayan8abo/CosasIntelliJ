package TerceraEvaluacion;

public class CPelicula extends CContenido {

    private int ID;
    private String titulo;
    private String genero;
    private int duracion;
    private String tipo;
    private Boolean isPelicula;

    public CPelicula(int ID, String titulo, String genero, int duracion, String tipo, Boolean isPelicula) {
        this.ID = ID;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tipo = tipo;
        this.isPelicula = isPelicula;
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

    public Boolean getPelicula() {
        return isPelicula;
    }

    public void setPelicula(Boolean pelicula) {
        isPelicula = pelicula;
    }

    @Override
    public String toString() {
        return "CPelicula " +
                "ID = " + ID +
                ", titulo = " + titulo + ", genero='" + genero +", duracion = " + duracion + ", tipo = " + tipo  + ", isPelicula = " + isPelicula;
    }
}