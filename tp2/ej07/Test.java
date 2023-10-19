package tp2.ej07;

public class Test {
	public static void main(String[] args) {
		Procesador procesador = new Procesador("Intel", "i7", 50.0);
		LectoraDVD lectoraDVD = new LectoraDVD("LG", true);
		Computadora computadora = new Computadora("HP", TipoComputadora.DESKTOP, procesador, lectoraDVD);

		Persona persona = new Persona("Juan", "Pérez", "12345678");
		persona.setComputadora(computadora);

		System.out.println(persona.toString());
		System.out.println(persona.getComputadora().toString());

		persona.trabajar();
		persona.getComputadora().prender();
		procesador.setTemperatura(150);
		persona.getComputadora().apagar();
		persona.descansar();
	}
}
