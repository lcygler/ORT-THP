package tp2.ej07;

public class Procesador {
	private String marca;
	private String modelo;
	private double temperatura;

	/*
	public Procesador() {
		setMarca("");
		setModelo("");
		setTemperatura(0);
	}
	*/

	public Procesador(String marca, String modelo, double temperatura) {
		setMarca(marca);
		setModelo(modelo);
		setTemperatura(temperatura);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null) {
			this.marca = marca;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo != null) {
			this.modelo = modelo;
		}
	}
	
	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	public void notificarTemperatura() {
		System.out.println("La temperatura superó los");
	}
}
