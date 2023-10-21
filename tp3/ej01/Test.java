package tp3.ej01;

public class Test {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Domicilio domicilio1 = new Domicilio("Suipacha", "1234", "Buenos Aires");
		Domicilio domicilio2 = new Domicilio("Monteagudo", "4321", "Tierra del Fuego");

		// Agregar personas
		System.out.println("Agregar personas:");
		System.out.println(agenda.agregarPersona("12345678", "Juan", "30", domicilio1));
		System.out.println(agenda.agregarPersona("23456789", "Maria", "25", domicilio1));
		System.out.println(agenda.agregarPersona("34567890", "Pedro", "35", domicilio1));
		mostrarAgenda(agenda);

		// Agregar persona que ya existe
		System.out.println("\nAgregar persona que ya existe:");
		System.out.println(agenda.agregarPersona("12345678", "Pepe", "40", domicilio1));
		mostrarAgenda(agenda);
		
		// Eliminar persona
		System.out.println("\nEliminar persona:");
		System.out.println(agenda.removerPersona("23456789"));
		mostrarAgenda(agenda);

		// Eliminar persona que no existe
		System.out.println("\nEliminar persona que no existe:");
		System.out.println(agenda.removerPersona("11111111"));
		mostrarAgenda(agenda);
		
		// Modificar domicilio
		System.out.println("\nModificar domicilio:");
		System.out.println(agenda.modificarDomicilio("12345678", domicilio2));
		mostrarAgenda(agenda);

		// Modificar domicilio de persona que no existe
		System.out.println("\nModificar domicilio de persona que no existe:");
		System.out.println(agenda.modificarDomicilio("11111111", domicilio1));
		mostrarAgenda(agenda);
		
		// Devolver último elemento
		System.out.println("\nDevolver último elemento:");
		System.out.println(agenda.devolverUltimo());
		mostrarAgenda(agenda);
		
		// Eliminar todos los elementos
		System.out.println("\nEliminar todos los elementos");
		agenda.eliminarTodosElementosAMano();
		mostrarAgenda(agenda);
	}

	private static void mostrarAgenda(Agenda agenda) {
		System.out.println("\nAgenda:");
		agenda.listarPersonas();
		System.out.println("\n--");
	}
}
