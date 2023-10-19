package tp2.ej07;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private Computadora computadora;

	public Persona(String nombre, String apellido, String dni) {
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido != null && !apellido.isEmpty()) {
			this.apellido = apellido;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni != null && !dni.isEmpty()) {
			this.dni = dni;
		}
	}

	public Computadora getComputadora() {
		return computadora;
	}

	public void setComputadora(Computadora computadora) {
		if (computadora != null) {
			this.computadora = computadora;
		}
	}

	public void trabajar() {
		System.out.println(nombre + " está trabajando");
	}

	public void descansar() {
		System.out.println(nombre + " está descansando");
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
}
