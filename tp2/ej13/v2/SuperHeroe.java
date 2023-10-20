package tp2.ej13.v2;

class SuperHeroe {
	private String nombre;
	private int fuerza;
	private int resistencia;
	private int superpoderes;

	public SuperHeroe(String nombre, int fuerza, int resistencia, int superpoderes) {
		setNombre(nombre);
		setFuerza(fuerza);
		setResistencia(resistencia);
		setSuperpoderes(superpoderes);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	private void setFuerza(int fuerza) {
		this.fuerza = validar(fuerza);
	}

	private void setResistencia(int resistencia) {
		this.resistencia = validar(resistencia);
	}

	private void setSuperpoderes(int superpoderes) {
		this.superpoderes = validar(superpoderes);
	}

	private int validar(int valor) {
		if (valor < 0) {
			return 0;
		} else if (valor > 100) {
			return 100;
		} else {
			return valor;
		}
	}

	public String competir(SuperHeroe oponente) {
		int puntosHeroe1 = 0;
		int puntosHeroe2 = 0;

		puntosHeroe1 += calcular(this.fuerza, oponente.fuerza);
		puntosHeroe1 += calcular(this.resistencia, oponente.resistencia);
		puntosHeroe1 += calcular(this.superpoderes, oponente.superpoderes);

		puntosHeroe2 += calcular(oponente.fuerza, this.fuerza);
		puntosHeroe2 += calcular(oponente.resistencia, this.resistencia);
		puntosHeroe2 += calcular(oponente.superpoderes, this.superpoderes);

		if (puntosHeroe1 >= 2) {
			return "TRIUNFO";
		} else if (puntosHeroe1 == puntosHeroe2) {
			return "EMPATE";
		} else {
			return "DERROTA";
		}
	}

	private int calcular(int atributo1, int atributo2) {
		if (atributo1 > atributo2) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "SuperHeroe [nombre=" + nombre + ", fuerza=" + fuerza + ", resistencia=" + resistencia
				+ ", superpoderes=" + superpoderes + "]";
	}
}
