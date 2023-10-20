package tp2.ej14;

public class Acumulador {
	private double valor;

	public Acumulador() {
		this.valor = 0.0;
	}

	public void incrementar(double cantidad) {
		valor += cantidad;
	}

	public double obtenerValor() {
		return valor;
	}
}