package tp2.ej07;

public class Computadora {
	private String marca;
	private TipoComputadora tipo;

	/*
	public Computadora() {
	    setMarca("");
	    setTipo(null);
	}
	*/
	
	public Computadora(String marca, TipoComputadora tipo) {
		setMarca(marca);
		setTipo(tipo);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null) {
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

	public void prender() {
		System.out.println("Prendiendo...");
	}

	public void apagar() {
		System.out.println("Apagando...");
	}
	
	public void reiniciar() {
		System.out.println("Reiniciando...");
	}
}
