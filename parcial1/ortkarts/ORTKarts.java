package parcial1.ortkarts;

import java.util.Scanner;

public class ORTKarts {
	public static final Scanner input = new Scanner(System.in);
	public static final char KARTING_ROJO = 'R';
	public static final char KARTING_VERDE = 'V';
	public static final char FINALIZAR_CARGA = 'F';
	public static final int CANTIDAD_VUELTAS = 5;
	
	public static void main(String[] args) {
		int pianito, vueltasRojo = 0, vueltasVerde = 0, pianitoRojo = 0, pianitoVerde = 0;
		double promedioPianitoRojo, promedioPianitoVerde;
		char karting, kartingGanador = ' ';
		
		karting =  obtenerKarting();
		
		while (karting != FINALIZAR_CARGA) {
            pianito = obtenerCantidadPianito();

            if (karting == KARTING_ROJO) {
                vueltasRojo++;
                pianitoRojo += pianito;
            } else {
                vueltasVerde++;
                pianitoVerde += pianito;
            }

            if (vueltasRojo == CANTIDAD_VUELTAS || vueltasVerde == CANTIDAD_VUELTAS) {
                kartingGanador = karting;
                break;
            }

            karting = obtenerKarting();
        }
					
		promedioPianitoRojo = (double) pianitoRojo / vueltasRojo;
		promedioPianitoVerde = (double) pianitoVerde / vueltasVerde;
		
		if (karting != FINALIZAR_CARGA) {
			System.out.println("El karting ganador es: " + kartingGanador);
		} else {
			System.out.println("Indefinido");
		}
		
		if (promedioPianitoRojo < promedioPianitoVerde) {
			System.out.println("El karting que pisó en promedio menos veces el pianito es: " + KARTING_ROJO);
		} else if (promedioPianitoVerde < promedioPianitoRojo) {
			System.out.println("El karting que pisó en promedio menos veces el pianito es: " + KARTING_VERDE);
		} else {
			System.out.println("Ambos karting pisaron el pianito la misma cantidad de veces en promedio");
		}
		
		input.close();
	}
	
	private static char obtenerKarting() {
		char karting;
		boolean kartingValido;
		
		do {
			System.out.println("Ingrese karting (R/V/F):");
			karting = input.nextLine().charAt(0);
			
			kartingValido = karting == KARTING_ROJO || karting == KARTING_VERDE || karting == FINALIZAR_CARGA;
			
			if (!kartingValido) {
				System.out.println("Karting no válido");
			}
		} while (!kartingValido);
		
		return karting;
	}
	
	private static int obtenerCantidadPianito() {
		int pianito;
		
		do {
			System.out.println("Ingrese cantidad de veces que pisó el pianito:");
			pianito = Integer.parseInt(input.nextLine());
						
			if (pianito < 0) {
				System.out.println("Cantidad no válida");
			}
		} while (pianito < 0);
		
		return pianito;
	}
}
