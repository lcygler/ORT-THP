package parcial2.asadito;

import java.util.ArrayList;

public class PropuestaReunion {

	private DiaSemana diaSemana;
	private MomentoDia momentoDia;
	private ArrayList<Amigo> anotados;

	public PropuestaReunion(DiaSemana diaSemana, MomentoDia momentoDia) {
		// TODO - Completar constructor
		this.setDiaSemana(diaSemana);
		this.setMomentoDia(momentoDia);
		this.anotados = new ArrayList<>();
	}

	private void setDiaSemana(DiaSemana diaSemana) {
		if (diaSemana != null) {
			this.diaSemana = diaSemana;
		}
	}

	private void setMomentoDia(MomentoDia momentoDia) {
		if (momentoDia != null) {
			this.momentoDia = momentoDia;
		}
	}

	public ResultadoOperacion anotarAmigo(Amigo amigoAAnotar) {
		ResultadoOperacion res = ResultadoOperacion.AMIGO_YA_EXISTENTE;
		if (!estaAnotado(amigoAAnotar)) {
			anotados.add(amigoAAnotar);
			res = ResultadoOperacion.OPERACION_OK;
		}
		return res;
	}

	public ResultadoOperacion borrarAmigo(Amigo amigoABorrar) {
		ResultadoOperacion res = ResultadoOperacion.AMIGO_NO_EXISTENTE;
		if (estaAnotado(amigoABorrar)) {
			anotados.remove(amigoABorrar);
			res = ResultadoOperacion.OPERACION_OK;
		}
		return res;
	}

	private boolean estaAnotado(Amigo amigoABuscar) {
		int pos = 0;
		while (pos < anotados.size() && !anotados.get(pos).equals(amigoABuscar)) {
			pos++;
		}
		return pos < anotados.size();
	}

	public boolean estaAnotadoAmigo(Amigo amigo) {
		return estaAnotado(amigo);
	}

	public void listar() {
		System.out.println("Hay " + anotados.size() + " amigos anotados para el " + diaSemana + " (" + momentoDia + ")");
		for (Amigo amigo : anotados) {
			System.out.println(amigo.getNombre());
		}
	}

	public boolean mismaPropuesta(DiaSemana dia, MomentoDia momento) {
		return this.diaSemana.equals(dia) && this.momentoDia.equals(momento);
	}

	public boolean sinAnotados() {
		return anotados.isEmpty();
	}
}
