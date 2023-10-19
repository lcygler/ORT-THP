package tp2.ej04;

public class Test {
	public static void main(String[] args) {
		Persona persona1 = new Persona();
		Persona persona2 = new Persona();
				
		persona1.ponerNombre("Fulano");
		persona1.ponerApellido("Gómez");
		
		persona2.ponerNombre("Juan");
		persona2.ponerApellido("Pérez");
		
		System.out.println(persona1.obtenerNombreCompleto());
		System.out.println(persona2.obtenerNombreCompleto());
	}
}
