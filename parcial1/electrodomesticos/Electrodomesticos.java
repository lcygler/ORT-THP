package parcial1.electrodomesticos;

import java.util.Scanner;

public class Electrodomesticos {
	public static final Scanner input = new Scanner(System.in);
	public static final char TURNO_MANANA = 'M';
	public static final char TURNO_TARDE = 'T';
	public static final char FINALIZAR = 'F';
	
	public static void main(String[] args) {
		char turno;
		int codigoVendedor;
		int codigoVendedorMax = 0;
		int cantidadVendedores = 0;
		double totalVendido;
		double totalMañana = 0;
		double totalTarde = 0;
		double totalMañanaAcum = 0;
		double totalTardeAcum = 0;
		double totalAcum = 0;
		double totalVendidoMax = Integer.MIN_VALUE;
		double promedioVentas;
        double porcentajeMañana;
        double porcentajeTarde;
        
		for (int i = 0; i < 15; i++) {
			turno = obtenerTurno();
			
			while (turno != FINALIZAR) {
				codigoVendedor = obtenerCodigo();
				totalVendido = obtenerTotalVendido();
												
				if (turno == TURNO_MANANA) {
					totalMañana += totalVendido;
				} else {
					totalTarde += totalVendido;
				}
				
				if (totalVendido > totalVendidoMax) {
					totalVendidoMax = totalVendido;
					codigoVendedorMax = codigoVendedor;
				}
				
				totalAcum += totalVendido;
				cantidadVendedores++;
				
				turno = obtenerTurno();
			}
			
		    totalMañanaAcum += totalMañana;
		    totalTardeAcum += totalTarde;
		    
		    totalMañana = 0;
			totalTarde = 0;
			
		    System.out.println("El total recaudado en el turno mañana es:" + totalMañana);
		    System.out.println("El total recaudado en el turno tarde es:" + totalTarde);
		    System.out.println("El vendedor con mayor recaudación es:" + codigoVendedorMax);
		}
			
		if (cantidadVendedores > 0) {
            promedioVentas = totalAcum / cantidadVendedores;
            porcentajeMañana = totalMañanaAcum / (totalMañanaAcum + totalTardeAcum) * 100;
            porcentajeTarde = totalTardeAcum / (totalMañanaAcum + totalTardeAcum) * 100;

            System.out.println("El promedio de ventas entre todos los vendedores es: " + promedioVentas);
            System.out.println("El porcentaje recaudado en el turno mañana es: " + porcentajeMañana);
            System.out.println("El porcentaje recaudado en el turno tarde es: " + porcentajeTarde);
        } else {
            System.out.println("No se ingresaron datos");
        }
		
		input.close();
	}

	private static char obtenerTurno() {
		char turno;
		
		do {
			System.out.println("Ingrese turno en el que trabaja (M/T/F):");
			turno = input.nextLine().charAt(0);			
		} while (turno != TURNO_MANANA && turno != TURNO_TARDE && turno != FINALIZAR);
		
		return turno;
	}
	
	private static int obtenerCodigo() {
		int codigo;
		
		do {
			System.out.println("Ingrese código de vendedor:");
			codigo = Integer.parseInt(input.nextLine());			
		} while (codigo <= 0);
		
		return codigo;
	}
	
	private static double obtenerTotalVendido() {
		double total;
		
		do {
			System.out.println("Ingrese total vendido en el día:");
			total = Double.parseDouble(input.nextLine());			
		} while (total < 0);
		
		return total;
	}
}
