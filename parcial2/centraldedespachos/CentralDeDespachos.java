package parcial2.centraldedespachos;

import java.util.ArrayList;

public class CentralDeDespachos {
	private ArrayList<Flete> fletesDisponibles;
	private ArrayList<Flete> fletesDespachados;
	private ArrayList<Paquete> paquetesPendientes;
	
	public CentralDeDespachos() {
		fletesDisponibles = new ArrayList<>();
		fletesDespachados = new ArrayList<>();
		paquetesPendientes = new ArrayList<>();
	}
	
	private Flete buscarFlete(String patente, ArrayList<Flete> listaFletes) {		
		int index = 0;
		while (index < listaFletes.size() && !listaFletes.get(index).mismaPatente(patente)) {			
			index++;
		}
		return index < listaFletes.size() ? listaFletes.get(index) : null;
	}
	
	public boolean agregarFlete(String patente, double cargaMaxima) {
		boolean pudo = false;
		boolean existeEnDisponibles = buscarFlete(patente, this.fletesDisponibles) != null;
		boolean existeEnDespachados = buscarFlete(patente, this.fletesDespachados) != null;
		
		if (!existeEnDisponibles && !existeEnDespachados) { // Se corrigió la condición para solucionar el bug
			this.fletesDisponibles.add(new Flete(patente, cargaMaxima));
			pudo = true;
		}
		
		return pudo;
	}
	
	public void agregarPaquete(Sucursal sucursal, double peso) {
		paquetesPendientes.add(new Paquete(sucursal, peso));
	}

	public int paquetesPendientes() {
		return paquetesPendientes.size();
	}
	
	/**
	 * Procesa todos los paquetes pendientes de despacho.
	 * Para cada paquete busca el primer flete disponible que pueda cargarlo.
	 * Si lo puede cargar, lo elimina de la lista, de otro modo permanece en la lista de pendientes.
	 * Si al cargar un paquete en un flete este sobrepasa el umbral m�nimo de despacho, el flete debe
	 *   eliminarse de la lista de fletes disponibles y agregarse a la de fletes despachados.
	 * @return
	 */
	public int despacharPendientes() {
		// TODO
		int indiceFletes = 0;
		int cantidadProcesados = 0;
		boolean paqueteProcesado = false;
		Paquete paquete;

		for (int indicePaquetes = 0; indicePaquetes < this.paquetesPendientes.size(); indicePaquetes++) {
			paquete = this.paquetesPendientes.get(indicePaquetes);

			while (indiceFletes < this.fletesDisponibles.size() && !paqueteProcesado) {
				Flete flete = this.fletesDisponibles.get(indiceFletes);
				paqueteProcesado = flete.cargarPaquete(paquete);

				if (paqueteProcesado) {
					this.paquetesPendientes.remove(indicePaquetes);

					if (flete.esDespachable()) {
						this.fletesDisponibles.remove(flete);
						this.fletesDespachados.add(flete);
					}

					indicePaquetes--;
					cantidadProcesados++;
				} else {
					indiceFletes++;
				}
			}

			indiceFletes = 0;
			paqueteProcesado = false;
		}

		return cantidadProcesados;
	}
	
	/**
	 * Lista todos los fletes despachados y para cada uno muestra:
	 * - patente
	 * - destino
	 * - paquete (nro de seguimiento del paquete m�s pesado)
	 * - peso (peso del paquete m�s pesado dentro del flete)
	 */
	public void listarFletesDespachadosConPaqueteMasPesado() {
		System.out.println("Listado de fletes despachados con su paquete más pesado:");
		// TODO
		Paquete paqueteMasPesado = null;

		for (Flete flete : this.fletesDespachados) {
			paqueteMasPesado = flete.obtenerPaqueteMasPesado();

			if (paqueteMasPesado != null) {
				System.out.println("Patente: " + flete.getPatente());
				System.out.println("Destino: " + flete.getDestino());
				System.out.println("Paquete: " + paqueteMasPesado.getNroSeguimiento());
				System.out.println("Peso: " + paqueteMasPesado.getPeso() + "\n");
			}
		}
	}
}
