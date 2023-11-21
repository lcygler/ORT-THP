package parcial2.centraldedespachos.v2;

import java.util.ArrayList;

public class Flete {
	private double PORCENTAJE_UMBRAL_LLENADO = 80;
	
	private String patente;
	private double cargaMaxima;
	private double cargaActual;
	private Sucursal destino;
	private ArrayList<Paquete> paquetes;
	
	/** 
	 * Este constructor inicializa un flete.
	 * @param patente
	 * @param cargaMaxima
	 */
	public Flete(String patente, double cargaMaxima) {
		// TODO
		this.setPatente(patente);
		this.setCargaMaxima(cargaMaxima);
		this.cargaActual = 0.0;
		this.destino = null;
		this.paquetes = new ArrayList<>();
	}

	public String getPatente() {
		return this.patente;
	}

	private void setPatente(String patente) {
		if (patente != null) {
			this.patente = patente;
		}
	}

	public double getCargaMaxima() {
		return this.cargaMaxima;
	}

	private void setCargaMaxima(double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}
		
	public double getCargaActual() {
		return this.cargaActual;
	}

	private void setCargaActual(double cargaActual) {
		this.cargaActual = cargaActual;
	}

	public Sucursal getDestino() {
		return this.destino;
	}

	private void setDestino(Sucursal destino) {
		if (destino != null) {
			this.destino = destino;
		}
	}

	/**
	 * Devuelve verdadero si la patente coincide con la patente del flete.
	 * @param patente
	 * @return
	 */
	public boolean mismaPatente(String patente) {
		// TODO
		boolean mismaPatente = false;

		if (patente != null && patente.equals(this.patente)) {
			mismaPatente = true;
		}

		return mismaPatente;
	}

	/**
	 * Devuelve verdadero si la carga del flete es superior al umbral (80%).
	 * @return
	 */
	public boolean esDespachable() {
		// TODO
		boolean esDespachable = false;
		double umbral = PORCENTAJE_UMBRAL_LLENADO * this.cargaMaxima / 100;

		if (this.cargaActual >= umbral) {
			esDespachable = true;
		}

		return esDespachable;
	}
	
	/**
	 * Devuelve verdadero si se cumplen las siguientes condiciones:
	 * - el flete no tiene asignado ning�n destino o en caso de tenerlo, coincide con el paquete.
	 * - el peso del paquete no har� sobrepasar la carga m�xima del flete.
	 * @param paquete
	 * @return
	 */
	private boolean puedeCargar(Paquete paquete) {
		// TODO
		boolean puedeCargar = false;
		boolean destinoValido = false;
		boolean pesoValido = false;

		destinoValido = this.destino == null || this.destino == paquete.getDestino();
		pesoValido = this.cargaActual + paquete.getPeso() <= this.cargaMaxima;

		if (destinoValido && pesoValido) {
			puedeCargar = true;
		}

		return puedeCargar;
	}
	
	/**
	 * Este m�todo debe verificar que el flete sea capaz de llevar este paquete.
	 * En caso afirmativo debe asegurarse que el flete tenga seteado ese destino
	 * y debe registrar el paquete actualizando la carga del flete.
	 * En caso que no lo pueda cargar, debe devolver false
	 * @param paquete
	 * @return
	 */
	public boolean cargarPaquete(Paquete paquete) {
		//TODO
		boolean cargarPaquete = false;

		if (paquete != null && this.puedeCargar(paquete)) { // El método puedeCargar() ya valida destino y peso
			if (this.destino == null) {
				this.setDestino(paquete.getDestino()); // Asignar destino del primer paquete
			}

			this.setCargaActual(this.cargaActual + paquete.getPeso());
			this.paquetes.add(paquete);
			cargarPaquete = true;
		}

		return cargarPaquete;
	}
	
	private Paquete obtenerPaqueteMasPesado() {
		double pesoMaximo = 0;
		Paquete paqueteMasPesado = null;

		for (Paquete paquete : this.paquetes) {
			if (paquete.getPeso() > pesoMaximo) {
				pesoMaximo = paquete.getPeso();
				paqueteMasPesado = paquete;
			}
		}

		return paqueteMasPesado;
	}
	
	public void listarFleteConPaqueteMasPesado() {
		Paquete paqueteMasPesado = obtenerPaqueteMasPesado();

		if (paqueteMasPesado != null) {
			System.out.println("Patente: " + getPatente() + " - Destino: " + getDestino() + " - Paquete: "
					+ paqueteMasPesado.getNroSeguimiento() + " - Peso: " + paqueteMasPesado.getPeso());
		}
	}
}
