package tp2.ej10;

public class Persona {
	private String nombre;
	private String apellido;

	public Persona(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		if (apellido != null && !apellido.isEmpty()) {
			this.apellido = apellido;
		}
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}
}
