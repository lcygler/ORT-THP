package parcial1.casino.v2;

import java.util.Scanner;

public class Casino {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final int COSTO_RUL = 100, COSTO_BJK = 200, COSTO_PKR = 500;
        double dineroInicial, dineroDisponible, porcentajeRUL, porcentajeBJK, porcentajePKR;
        int resultado, costoJuego = 0, contadorTotal = 0, contadorRUL = 0, contadorBJK = 0, contadorPKR = 0;
        boolean permitidoJugar = true;
        String nombre, juego;

        do {
            System.out.println("Ingrese su nombre:");
            nombre = input.nextLine();
        } while (nombre.isEmpty());

        do {
            System.out.println("Ingrese dinero inicial:");
            dineroInicial = input.nextDouble();
            input.nextLine();
        } while (dineroInicial < 500);

        dineroDisponible = dineroInicial;

        while (permitidoJugar) {
            System.out.println("¿A qué juego desea jugar? (RUL/BJK/PKR):");
            juego = input.nextLine();

            if (juego.equals("RUL") || juego.equals("BJK") || juego.equals("PKR")) {
                switch (juego) {
                    case "RUL":
                        costoJuego = COSTO_RUL;
                        break;
                    case "BJK":
                        costoJuego = COSTO_BJK;
                        break;
                    case "PKR":
                        costoJuego = COSTO_PKR;
                        break;
                }

                System.out.println("El costo es " + costoJuego);
                
                if (dineroDisponible >= costoJuego) {
                    dineroDisponible -= costoJuego;                    
                    do {
                        System.out.println("¿Cuál fue el resultado? (0/1/2):");
                        resultado = input.nextInt();
                        input.nextLine();
                    } while (resultado < 0 || resultado > 2);

                    if (resultado == 1) {
                        dineroDisponible += costoJuego;
                    } else if (resultado == 2) {
                        dineroDisponible += costoJuego * 2;
                    }

                    switch (juego) {
                        case "RUL":
                            contadorRUL++;
                            break;
                        case "BJK":
                            contadorBJK++;
                            break;
                        case "PKR":
                            contadorPKR++;
                            break;
                    }
                    
                    contadorTotal++;
                } else {
                    System.out.println("Dinero insuficiente. Saldo: " + dineroDisponible);
                }
            } else {
                System.out.println("Juego no válido");
            }

            if (dineroDisponible < 0.2 * dineroInicial ||
                (dineroDisponible < COSTO_RUL && dineroDisponible < COSTO_BJK && dineroDisponible < COSTO_PKR) ||
                dineroDisponible >= 5000) {
                permitidoJugar = false;
            }
        }

        porcentajeRUL = (double) contadorRUL / contadorTotal * 100;
        porcentajeBJK = (double) contadorBJK / contadorTotal * 100;
        porcentajePKR = (double) contadorPKR / contadorTotal * 100;

        System.out.println("El dinero restante es: " + dineroDisponible);
        System.out.println("Cantidad de veces que jugó a la ruleta: " + contadorRUL);
        System.out.println("Cantidad de veces que jugó al blackjack: " + contadorBJK);
        System.out.println("Cantidad de veces que jugó al póker: " + contadorPKR);
        System.out.println("El porcentaje de veces que jugó a la ruleta es: " + porcentajeRUL + "%");
        System.out.println("El porcentaje de veces que jugó al blackjack es: " + porcentajeBJK + "%");
        System.out.println("El porcentaje de veces que jugó al póker es: " + porcentajePKR + "%");

        input.close();
    }
}
