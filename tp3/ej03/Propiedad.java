package tp3.ej03;

public class Propiedad {
	private String direccion;
	private double precio;
	private TipoPropiedad tipo;

	public Propiedad(String direccion, double precio, TipoPropiedad tipo) {
		setDireccion(direccion);
		setPrecio(precio);
		setTipo(tipo);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion != null) {
			this.direccion = direccion;
		}
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoPropiedad getTipo() {
		return tipo;
	}

	private void setTipo(TipoPropiedad tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
	}

	@Override
	public String toString() {
		return "Propiedad [direccion=" + direccion + ", precio=" + precio + ", tipo=" + tipo + "]";
	}
}
