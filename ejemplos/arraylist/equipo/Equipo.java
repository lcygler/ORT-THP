package ejemplos.arraylist.equipo;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<String> jugadores;

    // Constructor que inicializa el nombre del equipo y crea un ArrayList vacío de jugadores
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.jugadores = new ArrayList<>();
	}

    // Método para agregar un jugador al ArrayList de jugadores del equipo
    public void agregarJugador(String jugador) {
        jugadores.add(jugador);
    }

	// Método para mostrar los jugadores del equipo
	public void mostrarJugadores() {
		System.out.println("Jugadores del equipo " + nombre + ":");
		for (String jugador : jugadores) {
			System.out.println(jugador);
		}
    }

    public static void main(String[] args) {
        // Crear un objeto de la clase Equipo
        Equipo miEquipo = new Equipo("Equipo A");

        // Agregar jugadores al equipo
        miEquipo.agregarJugador("Jugador 1");
        miEquipo.agregarJugador("Jugador 2");
        miEquipo.agregarJugador("Jugador 3");

        // Mostrar los jugadores del equipo
        miEquipo.mostrarJugadores();
    }
}
