package tp3.ej03;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Barrio> barrios;

	public Inmobiliaria() {
		barrios = new ArrayList<>();
	}

	public void agregarBarrio(Barrio barrio) {
		if (barrio != null) {
			barrios.add(barrio);
		}
	}

	public void mostrarPropiedades() {
		for (Barrio barrio : barrios) {
			System.out.println("\nBarrio: " + barrio.getNombre());
			barrio.mostrarPropiedades();
		}
	}

	/*
	// Mostrar propiedades por tipo
	public void mostrarPropiedades() {
	    for (Barrio barrio : barrios) {
	    	System.out.println("\nBarrio: " + barrio.getNombre());
	    	
	        for (TipoPropiedad tipo : TipoPropiedad.values()) {
	            System.out.println("Tipo " + tipo + ":");
	            barrio.mostrarPropiedades(tipo);
	        }
	    }
	}
	*/

	public void mostrarPropiedades(TipoPropiedad tipo) {
		if (tipo != null) {
			for (Barrio barrio : barrios) {
				barrio.mostrarPropiedades(tipo);
			}
		}
	}

	private ArrayList<Barrio> obtenerBarrioMaxProp() {
		int maximo = 0;
		int cantPropiedades;
		ArrayList<Barrio> barriosMaxProp = new ArrayList<>();

		for (Barrio barrio : barrios) {
			cantPropiedades = barrio.obtenerCantPropiedades();

			if (cantPropiedades > maximo) {
				maximo = cantPropiedades;
				barriosMaxProp.clear();
			}

			if (cantPropiedades == maximo) {
				barriosMaxProp.add(barrio);
			}
		}

		return barriosMaxProp;
	}

	/*
	// Usar 2 "for" para recorrer la lista de barrios
	private ArrayList<Barrio> obtenerBarrioMaxProp() {
		int maximo = 0;
		ArrayList<Barrio> barriosMaxProp = new ArrayList<>();
		
		for(Barrio barrio : barrios) {
			if(barrio.obtenerCantPropiedades() > maximo) {
				maximo = barrio.obtenerCantPropiedades();
			}
		}
		
		for(Barrio barrio : barrios) {
			if(barrio.obtenerCantPropiedades() == maximo) {
				barriosMaxProp.add(barrio);
			}
		}
		
		return barriosMaxProp;
	}
	*/
	
	public void mostrarBarriosMaxProp() {
		ArrayList<Barrio> barriosMaxProp = obtenerBarrioMaxProp();

		for (Barrio barrio : barriosMaxProp) {
			System.out.println(barrio.toString());
		}
	}

	public boolean borrarPropiedad(String direccion) {
		int i = 0;
		boolean propiedadEliminada = false;
		Barrio barrioActual;
		Propiedad propiedadEncontrada = null;

		while (i < barrios.size() && propiedadEncontrada == null) {
			barrioActual = barrios.get(i);
			propiedadEncontrada = barrioActual.buscarPropiedad(direccion);

			if (propiedadEncontrada != null) {
				propiedadEliminada = barrioActual.borrarPropiedad(propiedadEncontrada);
			} else {
				i++;
			}
		}

		return propiedadEliminada;
	}

	public boolean cambiarPropiedadDeBarrio(String direccion, Barrio barrio) {
		boolean cambioExitoso = false;

		Propiedad propiedad = barrio.buscarPropiedad(direccion);

		if (propiedad != null) {
			borrarPropiedad(direccion);
			cambioExitoso = barrio.agregarPropiedad(propiedad);
		}

		return cambioExitoso;
	}
}
