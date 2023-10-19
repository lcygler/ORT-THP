package tp2.ej06;

public class Dado {
	private static final int CANTIDAD_CARAS = 6;
	private int valor;

	public Dado() {
		this.valor = 0;
	}

	public int getValor() {
		return valor;
	}

	public void tirarDado() {
		valor = (int) (Math.random() * CANTIDAD_CARAS + 1);
	}
}
