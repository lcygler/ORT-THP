package parcial1.piedrapapeltijera;

import java.util.Scanner;

public class PiedraPapelTijera {
	public static final Scanner input = new Scanner(System.in);
	public static final String PIEDRA = "Piedra";
	public static final String PAPEL = "Papel";
	public static final String TIJERA = "Tijera";

  public static void main(String[] args) { 
    int puntajeObjetivo;
    int puntajeAna = 0;
    int puntajeBartolo = 0;
    String eleccionAna;
    String eleccionBartolo;
    String ganador;
    String ganadorFinal;
    
    do {
      System.out.println("¿A cuántos puntos se jugará?");
      puntajeObjetivo = Integer.parseInt(input.nextLine());
    } while (puntajeObjetivo <= 0);
   
    while (puntajeAna < puntajeObjetivo && puntajeBartolo < puntajeObjetivo) {
    	do {
    		System.out.println("Elección de Ana: ");
    	    eleccionAna = input.nextLine();
    	} while (!eleccionAna.equals(PIEDRA) && !eleccionAna.equals(PAPEL) && !eleccionAna.equals(TIJERA));
    	
    	do {
    		System.out.println("Elección de Bartolo: ");
    		eleccionBartolo = input.nextLine();
    	} while (!eleccionBartolo.equals(PIEDRA) && !eleccionBartolo.equals(PAPEL) && !eleccionBartolo.equals(TIJERA));

      ganador = determinarGanador(eleccionAna, eleccionBartolo);

      if (ganador.equals("Ana")) {
        puntajeAna++;
      } else if (ganador.equals("Bartolo")) {
        puntajeBartolo++;
      }
      
      if (ganador.equals("Empate")) {
    	  System.out.println("Empate");
    	} else {
    	  System.out.println("Ganador de la ronda: " + ganador);
    	}
    }

    ganadorFinal = (puntajeAna > puntajeBartolo) ? "Ana" : "Bartolo";
    System.out.println("Ganador del juego: " + ganadorFinal);
    
    input.close();
  }

  private static String determinarGanador(String eleccionAna, String eleccionBartolo) {
    if (eleccionAna.equals(eleccionBartolo)) {
      return "Empate";
    } else if (eleccionAna.equals(PIEDRA) && eleccionBartolo.equals(PAPEL)) {
      return "Ana";
    } else if (eleccionAna.equals(PAPEL) && eleccionBartolo.equals(PIEDRA)) {
      return "Ana";
    } else if (eleccionAna.equals(TIJERA) && eleccionBartolo.equals(PAPEL)) {
      return "Ana";
    } else {
      return "Bartolo";
    }
  }
}
