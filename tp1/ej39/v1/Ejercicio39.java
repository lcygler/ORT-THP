package tp1.ej39.v1;

import java.util.Scanner;

public class Ejercicio39 {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int cantidadJugadores, distancia, puntajeJugador = 0, puntajeGanador = 0, tirosCentro = 0;
		String nombreJugador, nombreGanador = "";
		
		do {
			System.out.println("Ingrese la cantidad de jugadores:");
			cantidadJugadores = Integer.parseInt(input.nextLine());
		} while (cantidadJugadores < 2);
		
		for (int i = 0; i < cantidadJugadores; i++) {
			System.out.println("Ingrese el nombre del jugador:");
			nombreJugador = input.nextLine();
			
			for (int j = 0; j < 3; j++) {
				do {
					System.out.println("Ingrese distancia al centro:");
					distancia = Integer.parseInt(input.nextLine());
				} while (distancia < 0);
				
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
}
