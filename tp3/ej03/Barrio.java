package tp3.ej03;

import java.util.ArrayList;

public class Barrio {
	private String nombre;
	private ArrayList<Propiedad> propiedades;

	public Barrio(String nombre) {
		setNombre(nombre);
		propiedades = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public Propiedad buscarPropiedad(String direccion) {
		int i = 0;
		Propiedad propiedadActual;
		Propiedad propiedadEncontrada = null;

		while (i < propiedades.size() && propiedadEncontrada == null) {
			propiedadActual = propiedades.get(i);

			if (propiedadActual.getDireccion().equals(direccion)) {
				propiedadEncontrada = propiedadActual;
			} else {
				i++;
			}
		}

		return propiedadEncontrada;
	}

	public boolean agregarPropiedad(Propiedad propiedad) {
		return propiedades.add(propiedad);

	}

	public boolean borrarPropiedad(Propiedad propiedad) {
		return propiedades.remove(propiedad);

	}

	public int obtenerCantPropiedades() {
		return propiedades.size();
	}

	public void mostrarPropiedades() {
		for (Propiedad propiedad : propiedades) {
			System.out.println(propiedad.toString());
		}
	}

	public void mostrarPropiedades(TipoPropiedad tipo) {
		if (tipo != null) {
			for (Propiedad propiedad : propiedades) {
				if (propiedad.getTipo() == tipo) {
					System.out.println(propiedad.toString());
				}
			}
		}
	}

	@Override
	public String toString() {
		int i = 0;
		String cadena = "Barrio [nombre=" + nombre + ", propiedades=[";

		for (Propiedad propiedad : propiedades) {
			cadena += propiedad.toString();
			
			if(i < propiedades.size() - 1) {
				cadena += ", ";
				i++;
			}
		}

		cadena += "]";
				
		return cadena;
	}
}
