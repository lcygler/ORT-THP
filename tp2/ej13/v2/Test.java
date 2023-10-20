package tp2.ej13.v2;

public class Test {
	public static void main(String[] args) {
		SuperHeroe superHeroe1 = new SuperHeroe("Batman", 90, 70, 0);
		SuperHeroe superHeroe2 = new SuperHeroe("Superman", 95, 60, 70);
		SuperHeroe superHeroe3 = new SuperHeroe("Spiderman", 100, 80, 50);
		SuperHeroe superHeroe4 = new SuperHeroe("Hulk", 80, 100, 50);

		mostrarResultado(superHeroe1, superHeroe2);
		mostrarResultado(superHeroe2, superHeroe1);
		mostrarResultado(superHeroe3, superHeroe4);
		mostrarResultado(superHeroe4, superHeroe3);
	}

	private static void mostrarResultado(SuperHeroe superHeroe1, SuperHeroe superHeroe2) {
		String resultado = superHeroe1.competir(superHeroe2);
		System.out.println(superHeroe1.getNombre() + " vs. " + superHeroe2.getNombre() + ": " + resultado);
	}
}
