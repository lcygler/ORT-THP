package tp2.ej14;

public class Promedio {
	private Contador contador;
	private Acumulador acumulador;

	public Promedio() {
		this.contador = new Contador();
		this.acumulador = new Acumulador();
	}

	public void incrementar(double cantidad) {
		contador.incrementar();
		acumulador.incrementar(cantidad);
	}

	public double obtenerValor() {
		if (contador.obtenerValor() > 0) {
			return acumulador.obtenerValor() / contador.obtenerValor();
		} else {
			return 0.0;
		}
	}
}
