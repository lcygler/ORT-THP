package ejemplos.enums.estado;

public class Test {
	public static void main(String[] args) {
		Estado estadoActivo = Estado.ACTIVO;
		Estado estadoInactivo = Estado.INACTIVO;

		System.out.println("Descripción de ACTIVO: " + estadoActivo.getDescripcion());
		System.out.println("Descripción de INACTIVO: " + estadoInactivo.getDescripcion());

		if (estadoActivo == Estado.ACTIVO) {
			System.out.println("\nEl estado está activo");
		} else {
			System.out.println("\nEl estado no está activo");
		}

		System.out.println("\nTodas las descripciones de los estados:");
		for (Estado estado : Estado.values()) {
			System.out.println(estado.name() + ": " + estado.getDescripcion());
		}
	}
}
