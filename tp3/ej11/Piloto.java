package tp3.ej11;

import java.util.ArrayList;

public class Piloto {
	private String nombre;
	private String dni;
	private ArrayList<Vuelta> vueltas;
	private double vueltaPromedio;

	public Piloto(String nombre, String dni) {
		this.setNombre(nombre);
		this.setDni(dni);
		this.vueltas = new ArrayList<>();
		this.vueltaPromedio = 0.0;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni != null) {
			this.dni = dni;
		}
	}

	public int getVueltas() {
		return this.vueltas.size();
	}

	public double getVueltaPromedio() {
		return this.vueltaPromedio;
	}

	public void agregarVuelta(int tiempo) {
		Vuelta vuelta = new Vuelta(tiempo);
		this.vueltas.add(vuelta);
		this.vueltaPromedio = calcularVueltaPromedio();
	}

	private double calcularVueltaPromedio() {
		int tiempoTotal = 0;
		double tiempoPromedio = 0.0;
		int cantidadVueltas = this.vueltas.size();

		for (Vuelta vuelta : this.vueltas) {
			tiempoTotal += vuelta.getTiempo();
		}

		if (cantidadVueltas > 0) {
			tiempoPromedio = (double) tiempoTotal / cantidadVueltas;
		}

		return tiempoPromedio;
	}
}
