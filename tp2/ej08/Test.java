package tp2.ej08;

public class Test {
	public static void main(String[] args) {
		TarjetaDeCredito tarjeta = new TarjetaDeCredito("4145-4141-2222-1111", "Juan Perez", 10000);

		System.out.println("Tarjeta: " + tarjeta);

		// Compra 1
		procesarCompra(tarjeta, 4000);
		mostrarDisponible(tarjeta);
		mostrarTarjeta(tarjeta);

		// Compra 2
		procesarCompra(tarjeta, 2000);
		mostrarDisponible(tarjeta);
		mostrarTarjeta(tarjeta);

		// Modificar límite
		modificarLimite(tarjeta, 3000);

		// Compra 3
		procesarCompra(tarjeta, 4000);
		mostrarDisponible(tarjeta);
		mostrarTarjeta(tarjeta);
	}

	private static void mostrarTarjeta(TarjetaDeCredito tarjeta) {
		System.out.println(tarjeta);
	}

	private static void mostrarDisponible(TarjetaDeCredito tarjeta) {
		System.out.println("Monto disponible: $" + tarjeta.montoDisponible() + "\n");
	}

	private static void modificarLimite(TarjetaDeCredito tarjeta, double nuevoLimite) {
		tarjeta.actualizarLimite(nuevoLimite);
		System.out.println("\nNuevo límite de compra: $" + nuevoLimite);
	}

	private static void procesarCompra(TarjetaDeCredito tarjeta, double compra) {
		boolean compraExitosa = tarjeta.realizarCompra(compra);

		System.out.println("\nRealizando compra de $" + compra);

		if (compraExitosa) {
			System.out.println("¡Compra exitosa!");
		} else {
			System.out.println("Compra fallida. Límite insuficiente");
		}
	}
}
