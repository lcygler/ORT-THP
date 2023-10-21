package tp3.ej01;

public class Domicilio {
	private String calle;
	private String altura;
	private String barrio;

	public Domicilio(String calle, String altura, String barrio) {
		setCalle(calle);
		setAltura(altura);
		setBarrio(barrio);
	}

	public String getCalle() {
		return calle;
	}

	private void setCalle(String calle) {
		if (calle != null && !calle.isEmpty()) {
			this.calle = calle;
		}
	}

	public String getAltura() {
		return altura;
	}

	private void setAltura(String altura) {
		if (altura != null && !altura.isEmpty()) {
			this.altura = altura;
		}
	}

	public String getBarrio() {
		return barrio;
	}

	private void setBarrio(String barrio) {
		if (barrio != null && !barrio.isEmpty()) {
			this.barrio = barrio;
		}
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", altura=" + altura + ", barrio=" + barrio + "]";
	}
	
	/* Para el diagrama en NS+
	public String toString() {
		String cadena;
		
		cadena = "Domicilio [calle=" + calle;
		cadena += ", altura=" + altura;
		cadena += ", barrio=" + barrio + "]";
		
		return cadena;
	}
	*/
}
