package parcial1.autopista;

import java.util.Scanner;

public class Autopista {
	public static final Scanner input = new Scanner(System.in);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		final int CONDICION_CORTE = 0;
		int numeroAutopista;
		int cantidadCabinas;
		int numeroCabina;
		int turno;
		int cabinaMayorRecaudacion = 0;
		int autopistaMayorRecaudacion = 0;
		int cantidadRegistros = 0;
		double recaudacionCabina;
		double recaudacionAutopista = 0;
		double recaudacionTotal = 0;
		double recaudacionCabinaMax = -Double.MAX_VALUE;
		double recaudacionAutopistaMax = -Double.MAX_VALUE;
		double recaudacionPromedio;
						
		numeroAutopista = obtenerNumeroAutopista();
		
		while (numeroAutopista != CONDICION_CORTE) {
			cantidadCabinas = obtenerCantidadCabinas();	
			
			for (int i = 0; i < cantidadCabinas; i++) {
				numeroCabina = obtenerNumeroCabina(cantidadCabinas);
				turno = obtenerTurno();
								
				recaudacionCabina = obtenerRecaudacion();
				recaudacionAutopista += recaudacionCabina;
				
				if (recaudacionCabina > recaudacionCabinaMax) {
					recaudacionCabinaMax = recaudacionCabina;
					cabinaMayorRecaudacion = numeroCabina;
				}
				
				cantidadRegistros++;
			}
				
			if (recaudacionAutopista > recaudacionAutopistaMax) {
				recaudacionAutopistaMax = recaudacionAutopista;
				autopistaMayorRecaudacion = numeroAutopista;
			}
			
			System.out.println("El total recaudado es: " + recaudacionAutopista);
			System.out.println("La cabina con mayor recaudación es: " + cabinaMayorRecaudacion);
			
			recaudacionTotal += recaudacionAutopista;
			recaudacionAutopista = 0;
			
			numeroAutopista = obtenerNumeroAutopista();
		}
		
		recaudacionPromedio = recaudacionTotal / cantidadRegistros;
		
		System.out.println("El total recaudado general es: " + recaudacionTotal);
		System.out.println("La autopista con mayor recaudación es: " + autopistaMayorRecaudacion);
		System.out.println("La mayor recaudación de una autopista es: " + recaudacionAutopistaMax);
		System.out.println("La recaudación promedio por turno es: " + recaudacionPromedio);
		
		input.close();
	}
	
	private static int obtenerNumeroAutopista() {
		int numeroAutopista;
		
		do {
			System.out.println("Ingrese número de autopista:");
			numeroAutopista = Integer.parseInt(input.nextLine());
			
			if (numeroAutopista < 0) {
                System.out.println("Número de autopista no válido");
            }
		} while (numeroAutopista < 0);
		
		return numeroAutopista;
	}
	
	private static int obtenerCantidadCabinas() {
		int cantidadCabinas;
		
		do {
			System.out.println("Ingrese cantidad de cabinas:");
			cantidadCabinas = Integer.parseInt(input.nextLine());
			
			if (cantidadCabinas < 0) {
                System.out.println("Cantidad de cabinas no válida");
            }
		} while (cantidadCabinas < 0);
		
		return cantidadCabinas;
	}
	
	private static int obtenerNumeroCabina(int cantidadCabinas) {
		int numeroCabina;
		
		do {
			System.out.println("Ingrese número de cabina:");
			numeroCabina = Integer.parseInt(input.nextLine());
			
			if (numeroCabina <= 0 || numeroCabina > cantidadCabinas) {
                System.out.println("Número de cabina no válido");
            }
		} while (numeroCabina <= 0 || numeroCabina > cantidadCabinas);
		
		return numeroCabina;
	}
	
	private static int obtenerTurno() {
		int turno;
		
		do {
			System.out.println("Ingrese turno (1, 2 o 3):");
			turno = Integer.parseInt(input.nextLine());
			
			if (turno < 1 || turno > 3) {
                System.out.println("Turno no válido");
            }
		} while (turno < 1 || turno > 3);
		
		return turno;
	}
	
	private static double obtenerRecaudacion() {
		double recaudacion;
		
		do {
			System.out.println("Ingrese el total recaudado:");
			recaudacion = Integer.parseInt(input.nextLine());
			
			if (recaudacion < 0) {
                System.out.println("Recaudación no válida");
            }
		} while (recaudacion < 0);
		
		return recaudacion;
	}
}
