package tp3.ej06;

public class Pelicula {
	private String nombre;
	private Tipo tipo;

	public Pelicula(String nombre, Tipo tipo) {
		setNombre(nombre);
		setTipo(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public boolean esPremium() {
		return tipo == Tipo.PREMIUM;
	}

	private void setTipo(Tipo tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", tipo=" + tipo + "]";
	}
}
