package tp1.ej37.mientras.v1;

import java.util.Scanner;

public class Ejercicio37 {
	public static final Scanner input = new Scanner(System.in);
	public static final int CANTIDAD_SUELDOS = 12;
	public static final int SUELDO_MINIMO = 0;
	
	public static void main(String[] args) {
		double sueldo, totalSueldos = 0;
		int mes = 1;

		sueldo = ingresarSueldo(mes);

		while (mes <= CANTIDAD_SUELDOS && sueldo >= SUELDO_MINIMO) {
		  totalSueldos += sueldo;
		  
		  mes++;
		  
		  if (mes <= CANTIDAD_SUELDOS) {
			  sueldo = ingresarSueldo(mes);		  
		  }   
		}

		System.out.println("El monto percibido por el empleado hasta el momento es de $" + totalSueldos);
		
		input.close();
	}
	
	private static double ingresarSueldo(int mes) {
		double sueldo;
		
		System.out.println("Ingrese el sueldo del mes " + mes + ":");
		sueldo = Double.parseDouble(input.nextLine());
		
		return sueldo;  
	}
}
