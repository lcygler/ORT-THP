package tp1.ej37.para;

import java.util.Scanner;

public class Ejercicio37 {
	public static final Scanner input = new Scanner(System.in);
	public static final int CANTIDAD_SUELDOS = 12;
	
	public static void main(String[] args) {
		int sueldo;
		int totalSueldos = 0;

		for (int i = 1; i <= CANTIDAD_SUELDOS; i++) {
		  System.out.println("Ingrese el sueldo del mes " + i + ":");
		  sueldo = Integer.parseInt(input.nextLine());
		  
		  if (sueldo < 0) {
		    break;
		  }

		  totalSueldos += sueldo;
		}

		System.out.println("El monto percibido por el empleado hasta el momento es de $" + totalSueldos);
	}
}
