package ejemplos.enums.mes;

public class Test {
	public static void main(String[] args) {
		Mes mesActual = Mes.JUNIO;
		int numeroMesActual = mesActual.getNumero();

		System.out.println("mesActual: " + mesActual); // JUNIO
		System.out.println("numeroMesActual: " + numeroMesActual); // 6

		System.out.println("\nMeses:");
		for (Mes mes : Mes.values()) {
			System.out.println(mes);
		}

		System.out.println("\nMétodos enum:");
		System.out.println("name: " + mesActual.name()); // JUNIO
		System.out.println("ordinal: " + mesActual.ordinal()); // 5
		System.out.println("values: " + Mes.values()); // Array

	}
}
