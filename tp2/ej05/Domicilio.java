package tp2.ej05;

public class Domicilio {
	private String calle;
	private String numero;
	private String ciudad;

	public Domicilio() {
		this.calle = "";
		this.numero = "";
		this.ciudad = "";
	}

	public Domicilio(String calle, String numero, String ciudad) {
		setCalle(calle);
		setNumero(numero);
		setCiudad(ciudad);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		if (calle != null) {
			this.calle = calle;
		}
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if (numero != null) {
			this.numero = numero;
		}
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		if (ciudad != null) {
			this.ciudad = ciudad;
		}
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + "]";
	}
}
