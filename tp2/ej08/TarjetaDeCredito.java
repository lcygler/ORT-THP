package tp2.ej08;

public class TarjetaDeCredito {
	private String numero;
	private String titular;
	private double limiteDeCompra;
	private double acumuladoActual;

	public TarjetaDeCredito(String numero, String titular, double limiteDeCompra) {
		this.numero = numero;
		this.titular = titular;
		this.limiteDeCompra = limiteDeCompra;
		this.acumuladoActual = 0;
	}

	public String getNumero() {
		return numero;
	}

	private void setNumero(String numero) {
		if (numero != null && !numero.isEmpty()) {
			this.numero = numero;
		}
	}

	public String getTitular() {
		return titular;
	}

	private void setTitular(String titular) {
		if (titular != null && !titular.isEmpty()) {
			this.titular = titular;
		}
	}

	public double getLimiteDeCompra() {
		return limiteDeCompra;
	}

	private void setLimiteDeCompra(double limiteDeCompra) {
		if (limiteDeCompra > 0) {
			this.limiteDeCompra = limiteDeCompra;
		}
	}

	public double getAcumuladoActual() {
		return acumuladoActual;
	}

	public double montoDisponible() {
		double montoDisponible = limiteDeCompra - acumuladoActual;
		return montoDisponible >= 0 ? montoDisponible : 0;
	}

	private boolean compraPosible(double monto) {
		return monto <= montoDisponible();
	}

	public void actualizarLimite(double nuevoLimite) {
		setLimiteDeCompra(nuevoLimite);
	}

	private void acumularGastoActual(double monto) {
		if (monto > 0) {
			acumuladoActual += monto;
		}
	}

	public boolean realizarCompra(double monto) {
		boolean compraPosible = compraPosible(monto);

		if (compraPosible) {
			acumularGastoActual(monto);
		}

		return compraPosible;
	}

	@Override
	public String toString() {
		return "TarjetaDeCredito [numero=" + numero + ", titular=" + titular + ", limiteDeCompra=" + limiteDeCompra
				+ ", acumuladoActual=" + acumuladoActual + "]";
	}
}
