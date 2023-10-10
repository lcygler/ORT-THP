package parcial1.freddort;

import java.util.Scanner;

public class FreddORT {
	public static final Scanner input = new Scanner(System.in);
	public static final char TAMANIO_CHICO = 'C';
	public static final char TAMANIO_MEDIANO = 'M';
	public static final char TAMANIO_GRANDE = 'G';
	public static final char FIN_DATOS = 'Z';
	public static final int COMISION_HELADERO = 50;
	
	public static void main(String[] args) {
		int cantidadGustos = 0;
		int ventasTamanioChico = 0;
		int ventasTamanioMediano = 0;
		int ventasTamanioGrande = 0;
		int ventasTotales = 0;
		int ordenCaloriasMinimo = 0;
		double calorias;
		double caloriasMinimo = Double.MAX_VALUE;
		double importe;
		double importePromedio;
		double importeMaximo = -Double.MAX_VALUE;
		double ingresosTotales = 0;
		double porcentajeChico;
		String gusto;
		String gustoCaloriasMinimo = "";
		String nombreComprador;
		String nombreCompradorMaximo = "";
		
		char tamanio = obtenerTamanio();
		
		while (tamanio != FIN_DATOS) {
			cantidadGustos = obtenerCantidadGustos();
			
			for (int i = 1; i <= cantidadGustos; i++) {
				gusto = obtenerGusto();
				calorias = obtenerCalorias();
				
				if (calorias < caloriasMinimo) {
					caloriasMinimo = calorias;
					gustoCaloriasMinimo = gusto;
					ordenCaloriasMinimo = i;
				}	
			}
			
			importe = obtenerImporte();
			nombreComprador = obtenerNombreComprador();
			
			switch (tamanio) {
				case TAMANIO_CHICO:
					ventasTamanioChico++;
					break;
				case TAMANIO_MEDIANO:
					ventasTamanioMediano++;
					break;
				case TAMANIO_GRANDE:
					ventasTamanioGrande++;
					break;
			}
			
			if (importe > importeMaximo) {
				importeMaximo = importe;
				nombreCompradorMaximo = nombreComprador;
			}
			
			ventasTotales++;
			ingresosTotales += importe;
			
			System.out.println("El gusto con menos calorías es: " + gustoCaloriasMinimo);
			System.out.println("El orden de pedido del gusto es: " + ordenCaloriasMinimo);
			
			if (ventasTamanioGrande == 20) {
		        break;
		    }
			
			tamanio = obtenerTamanio();
		}
		
		importePromedio = ingresosTotales / ventasTotales;
		porcentajeChico = (double) ventasTamanioChico / ventasTotales;
		
		System.out.println("La cantidad vendida del tamaño chico es: " + ventasTamanioChico);
		System.out.println("La cantidad vendida del tamaño mediano es: " + ventasTamanioMediano);
		System.out.println("La cantidad vendida del tamaño grande es: " + ventasTamanioGrande);
		System.out.println("El importe promedio de las ventas es: $" + importePromedio);
		System.out.println("El pedido más caro es de $" + importeMaximo + " comprado por " + nombreCompradorMaximo);
		System.out.println("El porcentaje de pedidos chicos es: " + porcentajeChico + "%");
		
		input.close();
	}
	
	private static char obtenerTamanio() {
		char tamanio;
		boolean tamanioValido;
		
		do {
			System.out.println("Ingrese tamaño:");
			tamanio = input.nextLine().charAt(0);			
			tamanioValido = tamanio == TAMANIO_CHICO || tamanio == TAMANIO_MEDIANO || tamanio == TAMANIO_GRANDE || tamanio == FIN_DATOS; 				
			
			if (!tamanioValido) {
				System.out.println("Tamaño no válido");
			}
		} while (!tamanioValido);
		
		return tamanio;
	}
	
	private static int obtenerCantidadGustos() {
		int cantidad;
		
		do {
			System.out.println("Ingrese cantidad de gustos:");
			cantidad = Integer.parseInt(input.nextLine());			
			
			if (cantidad <= 0 || cantidad > 4) {
				System.out.println("Tamaño no válido");
			}
		} while (cantidad <= 0 || cantidad > 4);
		
		return cantidad;
	}
	
	private static double obtenerImporte() {
		double importe;
		
		do {
			System.out.println("Ingrese importe a cobrar:");
			importe = Double.parseDouble(input.nextLine());			
			
			if (importe < 0) {
				System.out.println("Importe no válido");
			}
		} while (importe < 0);
		
		return importe + COMISION_HELADERO;
	}
	
	private static String obtenerNombreComprador() {
		String nombre;
		
		do {
			System.out.println("Ingrese nombre del comprador:");
			nombre = input.nextLine();			
			
			if (nombre.isEmpty()) {
				System.out.println("Nombre no válido");
			}
		} while (nombre.isEmpty());
		
		return nombre;
	}
	
	private static String obtenerGusto() {
		String gusto;
		
		do {
			System.out.println("Ingrese nombre del gusto:");
			gusto = input.nextLine();			
			
			if (gusto.isEmpty()) {
				System.out.println("Gusto no válido");
			}
		} while (gusto.isEmpty());
		
		return gusto;
	}
	
	private static double obtenerCalorias() {
		double calorias;
		
		do {
			System.out.println("Ingrese cantidad de calorías:");
			calorias = Double.parseDouble(input.nextLine());			
			
			if (calorias < 0) {
				System.out.println("Calorías no válidas");
			}
		} while (calorias < 0);
		
		return calorias;
	}
}
