package tp2.ej07;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private Computadora computadora;

	/*
	public Persona() {
		setNombre("");
		setApellido("");
		setDni("");
		setComputadora(null);
	}
	*/
	
	public Persona(String nombre, String apellido, String dni, Computadora computadora) {
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setComputadora(computadora);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido != null) {
			this.apellido = apellido;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni != null) {
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
		System.out.println("Trabajando...");
	}

	public void descansar() {
		System.out.println("Descansando...");
	}
}
