package ficheros.Serializacion;


import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

class Empleado implements Serializable {
    private String nombre;
    private transient double sueldo;
    private Date fechaContrato;
    public Empleado(String n, double s, int anho, int mes, int dia) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar( anho, mes-1, dia);
        fechaContrato = calendario.getTime();
    }
    public String getNombre() {
        return nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public Date getFechaContrato() {
        return fechaContrato;
    }
    public void subirSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje/100;
        sueldo += aumento;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ". Sueldo: " + sueldo + ". Fecha Contrato: " + fechaContrato;
    }
}