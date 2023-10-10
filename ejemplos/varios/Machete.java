package ejemplos.varios;

import java.util.Scanner;

public class Machete {
	public static final Scanner input = new Scanner(System.in);
	public static final int VARIABLE_ENTERA = 0;
	
	public static void main(String[] args) {
		int contador = 0;
		double acumulador = 0.0, porcentaje = 0.0;
		
		contador++;
		
		acumulador += contador;
		
		System.out.println("Contador: " + contador);
		System.out.println("Acumulador: " + acumulador);
		System.out.println("Porcentaje: " + porcentaje + "%");
		System.out.println("Escape de caracter: \"OK\"?");
		
		// --------------------------------------------------
		
		int num1, num2;
		
		num1 = ingresarEntero("Ingrese el primer número:");
		num2 = ingresarEntero("Ingrese el segundo número:");
		
		// --------------------------------------------------
		
		/*
		COMENTARIOS
		- Recordar validar que los divisores NO sean cero
		
		COMPARACIÓN
		- Números, caracteres y booleanos con == y !=
		- Strings con método cadena.equals() y !cadena.equals()
		
		MÁXIMOS
		int maximo = Integer.MIN_VALUE;
		double maximo = -Double.MAX_VALUE; // Negamos el valor más grande posible
		double maximo = (double) Integer.MIN_VALUE; // Requiere conversión de tipo
		
		MÍNIMOS
		int minimo = Integer.MAX_VALUE;
		double minimo = Double.MAX_VALUE;
		double minimo = (double) Integer.MAX_VALUE;
		*/
		
		input.close();
	}
	
	private static int ingresarEntero(String mensaje) {
        int entero;
        
        do {
			System.out.println(mensaje);
			entero = Integer.parseInt(input.nextLine());
		} while (entero < 0);
        
        return entero;
    }
	
	private static double ingresarDouble() {
        double numeroReal;
        
        do {
			System.out.println("Ingrese el double:");
			numeroReal = Double.parseDouble(input.nextLine());
		} while (numeroReal < 0.0);
        
        return numeroReal;
    }
	
	private static String ingresarString() {
        String string;
        
        do {
			System.out.println("Ingrese el string:");
			string = input.nextLine();
		} while (string.isEmpty());
        
        return string;
    }
	
	private static char ingresarChar() {
		char caracter;
        
        do {
			System.out.println("Ingrese el caracter:");	
			caracter = input.nextLine().charAt(0);
		} while (caracter != ' ');
        
        return caracter;
    }
}
