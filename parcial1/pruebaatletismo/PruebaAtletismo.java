package parcial1.pruebaatletismo;

import java.util.Scanner;

public class PruebaAtletismo {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		final int CANTIDAD_DIAS = 10;
		double tiempo;
		double tiempoMin = Double.MAX_VALUE;
		double tiempoTotal = 0;
		double tiempoPromedio;
		int diaTiempoMin = 0;
		boolean carreraMayor20 = false;
		
		for (int i = 1; i <= CANTIDAD_DIAS; i++) {
			do {
				System.out.println("Ingrese tiempo de la prueba [minutos]:");
				tiempo = Double.parseDouble(input.nextLine());
			} while (tiempo < 1 || tiempo > 99);
						
			if (tiempo < tiempoMin) {
				tiempoMin = tiempo;
				diaTiempoMin = i;
			}
			
			if (tiempo > 20) {
				carreraMayor20 = true;
				break;
			}
			
			tiempoTotal += tiempo;
		}
		
		tiempoPromedio = tiempoTotal / CANTIDAD_DIAS;
		
		if (!carreraMayor20 && tiempoMin < 15 && tiempoPromedio <= 18) {
			System.out.println("El tiempo promedio es: " + tiempoPromedio + " min.");
			System.out.println("El menor tiempo es: " + tiempoMin + " min. en el día " + diaTiempoMin);
		} else {
			System.out.println("No es apto");
		}
			
		input.close();
	}
}
