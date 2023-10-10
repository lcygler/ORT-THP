package tp1.ej37.mientras.v2;

import java.util.Scanner;

public class Ejercicio37 {
	public static final Scanner input = new Scanner(System.in);
	
	// Declarar constantes
	public static final int CANTIDAD_SUELDOS = 12;
	public static final int SUELDO_MINIMO = 0;
	
	public static void main(String[] args) {
		// Declarar variables
		double sueldo, totalSueldos = 0;
		int mes = 1;

		// Ingresar sueldo
		sueldo = ingresarSueldo(mes);

		while (mes <= CANTIDAD_SUELDOS && sueldo >= SUELDO_MINIMO) {
		  // Acumular sueldo ingresado
		  totalSueldos += sueldo;
		  
		  // Incrementar contador meses
		  mes++;
		  
		  // Ingresar siguiente sueldo
		  if (mes <= CANTIDAD_SUELDOS) {
			  sueldo = ingresarSueldo(mes);			  
		  }
		}

		// Mostrar sueldo total
		System.out.println("El monto percibido por el empleado hasta el momento es de $" + totalSueldos);
		
		// Cerrar scanner
		input.close();
	}
	
	private static double ingresarSueldo(int mes) {
		double sueldo;
		
		// Ingresar sueldo
		System.out.println("Ingrese el sueldo del mes " + mes + ":");
		sueldo = Double.parseDouble(input.nextLine());
		
		// Retornar sueldo
		return sueldo;  
	}
}
