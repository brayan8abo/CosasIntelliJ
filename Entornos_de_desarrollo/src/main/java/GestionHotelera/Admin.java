package GestionHotelera;

public class Admin extends Usuario{


	public Admin(String nombre, String apellido, String correo, String contraseña) {
		super(nombre, apellido, correo, contraseña);
	}

	@Override
	public String toString() {
		return "Administrador{"+"idUsuario="+
				", nombre='" + getNombre() + '\'' +
				", apellido='" + getApellido() + '\'' +
				", correo='" + getCorreo() + '\'' + "}";
	}
}
