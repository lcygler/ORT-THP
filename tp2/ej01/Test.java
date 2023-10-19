package tp2.ej01;

public class Test {
	public final static int MINIMO = 1;
	public final static int MAXIMO = 100;

	public static void main(String[] args) {
		int num1, num2, suma;
		
		Ejercicio1 myObj = new Ejercicio1();
		
		num1 = myObj.pedirNumero("Ingrese el primer numero", MINIMO, MAXIMO);
		num2 = myObj.pedirNumero("Ingrese el segundo numero", MINIMO, MAXIMO);
		suma = myObj.sumar(num1, num2);
		
		System.out.println("La suma es " + suma);
	}
}
