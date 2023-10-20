package tp2.ej09;

public class CuentaBancaria {
	private String cbu;
	private TipoCuenta tipo;
	private double saldo;
	private Persona titular;

	public CuentaBancaria(TipoCuenta tipo, Persona titular) {
		this.tipo = tipo;
		this.saldo = 0;
		this.titular = titular;  // 1. Registrar el titular. Se necesita el DNI para generar el CBU
		this.cbu = generarCBU(); // 2. Generar el CBU. Si se hace al revés -> NullPointerException
	}

	public String getCbu() {
		return cbu;
	}
	
	public TipoCuenta getTipo() {
		return tipo;
	}

	private void setTipo(TipoCuenta tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
	}

	public Persona getTitular() {
		return titular;
	}

	private void setTitular(Persona titular) {
		if (titular != null) {
			this.titular = titular;
		}
	}

	private String generarCBU() {
		String cbu;
		String dni = titular.getDni();
		cbu = (tipo.ordinal() + 10) + "-" + dni + "-" + dni.charAt(dni.length() - 1);
		return cbu;
	}

	public double obtenerSaldo() {
		return saldo;
	}

	public void depositar(double monto) {
		if (monto > 0) {
			saldo += monto;
		}
	}

	public boolean extraer(double monto) {
		if (monto > 0 && monto <= saldo) {
			saldo -= monto;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "CuentaBancaria [cbu=" + cbu + ", tipo=" + tipo + ", saldo=" + saldo + ", titular=" + titular.toString() + "]";
	}
}
