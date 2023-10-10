package parcial1.mesetas.v3;

import java.util.Scanner;

public class Mesetas {
	public static final Scanner input = new Scanner(System.in);
	public static final int NUMERO_MIN = 0;
	public static final int NUMERO_MAX = 100;
	public static final int FIN = 0;

	public static void main(String[] args) {
		int numero;
		int numeroAnterior = 0;
		int numeroMeseta = 0;
		int cantidadMesetas = 0;
		int longitudActual = 1;
		int longitudMaxima = 0;

		numero = ingresarNumero();

		while (numero != FIN) {
			if (numero == numeroAnterior) {
				longitudActual++;
			} else if (longitudActual > 1) {
				cantidadMesetas++;

				if (longitudActual > longitudMaxima) {
					longitudMaxima = longitudActual;
					numeroMeseta = numeroAnterior;
				}

				longitudActual = 1;
			}

			numeroAnterior = numero;
			numero = ingresarNumero();
		}

		if (longitudActual > 1) {
			cantidadMesetas++;

			if (longitudActual > longitudMaxima) {
				longitudMaxima = longitudActual;
				numeroMeseta = numeroAnterior;
			}
		}

		imprimirResultado(cantidadMesetas, longitudMaxima, numeroMeseta);
		
		input.close();
	}

	private static int ingresarNumero() {
		int numero;

		do {
			System.out.println("Ingrese un número [" + NUMERO_MIN + "-" + NUMERO_MAX + "]:");
			numero = Integer.parseInt(input.nextLine());
		} while (numero < NUMERO_MIN || numero > NUMERO_MAX);

		return numero;
	}

	private static void imprimirResultado(int cantidadMesetas, int longitudMaxima, int numeroMeseta) {
		if (cantidadMesetas > 0) {
			System.out.println("La cantidad de mesetas es: " + cantidadMesetas);
			System.out.print("La meseta más extensa es: ");

			for (int i = 0; i < longitudMaxima; i++) {
				System.out.print(numeroMeseta);

				if (i < longitudMaxima - 1) {
					System.out.print("-");
				}
			}

			System.out.println("\nLa meseta más extensa tiene: " + longitudMaxima + " números");
		} else {
			System.out.println("No se detectaron mesetas");
		}
	}
}
