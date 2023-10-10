package tp1.ej33;

import java.util.Scanner;

public class Ejercicio33 {
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	
		// WHILE
		int num, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		System.out.println("Ingrese un número (0 para salir):");
		num = Integer.parseInt(input.nextLine());
		
		while (num != 0) {
			if (num > max) {
				max = num;
			}
			
			if (num < min) {
				min = num;
			}
			
			System.out.println("Ingrese un número (0 para salir):");
			num = Integer.parseInt(input.nextLine());
		}	
		
		System.out.println("El máximo es: " + max);
		System.out.println("El mínimo es: " + min);
	
	/*	
		// DO WHILE
		int num, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		do {
			System.out.println("Ingrese un numero, 0 para salir");
			num = Integer.parseInt(input.nextLine());
			
			if (num != 0) {
				if (num > max) {
					max = num;
				} 
				
				if (num < min) {
					min = num;
				}
			}		
		} while (num != 0);	
		
		System.out.println("El máximo es: " + max);
		System.out.println("El mínimo es: " + min);			
	*/
		
		input.close();
	}
}
