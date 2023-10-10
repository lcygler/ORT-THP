package parcial1.adivinaelnumero.v1;

import java.util.Scanner;

public class AdivinaElNumero {
	public static final Scanner input = new Scanner(System.in);
	public static final int TOPE_MIN = 1, TOPE_MAX = 10;
	
	public static void main(String[] args) {
		int rondas, numeroPrograma, numero1, numero2;
		String jugador1, jugador2, resultado = "";
				
		do {
			System.out.println("Ingrese el nombre del jugador 1:");
			jugador1 = input.nextLine();
		} while (jugador1 == "");
		
		do {
			System.out.println("Ingrese el nombre del jugador 2:");
			jugador2 = input.nextLine();
		} while (jugador2 == "");
		
		do {
			System.out.println("Ingrese la cantidad de rondas:");
			rondas = Integer.parseInt(input.nextLine());
		} while (rondas < 1);
		
		for (int i = 0; i < rondas; i++) {
			numeroPrograma = obtenerNumeroPrograma();
			
			do {
				System.out.println(jugador1 + ", ingrese un número (1-10):");
				numero1 = Integer.parseInt(input.nextLine());
			} while (numero1 < 1 || numero1 > 10);
			
			do {
				System.out.println(jugador2 + ", ingrese un número (1-10):");
				numero2 = Integer.parseInt(input.nextLine());
			} while (numero2 < 1 || numero2 > 10);
			
			System.out.println("El número pensado por el programa es: " + numeroPrograma);
		
			if (numero1 == numeroPrograma && numero2 == numeroPrograma) {
				resultado = "Empate";
				break;
			} else if (numero1 == numeroPrograma) {
				resultado = "Jugador1";
				break;
			} else if (numero2 == numeroPrograma) {
				resultado = "Jugador2";
				break;
			}
		}
		
		switch (resultado) {
			case "Jugador1":
				System.out.println("Ganó " + jugador1);
				break;
			case "Jugador2":
				System.out.println("Ganó " + jugador2);
				break;
			case "Empate":
				System.out.println("Hubo un empate");
				break;
			default:
				System.out.println("Perdieron ambos");
				break;
		}
		
		input.close();
	}
	
	private static int obtenerNumeroPrograma() {
		return TOPE_MIN + (int)(Math.random() * (TOPE_MAX - TOPE_MIN + 1));
	}
}
