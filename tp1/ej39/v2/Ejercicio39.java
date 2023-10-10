package tp1.ej39.v2;

import java.util.Scanner;

public class Ejercicio39 {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		final int CANTIDAD_DISPAROS = 3;
		int cantidadJugadores;
		int distancia;
		int tirosCentro = 0;
		int puntajeJugador = 0;
		int puntajeGanador = 0;
		String nombreJugador;
		String nombreGanador = "";
		
		cantidadJugadores = obtenerCantidad();
		
		for (int i = 0; i < cantidadJugadores; i++) {		
			nombreJugador = obtenerNombre();
			
			for (int j = 0; j < CANTIDAD_DISPAROS; j++) {		
				distancia = obtenerDistancia();
				
				if (distancia == 0)  {
					puntajeJugador += 500;
					tirosCentro++;
				} else if (distancia <= 10) {
					puntajeJugador += 250;
				} else if (distancia <= 50) {
					puntajeJugador += 100;
				}
			}
			
			if (puntajeJugador > puntajeGanador)  {
				puntajeGanador = puntajeJugador;
				nombreGanador = nombreJugador;
			}
			
			puntajeJugador = 0;
		}
		
		System.out.println("El ganador es " + nombreGanador + " y su puntaje es " + puntajeGanador);
		System.out.println("La cantidad total de tiros al centro es " + tirosCentro);
		
		input.close();
	}
	
	private static int obtenerCantidad() {
		int cantidad;
		
		do {
			System.out.println("Ingrese la cantidad de jugadores:");
			cantidad = Integer.parseInt(input.nextLine());
			
			if (cantidad < 2) {
                System.out.println("Cantidad no válida");
            }
		} while (cantidad < 2);
		
		return cantidad;
	}
	
	private static String obtenerNombre() {
		String nombre;
		
		do {
			System.out.println("Ingrese el nombre del jugador:");
			nombre = input.nextLine();
			
			if (nombre.isEmpty()) {
                System.out.println("Nombre no puede estar en blanco");
            }
		} while (nombre.isEmpty());
		
		return nombre;
	}
	
	private static int obtenerDistancia() {
		int distancia;
		
		do {
			System.out.println("Ingrese distancia al centro:");
			distancia = Integer.parseInt(input.nextLine());
			
			if (distancia < 0) {
                System.out.println("Distancia no válida");
            }
		} while (distancia < 0);
		
		return distancia;
	}
}
