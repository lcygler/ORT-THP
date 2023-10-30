package tp3.ej06;

public class Test {
	public static void main(String[] args) {
		ORTFlix ortflix = new ORTFlix();

		System.out.println("Alta cliente: " + ortflix.darDeAlta("123", "Fulano", Tipo.STANDARD));
		System.out.println("\nAgregar película: " + ortflix.agregarPelicula("Avengers", Tipo.STANDARD));
		System.out.println("\nVer película: " + ortflix.verPelicula("123", "Avengers"));

		ortflix.mostrarClientes();
		ortflix.mostrarPeliculas();

		System.out.println("\nActualizar saldo: " + ortflix.actualizarSaldo("123", 100));
		ortflix.mostrarClientes();
		
		System.out.println("\nCliente con DNI 123 dado de baja");
		ortflix.darDeBaja("123");
		ortflix.mostrarClientes();
		
		System.out.println("\nAlta cliente: " + ortflix.darDeAlta("123", "Fulano", Tipo.STANDARD));
		ortflix.mostrarListaNegra();
		
		System.out.println("\nDepurar lista negra:");
		ortflix.depurarListaNegra(500);
		ortflix.mostrarListaNegra();
	}
}
