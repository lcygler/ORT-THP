package tp2.ej02;

public class Persona {
	private String nombre;
	private String apellido;
	
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
}
