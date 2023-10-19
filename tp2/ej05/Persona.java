package tp2.ej05;

public class Persona {
	private String nombre;
	private String apellido;
	private Domicilio domicilio;
	
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
	
	public Domicilio obtenerDomicilio() {
		return domicilio;
	}
	
	public void ponerDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	public void ponerDomicilio(String calle, String numero, String ciudad) {
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle(calle);
		domicilio.setNumero(numero);
		domicilio.setCiudad(ciudad);
		this.domicilio = domicilio;
	}
	
	public String obtenerNombreCompleto() {
		return nombre + " " + apellido;
	}
	
	public void mostrarDomicilio() {
		if (domicilio != null) {
			System.out.println("El domicilio es " + domicilio);	
		} else {
			System.out.println("El domicilio no existe");	
		}
	}
}
