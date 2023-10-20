package tp2.ej12;

public class Calculadora {
	public static int sumar(int numero1, int numero2) {
		return numero1 + numero2;
	}

	public static int restar(int numero1, int numero2) {
		return numero1 - numero2;
	}

	public static int multiplicar(int numero1, int numero2) {
		return numero1 * numero2;
	}

	public static int dividir(int numero1, int numero2) {
		if (numero2 != 0) {
			return numero1 / numero2;
		} else {
			return 0;
		}
	}
}
