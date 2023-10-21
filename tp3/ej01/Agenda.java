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
		}

		return personaAgregada;
	}

	public Persona removerPersona(String dni) {
		Persona persona = buscarPersona(dni);

		if (persona != null) {
			personas.remove(persona);
		}

		return persona;
	}

	public boolean modificarDomicilio(String dni, Domicilio domicilio) {
		boolean domicilioModificado = false;
		Persona persona = buscarPersona(dni);

		if (persona != null) {
			persona.setDomicilio(domicilio);
			domicilioModificado = true;
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
		Persona ultimo = null;

		if (!personas.isEmpty()) {
			ultimo = personas.get(personas.size() - 1);
		}

		return ultimo;
	}

	public void eliminarTodosElementosAMano() {
		while (!personas.isEmpty()) {
			personas.remove(0);
		}
	}
}
