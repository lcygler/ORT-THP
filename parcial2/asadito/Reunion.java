package parcial2.asadito;

import java.util.ArrayList;

public class Reunion {

	private String motivo;
	private ArrayList<Amigo> amigos;
	private ArrayList<PropuestaReunion> propuestasExistentes;

	public Reunion(String tema) {
		// TODO - Completar constructor
		this.setMotivo(tema);
		this.amigos = new ArrayList<>();
		this.propuestasExistentes = new ArrayList<>();
	}

	private void setMotivo(String tema) {
		if (tema != null) {
			this.motivo = tema;
		}
	}

	public ResultadoOperacion anotarAmigo(String nombre, String domicilio) {
		Amigo amigo = buscarAmigo(nombre);
		ResultadoOperacion res = ResultadoOperacion.AMIGO_YA_EXISTENTE;
		if (amigo == null) {
			amigos.add(new Amigo(nombre, domicilio));
			res = ResultadoOperacion.OPERACION_OK;
		}
		return res;
	}

	private ResultadoOperacion bajarDePropuesta(Amigo amigo, DiaSemana diaSemana, MomentoDia momento) {
		// TODO - Completar la baja de un amigo de una propuesta.
		/*
		 * Si la propuesta quedara sin ningun amigo, eliminarla de la coleccion de
		 * propuestas existentes.
		 */

		ResultadoOperacion resultado = ResultadoOperacion.AMIGO_NO_EXISTENTE;
		PropuestaReunion propuesta = buscarPropuesta(diaSemana, momento);

		if (propuesta != null) {
			resultado = propuesta.borrarAmigo(amigo);

			if (propuesta.sinAnotados()) {
				this.propuestasExistentes.remove(propuesta);
			}
		}

		return resultado;
	}

	public ResultadoOperacion bajarDePropuesta(String nombre, DiaSemana diaSemana, MomentoDia momento) {
		ResultadoOperacion res = ResultadoOperacion.AMIGO_NO_EXISTENTE;
		Amigo amigo = buscarAmigo(nombre);
		if (amigo != null) {
			res = bajarDePropuesta(amigo, diaSemana, momento);
		}
		return res;
	}

	private Amigo buscarAmigo(String nombre) {
		Amigo amigo = null;
		int pos = 0;
		while (pos < amigos.size() && !amigos.get(pos).mismoNombre(nombre)) {
			pos++;
		}
		if (pos < amigos.size())
			amigo = amigos.get(pos);
		return amigo;
	}

	private PropuestaReunion buscarPropuesta(DiaSemana diaSemana, MomentoDia momento) {
		// TODO - Completar busqueda de la propuesta
		int i = 0;
		PropuestaReunion propuesta = null;
		PropuestaReunion propuestaActual;

		while (i < this.propuestasExistentes.size() && propuesta == null) {
			propuestaActual = this.propuestasExistentes.get(i);

			if (propuestaActual.mismaPropuesta(diaSemana, momento)) {
				propuesta = propuestaActual;
			} else {
				i++;
			}
		}

		return propuesta;
	}

	public ResultadoOperacion cambiarDePropuesta(String nombre, DiaSemana diaOriginal, MomentoDia momentoOriginal, DiaSemana diaNuevo, MomentoDia momentoNuevo) {
		ResultadoOperacion res = ResultadoOperacion.AMIGO_NO_EXISTENTE;
		Amigo amigo = buscarAmigo(nombre);
		if (amigo != null) {
			res = unirAPropuesta(diaNuevo, momentoNuevo, amigo);
			if (res.equals(ResultadoOperacion.OPERACION_OK))
				res = bajarDePropuesta(amigo, diaOriginal, momentoOriginal);
		}
		return res;
	}

	public ResultadoOperacion crearPropuesta(String nombre, DiaSemana diaSemana, MomentoDia momento) {
		ResultadoOperacion res = ResultadoOperacion.PROPUESTA_NO_EXISTENTE;
		Amigo amigo = buscarAmigo(nombre);
		if (amigo != null) {
			PropuestaReunion propuesta = buscarPropuesta(diaSemana, momento);
			if (propuesta == null) {
				propuesta = new PropuestaReunion(diaSemana, momento);
				propuestasExistentes.add(propuesta);
			}
			res = propuesta.anotarAmigo(amigo);
		}
		return res;
	}

	public void listar() {
		listarAmigos();
		listarPropuestas();
		// TODO - Desarrollar listarAmigosFaltantes();
		/*
		 * Debe mostrar los nombres de aquellos amigos que no se han adherido a ninguna
		 * de las propuestas existentes (ni propia ni ajena).
		 */
		listarAmigosFaltantes();
		System.out.println();
	}

	private void listarAmigos() {
		System.out.println("Amigos registrados para " + motivo);
		for (Amigo amigo : amigos) {
			System.out.println(amigo.getNombre());
		}
	}

	private void listarPropuestas() {
		System.out.println("Propuestas registradas para " + motivo);
		for (PropuestaReunion propuesta : propuestasExistentes) {
			propuesta.listar();
		}
	}

	private void listarAmigosFaltantes() {
		int i;
		boolean estaAnotado;
		PropuestaReunion propuestaActual;
		ArrayList<Amigo> amigosFaltantes = new ArrayList<>();

		for (Amigo amigo : this.amigos) {
			i = 0;
			estaAnotado = false;
			
			while (i < this.propuestasExistentes.size() && !estaAnotado) {
				propuestaActual = this.propuestasExistentes.get(i);
				estaAnotado = propuestaActual.estaAnotadoAmigo(amigo);

				if (!estaAnotado) {
					i++;
				}
			}

			if (!estaAnotado) {
				amigosFaltantes.add(amigo);
			}
		}

		System.out.println("Amigos no registrados en ninguna propuesta:");
		for (Amigo amigo : amigosFaltantes) {
			System.out.println(amigo.getNombre());
		}
	}

	private ResultadoOperacion unirAPropuesta(DiaSemana diaSemana, MomentoDia momento, Amigo amigo) {
		ResultadoOperacion res = ResultadoOperacion.PROPUESTA_NO_EXISTENTE;
		PropuestaReunion fechaReunion = buscarPropuesta(diaSemana, momento);
		if (fechaReunion != null) {
			res = fechaReunion.anotarAmigo(amigo);
		}
		return res;
	}

	public ResultadoOperacion unirAPropuesta(DiaSemana diaSemana, MomentoDia momento, String nombre) {
		// TODO - Completar el agregado de un amigo a una propuesta existente
		ResultadoOperacion resultado = ResultadoOperacion.AMIGO_NO_EXISTENTE;
		Amigo amigo = buscarAmigo(nombre);

		if (amigo != null) {
			resultado = unirAPropuesta(diaSemana, momento, amigo);
		}

		return resultado;
	}
}
