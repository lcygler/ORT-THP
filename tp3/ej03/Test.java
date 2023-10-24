package tp3.ej03;

public class Test {
	public static void main(String[] args) {
		Inmobiliaria inmobiliaria = new Inmobiliaria();

		Barrio barrio1 = new Barrio("Bar1");
		barrio1.agregarPropiedad(new Propiedad("Calle 1", 150000, TipoPropiedad.DEPTO));
		barrio1.agregarPropiedad(new Propiedad("Calle 2", 200000, TipoPropiedad.CASA));

		Barrio barrio2 = new Barrio("Bar2");
		barrio2.agregarPropiedad(new Propiedad("Calle 3", 180000, TipoPropiedad.PH));
		barrio2.agregarPropiedad(new Propiedad("Calle 4", 220000, TipoPropiedad.DEPTO));

		inmobiliaria.agregarBarrio(barrio1);
		inmobiliaria.agregarBarrio(barrio2);

		mostrarPropiedades(inmobiliaria);

		System.out.println("\nPropiedades de tipo DEPTO:");
		inmobiliaria.mostrarPropiedades(TipoPropiedad.DEPTO);
		System.out.println("\n--");

		System.out.println("\nPropiedades de tipo DEPTO en barrio " + barrio1.getNombre() + ":");
		barrio1.mostrarPropiedades(TipoPropiedad.DEPTO);
		System.out.println("\n--");

		System.out.println("\nBarrios con más propiedades:");
		inmobiliaria.mostrarBarriosMaxProp();
		System.out.println("\n--");

		eliminarPropiedad(inmobiliaria, "Calle 1");
		mostrarPropiedades(inmobiliaria);

		eliminarPropiedad(inmobiliaria, "Calle 100");
		mostrarPropiedades(inmobiliaria);
		
		System.out.println("\nBarrio: " + barrio2.getNombre());
		System.out.println(barrio2.toString());
	}
	
	private static void mostrarPropiedades(Inmobiliaria inmobiliaria) {
		System.out.println("\nTodas las propiedades:");
		inmobiliaria.mostrarPropiedades();
		System.out.println("\n--");
	}
	
	private static void eliminarPropiedad(Inmobiliaria inmobiliaria, String direccion) {
		boolean propiedadEliminada = inmobiliaria.borrarPropiedad(direccion);
		
		if (propiedadEliminada) {
			System.out.println("\nPropiedad eliminada");
		} else {
			System.out.println("\nNo se encontró la propiedad");
		}
	}
}
