package tp2.ej09;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private Domicilio domicilio;

	public Persona(String dni, String nombre, String apellido, Domicilio domicilio) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setDomicilio(domicilio);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni != null && !dni.isEmpty()) {
			this.dni = dni;
		}
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	private void setDomicilio(Domicilio domicilio) {
		if (domicilio != null) {
			this.domicilio = domicilio;
		}
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio="
				+ domicilio.toString() + "]";
	}
}
