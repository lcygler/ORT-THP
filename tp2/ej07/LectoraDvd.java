package tp2.ej07;

public class LectoraDVD {
	private String marca;
	private boolean puedeGrabar;

	public LectoraDVD(String marca, boolean puedeGrabar) {
		setMarca(marca);
		setPuedeGrabar(puedeGrabar);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca != null && !marca.isEmpty()) {
			this.marca = marca;
		}
	}

	public boolean getPuedeGrabar() {
		return puedeGrabar;
	}

	public void setPuedeGrabar(boolean puedeGrabar) {
		this.puedeGrabar = puedeGrabar;
	}

	@Override
	public String toString() {
		return "LectoraDVD [marca=" + marca + ", puedeGrabar=" + puedeGrabar + "]";
	}
}
