package parcial1.encuestapoda;

import java.util.Scanner;

public class EncuestaPoda {
	public static final Scanner input = new Scanner(System.in);
	public static final char SI = 'S';
	public static final char NO = 'N';
	public static final char BLANCO = 'B';
	public static final char FIN = 'F';
	public static final int EDAD_MINIMA = 18;
	
	public static void main(String[] args) {
		char voto;
		int edad;
		int edadAcumulada  = 0;
		int votosSi = 0;
		int votosNo = 0;
		int votosBlanco = 0;
		int totalVotos = 0;
		double porcentajeNo = 0.0;
		double edadPromedio = 0.0;
		String opcionGanadora = "";
		
		voto = obtenerVoto();
		
		while (voto != FIN) {
			edad = obtenerEdad();
			edadAcumulada += edad;
			
			 if (voto == SI) {
                 votosSi++;
             } else if (voto == NO) {
                 votosNo++;
             } else {
                 votosBlanco++;
             }
			
			totalVotos++;
			voto = obtenerVoto();
		}
		
		if (totalVotos > 0) {
			// Se considera que no habrá empate
			if (votosSi > votosNo && votosSi > votosBlanco) {
	            opcionGanadora = "Si";
	        } else if (votosNo > votosBlanco) {
	            opcionGanadora = "No";
	        } else {
	            opcionGanadora = "Indeterminado";
	        }
				
			porcentajeNo = (double) votosNo / totalVotos * 100;		
			edadPromedio = (double) edadAcumulada / totalVotos;		
			
			System.out.println("La opción ganadora es: " + opcionGanadora);
			System.out.println("El porcentaje de \"No\" es: " + porcentajeNo + "%");
			System.out.println("El promedio de edad es: " + edadPromedio);
		} else {
			System.out.println("No se ingresaron datos");
		}
		
		input.close();
	}
	
	private static char obtenerVoto() {
	    char voto;
	    boolean votoValido;

	    do {
	    	System.out.println("¿Desea podar los árboles? (S/N/B/F):");
	        voto = Character.toUpperCase(input.nextLine().charAt(0));
	        
	        votoValido = voto == SI || voto == NO || voto == BLANCO || voto == FIN;

	        if (!votoValido) {
	            System.out.println("Voto no válido");
	        }
	    } while (!votoValido);

	    return voto;
	}
	
	private static int obtenerEdad() {
		int edad;
		
		do {
			System.out.println("Ingrese su edad:");
			edad = Integer.parseInt(input.nextLine());
			
			if (edad < EDAD_MINIMA) {
                System.out.println("Edad no válida");
            }
		} while (edad < EDAD_MINIMA);
		
		return edad;
	}
}
