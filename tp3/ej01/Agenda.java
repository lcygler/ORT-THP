package tp3.ej01;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> personas;

	public Agenda() {
		this.personas = new ArrayList<>();
	}

	private Persona buscarPersona(String dni) {
		int i = 0;
		Persona personaActual;
		Persona personaEncontrada = null;

		while (i < personas.size() && personaEncontrada == null) {
			personaActual = personas.get(i);

			if (personaActual.getDni().equals(dni)) {
				personaEncontrada = personaActual;
			} else {
				i++;
			}
		}

		return personaEncontrada;
	}

	public boolean agregarPersona(String dni, String nombre, String apellido, Domicilio domicilio) {
		boolean personaAgregada = false;
		Persona persona = buscarPersona(dni);

		if (persona == null) {
			persona = new Persona(dni, nombre, apellido, domicilio);
			personaAgregada = personas.add(persona);
			System.out.println("Se ha agregado la persona");
		} else {
			System.out.println("La persona ya existe");
		}

		return personaAgregada;
	}

	public Persona removerPersona(String dni) {
		Persona persona = buscarPersona(dni);

		if (persona != null) {
			personas.remove(persona);
			System.out.println("Se ha eliminado la persona");
		} else {
			System.out.println("La persona no existe");
		}

		return persona;
	}

	public boolean modificarDomicilio(String dni, Domicilio domicilio) {
		boolean domicilioModificado = false;
		Persona persona = buscarPersona(dni);

		if (persona != null) {
			persona.setDomicilio(domicilio);
			domicilioModificado = true;
			System.out.println("Se ha modificado el domicilio");
		} else {
			System.out.println("La persona no existe");
		}

		return domicilioModificado;
	}

	public void listarPersonas() {
		if (!personas.isEmpty()) {
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("La agenda está vacía");
		}
	}

	public Persona devolverUltimo() {
		Persona ultimaPersona = null;

		if (!personas.isEmpty()) {
			ultimaPersona = personas.get(personas.size() - 1);
		} else {
			System.out.println("La agenda está vacía");
		}

		return ultimaPersona;
	}

	public void eliminarTodosElementosAMano() {
		while (!personas.isEmpty()) {
			personas.remove(0);
		}
	}
}
