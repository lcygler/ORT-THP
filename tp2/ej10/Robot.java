package tp2.ej10;

public class Robot {
    private String nombre;

    public Robot(String nombre) {
        if (nombre != null) {
			this.nombre = nombre;
		}
    }

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + ". ¿En qué puedo ayudarte?");
    }

    public void saludar(String nombrePersona) {
		System.out.println("Hola " + nombrePersona + ", mi nombre es " + nombre + ". ¿En qué puedo ayudarte?");
	}
}
