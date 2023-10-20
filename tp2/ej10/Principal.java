package tp2.ej10;

public class Principal {
	public static void main(String[] args) {
		Robot robot = new Robot("Bot");
		Persona persona1 = new Persona("Juan", "Rivera");
		Persona persona2 = new Persona("Carlos", "Cáceres");

		robot.saludar();
		robot.saludar(persona1);
		robot.saludar(persona2);
	}
}
