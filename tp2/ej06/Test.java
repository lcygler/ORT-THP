package tp2.ej06;

public class Test {
	public static void main(String[] args) {
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		dado1.tirarDado();
		dado2.tirarDado();

		if (dado1.getValor() == dado2.getValor()) {
			System.out.println("Los dados son iguales con valor " + dado1.getValor());
		} else if (dado1.getValor() > dado2.getValor()) {
			System.out.println("El dado 1 es el mayor con valor " + dado1.getValor());
		} else {
			System.out.println("El dado 2 es el mayor con valor " + dado2.getValor());
		}
	}
}
