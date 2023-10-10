package parcial1.adivinaelnumero.v2;

import java.util.Scanner;

public class AdivinaElNumero {
    public static final Scanner input = new Scanner(System.in);
    public static final int TOPE_MIN = 1;
    public static final int TOPE_MAX = 10;

    public static void main(String[] args) {
    	 int rondas, numeroPrograma, numero1, numero2;
    	 String jugador1, jugador2, ganador = "";

    	// Solicitar nombres de los jugadores
        jugador1 = obtenerNombre();
        jugador2 = obtenerNombre();
        
        // Obtener la cantidad de rondas
        rondas = obtenerRondas();
        
        // Iniciar el juego por cada ronda
        for (int i = 0; i < rondas; i++) {
            numeroPrograma = obtenerNumeroPrograma();
            numero1 = obtenerNumero(jugador1);
            numero2 = obtenerNumero(jugador2);

            System.out.println("El número pensado por el programa es: " + numeroPrograma);
            
            // Verificar si hay un ganador o empate
            if (numero1 == numeroPrograma && numero2 == numeroPrograma) {
                ganador = "Empate";
            } else if (numero1 == numeroPrograma) {
                ganador = jugador1;
            } else if (numero2 == numeroPrograma) {
                ganador = jugador2;
            }
            
         // Si hay un ganador o empate, salir del bucle
            if (!ganador.isEmpty()) {
            	break;
            }
        }
        
        // Mostrar el resultado del juego
        if (ganador.equals(jugador1) || ganador.equals(jugador2)) {
        	System.out.println("Ganó " + ganador);
        } else if (ganador.equals("Empate")) {
        	System.out.println("Hubo un empate");
        } else {
            System.out.println("Perdieron ambos");
        }
        
        input.close();
    }

 // Función para obtener el nombre del jugador
    private static String obtenerNombre() {
        String nombre;
        
        do {
            System.out.println("Ingrese el nombre del jugador:");
            nombre = input.nextLine();
        } while (nombre.isEmpty());
        
        return nombre;
    }

 // Función para obtener la cantidad de rondas
    private static int obtenerRondas() {
        int rondas;
        
        do {
            System.out.println("Ingrese la cantidad de rondas:");
            rondas = Integer.parseInt(input.nextLine());
        } while (rondas < 1);
        
        return rondas;
    }

 // Función para obtener el número ingresado por el jugador
    private static int obtenerNumero(String jugador) {
        int numero;
        
        do {
            System.out.println(jugador + ", ingrese un número (1-10):");
            numero = Integer.parseInt(input.nextLine());
        } while (numero < 1 || numero > 10);
        
        return numero;
    }

 // Función para obtener un número aleatorio del programa
    private static int obtenerNumeroPrograma() {
    	return TOPE_MIN + (int) (Math.random() * (TOPE_MAX - TOPE_MIN + 1));
    }
}
