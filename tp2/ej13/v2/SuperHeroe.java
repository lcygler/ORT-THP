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

	private int validarRango(int valor) {
        if (valor < 0) {
            return 0;
        } else if (valor > 100) {
            return 100;
        } else {
            return valor;
        }
    }
	
	private void setFuerza(int fuerza) {
        this.fuerza = validarRango(fuerza);
    }

    private void setResistencia(int resistencia) {
        this.resistencia = validarRango(resistencia);
    }

    private void setSuperpoderes(int superpoderes) {
        this.superpoderes = validarRango(superpoderes);
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
	
	private int comparar(int atributo1, int atributo2) {
	    if (atributo1 > atributo2) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
	
	public String competir(SuperHeroe oponente) {
		int puntosHeroe1 = 0;
		int puntosHeroe2 = 0;

		puntosHeroe1 += comparar(this.fuerza, oponente.fuerza) 
				+ comparar(this.resistencia, oponente.resistencia)
				+ comparar(this.superpoderes, oponente.superpoderes);

		puntosHeroe2 += comparar(oponente.fuerza, this.fuerza) 
				+ comparar(oponente.resistencia, this.resistencia)
				+ comparar(oponente.superpoderes, this.superpoderes);
	    
		if (puntosHeroe1 >= 2) {
			return "TRIUNFO";
		} else if (puntosHeroe1 == puntosHeroe2) {
			return "EMPATE";
		} else {
			return "DERROTA";
		}
	}
}
