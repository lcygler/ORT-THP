package tp3.ej11;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();

		Carrera carrera1 = new Carrera("01-11-2023", "10:00", Dificultad.PRINCIPIANTE, 15);
		Carrera carrera2 = new Carrera("02-11-2023", "11:30", Dificultad.AVANZADO, 20);

		carrera1.agregarPiloto("Juan", "12345678");
		carrera1.agregarPiloto("Ana", "98765432");
		carrera1.agregarPiloto("Carlos", "56789123");

		carrera2.agregarPiloto("Elena", "34561278");
		carrera2.agregarPiloto("Mario", "87654321");

		empresa.agregarCarrera(carrera1);
		empresa.agregarCarrera(carrera2);

		// Buscar carrera
		Carrera carreraEncontrada = empresa.buscarCarrera("01-11-2023");

		if (carreraEncontrada != null) {
			System.out.println("Carrera encontrada!");
			System.out.println("- Fecha: " + carreraEncontrada.getFecha());
			System.out.println("- Dificultad: " + carreraEncontrada.getDificultad());
		} else {
			System.out.println("Carrera no encontrada");
		}

		// Cantidad pilotos por carrera
		ArrayList<Integer> cantidadPilotos = empresa.pilotosPorCarrera();

		System.out.println("\nCantidad de pilotos por carrera:");

		for (int i = 0; i < cantidadPilotos.size(); i++) {
			System.out.println("- Carrera " + (i + 1) + ": " + cantidadPilotos.get(i) + " pilotos");
		}
	}
}
