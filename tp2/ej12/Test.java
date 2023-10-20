package tp2.ej12;

public class Test {
	public static final char SUMA = '+';
	public static final char RESTA = '-';
	public static final char MULTIPLICACION = '*';
	public static final char DIVISION = '/';
	
	public static void main(String[] args) {
		int numero1 = 1;
		int numero2 = 2;

		calcular(SUMA, numero1, numero2);
		calcular(RESTA, numero1, numero2);
		calcular(RESTA, numero2, numero1);
		calcular(MULTIPLICACION, numero1, numero2);

		calcular(DIVISION, numero1, numero2);
		calcular(DIVISION, numero2, numero1);
		calcular(DIVISION, numero1, 0);
		calcular(DIVISION, numero2, 0);
		calcular(DIVISION, 0, numero1);
		calcular(DIVISION, 0, numero2);
	}

	public static void calcular(char operacion, int num1, int num2) {
		int resultado = 0;

		switch (operacion) {
			case SUMA:
				resultado = Calculadora.sumar(num1, num2);
				break;
			case RESTA:
				resultado = Calculadora.restar(num1, num2);
				break;
			case MULTIPLICACION:
				resultado = Calculadora.multiplicar(num1, num2);
				break;
			case DIVISION:
				resultado = Calculadora.dividir(num1, num2);
				break;
			}

		System.out.println(num1 + " " + operacion + " " + num2 + " = " + resultado);
	}
}
