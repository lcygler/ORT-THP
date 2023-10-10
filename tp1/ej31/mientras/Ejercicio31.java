package tp1.ej31.mientras;

import java.util.Scanner;

public class Ejercicio31 {
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		char opcion;

		System.out.println("¿Deseás continuar? [S/N]");
		opcion = Character.toLowerCase(input.nextLine().charAt(0));

		while (opcion != 's' && opcion != 'n') {
			System.out.println("¿Deseás continuar? [S/N]");
			opcion = Character.toLowerCase(input.nextLine().charAt(0));
		}

		input.close();
	}
}
