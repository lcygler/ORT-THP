package tp2.ej13.v1;

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
	
	private void setFuerza(int fuerza) {
		if (fuerza < 0) {
			this.fuerza = 0;
		} else if (fuerza > 100) {
			this.fuerza = 100;
		} else {
			this.fuerza = fuerza;
		}
	}

    private void setResistencia(int resistencia) {
    	if (resistencia < 0) {
			this.resistencia = 0;
		} else if (resistencia > 100) {
			this.resistencia = 100;
		} else {
			this.resistencia = resistencia;
		}
    }

    private void setSuperpoderes(int superpoderes) {
    	if (superpoderes < 0) {
			this.superpoderes = 0;
		} else if (superpoderes > 100) {
			this.superpoderes = 100;
		} else {
			this.superpoderes = superpoderes;
		}
    }
    
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}
	
	@Override
	public String toString() {
		return "SuperHeroe [nombre=" + nombre + ", fuerza=" + fuerza + ", resistencia=" + resistencia + ", superpoderes=" + superpoderes + "]";
	}
		
	public String competir(SuperHeroe oponente) {
		int puntosHeroe1 = 0;
		int puntosHeroe2 = 0;

		if (this.fuerza > oponente.fuerza) {
			puntosHeroe1++;
		} else if (this.fuerza < oponente.fuerza) {
			puntosHeroe2++;
		}

		if (this.resistencia > oponente.resistencia) {
			puntosHeroe1++;
		} else if (this.resistencia < oponente.resistencia) {
			puntosHeroe2++;
		}

		if (this.superpoderes > oponente.superpoderes) {
			puntosHeroe1++;
		} else if (this.superpoderes < oponente.superpoderes) {
			puntosHeroe2++;
		}

		if (puntosHeroe1 >= 2) {
			return "TRIUNFO";
		} else if (puntosHeroe1 == puntosHeroe2) {
			return "EMPATE";
		} else {
			return "DERROTA";
		}
	}
}
