package tp2.ej05;

public class Test {
	public static void main(String[] args) {
		// Persona 1
		Persona persona1 = new Persona();
		persona1.ponerNombre("Fulano");
		persona1.ponerApellido("Gómez");
		
		Domicilio domicilio1 = new Domicilio();
		domicilio1.setCalle("Pepe Argento");
		domicilio1.setNumero("1212");
		domicilio1.setCiudad("Salta");
		persona1.ponerDomicilio(domicilio1);
		
		System.out.println(persona1.obtenerNombreCompleto());
		System.out.println(persona1.obtenerDomicilio().toString());
		System.out.println();
		
		// Persona 2
		Persona persona2 = new Persona();
		persona2.ponerNombre("Juan");
		persona2.ponerApellido("Pérez");	
		
		Domicilio domicilio2 = new Domicilio("Don Ramón", "1234", "Buenos Aires");
		persona2.ponerDomicilio(domicilio2);
		
		System.out.println(persona2.obtenerNombreCompleto());
		System.out.println(persona2.obtenerDomicilio().toString());
		
		domicilio2.setCalle("Don Ramona");		
		System.out.println(persona2.obtenerDomicilio().toString());
		System.out.println();
		
		// Persona 3
		Persona persona3 = new Persona();
		persona3.ponerNombre("Roberto");
		persona3.ponerApellido("Carlos");
		
		persona3.ponerDomicilio("Suipacha", "1111", "Bariloche");	
		
		System.out.println(persona3.obtenerNombreCompleto());
		System.out.println(persona3.obtenerDomicilio().toString());
		
		persona3.obtenerDomicilio().setNumero("4321");
		System.out.println(persona3.obtenerDomicilio().toString());
	}
}
