package tp2.ej11;

public class Test {
	public static void main(String[] args) {		
		System.out.println(Turnera.obtenerUltimoNumeroOtorgado());
		
		Turnera.otorgarProximoNumero();
		System.out.println(Turnera.obtenerUltimoNumeroOtorgado());
		
		Turnera.otorgarProximoNumero();
		Turnera.otorgarProximoNumero();
		System.out.println(Turnera.obtenerUltimoNumeroOtorgado());
		
		Turnera.resetearContador(10);
		System.out.println(Turnera.obtenerUltimoNumeroOtorgado());
		
		Turnera.resetearContador();
		System.out.println(Turnera.obtenerUltimoNumeroOtorgado());
	}
}
