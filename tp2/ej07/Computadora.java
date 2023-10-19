package tp2.ej07;

public class Computadora {
	private String marca;
	private TipoComputadora tipo;
	private Procesador procesador;
	private LectoraDVD lectoraDVD;

	public Computadora(String marca, TipoComputadora tipo, Procesador procesador, LectoraDVD lectoraDVD) {
		setMarca(marca);
		setTipo(tipo);
		setProcesador(procesador);
		setLectoraDVD(lectoraDVD);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null && !marca.isEmpty()) {
			this.marca = marca;
		}
	}

	public TipoComputadora getTipo() {
		return tipo;
	}

	public void setTipo(TipoComputadora tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		if (procesador != null) {
			this.procesador = procesador;
		}
	}

	public LectoraDVD getLectoraDVD() {
		return lectoraDVD;
	}

	public void setLectoraDVD(LectoraDVD lectoraDVD) {
		if (lectoraDVD != null) {
			this.lectoraDVD = lectoraDVD;
		}
	}

	public void prender() {
		System.out.println("La computadora está encendida");
	}

	public void apagar() {
		System.out.println("La computadora está apagada");
	}

	public void reiniciar() {
		System.out.println("La computadora se está reiniciando");
	}
	
	@Override
	public String toString() {
		return "Computadora [marca=" + marca + ", tipo=" + tipo + ", procesador=" + procesador.toString()
				+ ", lectoraDVD=" + lectoraDVD.toString() + "]";
	}
}
