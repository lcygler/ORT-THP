package parcial2.centraldedespachos.v2;

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
	
	private void despacharFlete(Flete flete) {
		if (flete != null) {
			this.fletesDisponibles.remove(flete);
			this.fletesDespachados.add(flete);
		}
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
		int indicePaquetes = 0;
		int cantidadDespachados = 0;
		boolean paqueteCargado = false;
		Paquete paquete;

		while (indicePaquetes < this.paquetesPendientes.size()) {
			paquete = this.paquetesPendientes.get(indicePaquetes);

			while (indiceFletes < this.fletesDisponibles.size() && !paqueteCargado) {
				Flete flete = this.fletesDisponibles.get(indiceFletes);
				paqueteCargado = flete.cargarPaquete(paquete);

				if (paqueteCargado) {
					this.paquetesPendientes.remove(indicePaquetes);

					if (flete.esDespachable()) {
						this.despacharFlete(flete);
					}

					cantidadDespachados++;
				} else {
					indiceFletes++;
				}
			}

			if (!paqueteCargado) {
				indicePaquetes++;
			}
			
			paqueteCargado = false;
			indiceFletes = 0;
		}

		return cantidadDespachados;
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
		for (Flete flete : this.fletesDespachados) {
			flete.listarFleteConPaqueteMasPesado();
		}
	}
}
