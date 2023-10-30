package tp3.ej06;

import java.util.ArrayList;

public class Cliente {
	private String dni;
	private String nombre;
	private double saldoAPagar;
	private Tipo tipo;
	private ArrayList<Pelicula> historial; 
	
	// Se podría usar una Clase con un ArrayList como atributo para el historial, y así hacerlo más escalable

	public Cliente(String dni, String nombre, Tipo tipo) {
		setDni(dni);
		setNombre(nombre);
		setSaldoAPagar(0);
		setTipo(tipo);
		historial = new ArrayList<>();
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni != null) {
			this.dni = dni;
		}
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (dni != null) {
			this.nombre = nombre;
		}
	}

	public double getSaldoAPagar() {
		return saldoAPagar;
	}

	public void setSaldoAPagar(double saldoAPagar) {
		this.saldoAPagar = saldoAPagar;
	}

	public boolean esPremium() {
		return tipo == Tipo.PREMIUM;
	}

	private void setTipo(Tipo tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
	}

	public boolean esDeudor() {
		boolean esDeudor = false;

		if (saldoAPagar > 0) {
			esDeudor = true;
		}

		return esDeudor;
	}

	private boolean buscarPelicula(String nombre) {
		int i = 0;
		Pelicula peliculaActual;
		boolean peliculaEncontrada = false;

		while (i < historial.size() && peliculaEncontrada == false) {
			peliculaActual = historial.get(i);

			if (peliculaActual.getNombre().equals(nombre)) {
				peliculaEncontrada = true;
			} else {
				i++;
			}
		}

		return peliculaEncontrada;
	}

	public boolean agregarPelicula(String nombre) {
		boolean peliculaEncontrada;
		boolean pudoAgregarse = false;

		peliculaEncontrada = buscarPelicula(nombre);

		if (!peliculaEncontrada) {
			Pelicula pelicula = new Pelicula(nombre, Tipo.STANDARD);
			pudoAgregarse = historial.add(pelicula);
		}

		return pudoAgregarse;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", saldoAPagar=" + saldoAPagar + ", tipo=" + tipo + "]";
	}
}
