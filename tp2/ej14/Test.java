package tp2.ej14;

import java.util.Scanner;

public class Test {
	public static final Scanner input = new Scanner(System.in);	
	public static final int NOTA_MINIMA = 0;
	public static final int NOTA_MAXIMA = 10;
	public static final int FIN = -1;

	public static void main(String[] args) {
		double nota;
		Promedio promedio = new Promedio();

		nota = cargarNota();

		while (nota != FIN) {
			promedio.incrementar(nota);
			nota = cargarNota();
		}

		System.out.printf("La nota promedio es %.2f", promedio.obtenerValor());
		// System.out.println(String.format("La nota promedio es  %.2f", promedio.obtenerValor()));
	}

	private static double cargarNota() {
		double nota;
		boolean notaValida;

		do {
			System.out.println("Ingrese nota entre " + NOTA_MINIMA + " y " + NOTA_MAXIMA + ", " + FIN + " para finalizar:");
			nota = Double.parseDouble(input.nextLine());
			notaValida = (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) || nota == FIN;		
		} while (!notaValida);

		return nota;
	}
}
