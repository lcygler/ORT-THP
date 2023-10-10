package ejemplos.enums.estado;

public enum Estado {
    ACTIVO("El estado está activo"),
    INACTIVO("El estado está inactivo");

	private final String descripcion;

	private Estado(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
