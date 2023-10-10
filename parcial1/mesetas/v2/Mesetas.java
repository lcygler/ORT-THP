package parcial1.mesetas.v2;

import java.util.Scanner;

public class Mesetas {
	// Declaración de constantes
    public static final Scanner input = new Scanner(System.in);
    public static final int NUMERO_MIN = 0;
    public static final int NUMERO_MAX = 100;
    public static final int FIN = 0;

    // Declaración de variables de clase
    public static int numeroAnterior = 0;
    public static int numeroMeseta = 0;
    public static int cantidadMesetas = 0;
    public static int longitudActual = 1;
    public static int longitudMaxima = 0;

    public static void main(String[] args) {
        int numero;

        numero = ingresarNumero();

        while (numero != FIN) {
            if (numero == numeroAnterior) {
                longitudActual++; // Incrementar contador de meseta actual
            } else if (longitudActual > 1) {
                registrarMeseta(); // Registrar nueva meseta
            }

            numeroAnterior = numero;
            numero = ingresarNumero();
        }

        if (longitudActual > 1) {
            registrarMeseta(); // Registrar última meseta
        }

        if (cantidadMesetas > 0) {
            imprimirMesetas(); // Imprimir datos de mesetas
        } else {
            System.out.println("No se detectaron mesetas");
        }

        input.close();
    }   

    private static int ingresarNumero() {
        int numero;

        do {
            System.out.println("Ingrese un número:");
            numero = Integer.parseInt(input.nextLine());
        } while (numero < NUMERO_MIN || numero > NUMERO_MAX);

        return numero;
    }

    private static void registrarMeseta() {
        cantidadMesetas++; // Incrementar contador de mesetas totales
        
        if (longitudActual > longitudMaxima) {
            longitudMaxima = longitudActual; // Guardar longitud de mayor meseta
            numeroMeseta = numeroAnterior; // Guardar valor de mayor meseta
        }
        
        longitudActual = 1; // Resetear longitud de meseta actual
    }
    
    private static void imprimirMesetas() {
        System.out.println("La cantidad de mesetas es: " + cantidadMesetas);
        System.out.print("La meseta más extensa es: ");
        
        for (int i = 0; i < longitudMaxima; i++) {
            System.out.print(numeroMeseta);

            if (i < longitudMaxima - 1) {
                System.out.print("-");
            }
        }
        
        System.out.println("\nLa meseta más extensa tiene: " + longitudMaxima + " números");
    }
}
