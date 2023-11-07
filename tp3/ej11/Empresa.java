package tp3.ej11;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Carrera> carreras;

	public Empresa() {
		this.carreras = new ArrayList<>();
	}

	public void agregarCarrera(Carrera carrera) {
		if (carrera != null) {
			carreras.add(carrera);
		}
	}

	public Carrera buscarCarrera(String fecha) {
		int i = 0;
		Carrera carreraActual;
		Carrera carreraEncontrada = null;

		while (i < this.carreras.size() && carreraEncontrada == null) {
			carreraActual = this.carreras.get(i);

			if (carreraActual.getFecha().equals(fecha)) {
				carreraEncontrada = carreraActual;
			} else {
				i++;
			}
		}

		return carreraEncontrada;
	}

	public ArrayList<Integer> pilotosPorCarrera() {
		ArrayList<Integer> cantidadPilotos = new ArrayList<>();

		for (Carrera carrera : this.carreras) {
			cantidadPilotos.add(carrera.getCantidadPilotos());
		}

		return cantidadPilotos;
	}
}
