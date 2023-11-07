package tp3.ej11;

import java.util.ArrayList;

public class Carrera {
	private String fecha;
	private String hora;
	private Dificultad dificultad;
	private int vueltas;
	private ArrayList<Piloto> pilotos;

	public Carrera(String fecha, String hora, Dificultad dificultad, int vueltas) {
		this.setFecha(fecha);
		this.setHora(hora);
		this.setDificultad(dificultad);
		this.setVueltas(vueltas);
		this.pilotos = new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	private void setFecha(String fecha) {
		if (fecha != null) {
			this.fecha = fecha;
		}
	}

	public String getHora() {
		return hora;
	}

	private void setHora(String hora) {
		if (hora != null) {
			this.hora = hora;
		}
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	private void setDificultad(Dificultad dificultad) {
		if (dificultad != null) {
			this.dificultad = dificultad;
		}
	}

	public String getVueltas() {
		return hora;
	}

	private void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public void agregarPiloto(String nombre, String dni) {
		Piloto piloto = new Piloto(nombre, dni);
		this.pilotos.add(piloto);
	}

	public ArrayList<Piloto> buscarPilotosPorDebajoDe(int tiempo) {
		ArrayList<Piloto> pilotosPorDebajoDe = new ArrayList<>();

		for (Piloto piloto : this.pilotos) {
			if (piloto.getVueltas() >= 10 && piloto.getVueltaPromedio() <= tiempo) {
				pilotosPorDebajoDe.add(piloto);
			}
		}

		return pilotosPorDebajoDe;
	}

	public int getCantidadPilotos() {
		return this.pilotos.size();
	}

	public void mostrarPilotos() {
		for (Piloto piloto : this.pilotos) {
			System.out.println(piloto);
		}
	}

	public void mostrarMenorPromedio() {
		double promedio;
		double menorPromedio = Double.MAX_VALUE;
		Piloto pilotoMenorPromedio = null;

		for (Piloto piloto : this.pilotos) {
			promedio = piloto.getVueltaPromedio();

			if (promedio < menorPromedio) {
				menorPromedio = promedio;
				pilotoMenorPromedio = piloto;
			}
		}

		if (pilotoMenorPromedio != null) {
			System.out.println("Nombre: " + pilotoMenorPromedio.getNombre());
			System.out.println("DNI: " + pilotoMenorPromedio.getDni());
		}
	}
}
