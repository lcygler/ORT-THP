package tp2.ej11;

public class Turnera {
	private static int ultimoNumero;
	private static final int NUMERO_INICIAL = 0;

	private Turnera() {
		ultimoNumero = NUMERO_INICIAL;
	}

	public static void otorgarProximoNumero() {
		ultimoNumero++;
	}

	public static int obtenerUltimoNumeroOtorgado() {
		return ultimoNumero;
	}

	public static void resetearContador() {
		ultimoNumero = 0;
	}

	public static void resetearContador(int numero) {
		if (numero >= 0) {
			ultimoNumero = numero;
		}
	}

}
