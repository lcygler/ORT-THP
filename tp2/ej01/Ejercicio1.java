package tp2.ej01;

import java.util.Scanner;

public class Ejercicio1 {
	public final static Scanner input = new Scanner(System.in);

	public int sumar(int numero1, int numero2) {
		return numero1 + numero2;
	}
	
	public int pedirNumero(String mensaje, int minimo, int maximo) {
		int numero;
		
		do {
			System.out.println(mensaje + " [" + minimo + "-" + maximo + "]:");
			numero = Integer.parseInt(input.nextLine());
		} while(numero < minimo || numero > maximo);
		
		return numero;
	}
}
