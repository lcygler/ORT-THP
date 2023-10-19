package tp2.ej03;

public class Persona {
	private String nombre;
	private String apellido;
	
	public Persona() {
		this.nombre = "";
		this.apellido = "";
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void ponerNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerApellido() {
		return apellido;
	}
	
	public void ponerApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String obtenerNombreCompleto() {
		return this.nombre + " " + this.apellido;
	}
}
