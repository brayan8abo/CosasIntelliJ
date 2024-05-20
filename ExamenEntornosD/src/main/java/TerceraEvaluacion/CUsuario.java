package TerceraEvaluacion;

public class CUsuario {

    private String nombre;
    private String correoE;
    private String contrasenia;

    public CUsuario(String nombre, String correoE, String contrasenia) {
        this.nombre = nombre;
        this.correoE = correoE;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "CUsuario{" +
                "nombre='" + nombre + '\'' +
                ", correoE='" + correoE + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
