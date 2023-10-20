package tp2.ej09;

public class Principal {
	public static void main(String[] args) {
		Domicilio domicilio = new Domicilio("Yatay", "240", "Almagro");
		
		Persona persona1 = new Persona("12345678", "Fulano", "Gómez", domicilio);
		Persona persona2 = new Persona("9123456", "Mengana", "Torres", domicilio);
		
		CuentaBancaria cuenta1 = new CuentaBancaria(TipoCuenta.CAJA_DE_AHORRO, persona1);
		CuentaBancaria cuenta2 = new CuentaBancaria(TipoCuenta.CUENTA_CORRIENTE, persona2);
		
		System.out.println(cuenta1.toString());
		System.out.println(cuenta2.toString());
	}
}
