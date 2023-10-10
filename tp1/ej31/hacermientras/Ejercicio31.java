package tp1.ej31.hacermientras;

import java.util.Scanner;

public class Ejercicio31 {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		char opcion;
		
		do {
			System.out.println("¿Deseás continuar? [S/N]");
			opcion = Character.toLowerCase(input.nextLine().charAt(0));
		} while (opcion != 's' && opcion != 'n');			

		input.close();
	}
}
