package tp2.ej07;

public class LectoraDvd {
	private String marca;
	private boolean puedeGrabar;

	/*
	public LectoraDvd() {
		setMarca("");
		setPuedeGrabar(false);
	}
	*/

	public LectoraDvd(String marca, boolean puedeGrabar) {
		setMarca(marca);
		setPuedeGrabar(puedeGrabar);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null) {
			this.marca = marca;
		}
	}

	public boolean getPuedeGrabar() {
		return puedeGrabar;
	}

	public void setPuedeGrabar(boolean puedeGrabar) {
		this.puedeGrabar = puedeGrabar;
	}
}
