package tp2.ej07;

public class Procesador {
	private static final double TEMPERATURA_MAXIMA = 100.0;
	private String marca;
	private String modelo;
	private double temperatura;

	public Procesador(String marca, String modelo, double temperatura) {
		setMarca(marca);
		setModelo(modelo);
		setTemperatura(temperatura);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null && !marca.isEmpty()) {
			this.marca = marca;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo != null && !modelo.isEmpty()) {
			this.modelo = modelo;
		}
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		if (temperatura > 0) {
			this.temperatura = temperatura;
		}

		if (temperatura > TEMPERATURA_MAXIMA) {
			notificarTemperatura();
		}
	}

	public void notificarTemperatura() {
		System.out.println("¡Alerta! La temperatura superó los " + TEMPERATURA_MAXIMA + " °C");
	}

	@Override
	public String toString() {
		return "Procesador [marca=" + marca + ", modelo=" + modelo + ", temperatura=" + temperatura + "]";
	}
}
