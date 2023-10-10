package tp1.ej39.v3;

import java.util.Scanner;

public class Ejercicio39 {
	public static final Scanner input = new Scanner(System.in);
	public static final int CANTIDAD_DISPAROS = 3;
	public static final int JUGADORES_MIN = 2;
	public static final int DISTANCIA_MIN = 0;
	public static final int PUNTAJE_CENTRO = 500;
	public static final int PUNTAJE_CERCA = 250;
	public static final int PUNTAJE_LEJOS = 100;
	
	public static void main(String[] args) {
		int cantidadJugadores;
		int tirosCentro = 0;
		int puntajeJugador = 0;
		int puntajeGanador = 0;
		String nombreJugador;
		String nombreGanador = "";
		String mensaje = "Ingrese la cantidad de jugadores:";
        String mensajeError = "Cantidad no válida";
        
		cantidadJugadores = ingresarNumero(mensaje, mensajeError, JUGADORES_MIN);
		
		for (int i = 0; i < cantidadJugadores; i++) {		
			nombreJugador = ingresarNombre();	
			puntajeJugador = calcularPuntaje();
			
			if (puntajeJugador > puntajeGanador)  {
				puntajeGanador = puntajeJugador;
				nombreGanador = nombreJugador;
			}
			
			System.out.println("Su puntaje es: " + puntajeJugador);
			
			puntajeJugador = 0;
		}
		
		System.out.println("El ganador es " + nombreGanador + " y su puntaje es " + puntajeGanador);
		System.out.println("La cantidad total de tiros al centro es " + tirosCentro);
		
		input.close();
	}
	
	private static int ingresarNumero(String mensaje, String mensajeError, int minimo) {
        int numero;

        do {
            System.out.println(mensaje);
            numero = Integer.parseInt(input.nextLine());

            if (numero < minimo) {
                System.out.println(mensajeError);
            }
        } while (numero < minimo);

        return numero;
    }
		
	private static String ingresarNombre() {
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
	
	private static int calcularPuntaje() {
        int distancia, puntaje = 0;
        String mensaje = "Ingrese distancia al centro:";
        String mensajeError = "Distancia no válida";
        
        for (int j = 0; j < CANTIDAD_DISPAROS; j++) {
        	distancia = ingresarNumero(mensaje, mensajeError, DISTANCIA_MIN);
            
            if (distancia == 0) {
            	puntaje += PUNTAJE_CENTRO;
            } else if (distancia <= 10) {
            	puntaje += PUNTAJE_CERCA;
            } else if (distancia <= 50) {
            	puntaje += PUNTAJE_LEJOS;
            } else {
            	 System.out.println("El tiro cayó fuera del tablero");
            }
        }

        return puntaje;
    }
}
