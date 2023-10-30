package tp3.ej06;

import java.util.ArrayList;

public class ORTFlix {
	private ArrayList<Cliente> clientes;
	private ArrayList<Cliente> listaNegra;
	private ArrayList<Pelicula> peliculas;

	public ORTFlix() {
		clientes = new ArrayList<>();
		listaNegra = new ArrayList<>();
		peliculas = new ArrayList<>();
	}

	private Cliente buscarCliente(String dni) {
		int i = 0;
		Cliente clienteActual;
		Cliente clienteEncontrado = null;

		while (i < clientes.size() && clienteEncontrado == null) {
			clienteActual = clientes.get(i);

			if (clienteActual.getDni().equals(dni)) {
				clienteEncontrado = clienteActual;
			} else {
				i++;
			}
		}

		return clienteEncontrado;
	}

	private boolean buscarListaNegra(String dni) {
		int i = 0;
		Cliente clienteActual;
		boolean clienteEncontrado = false;

		while (i < listaNegra.size() && clienteEncontrado == false) {
			clienteActual = listaNegra.get(i);

			if (clienteActual.getDni().equals(dni)) {
				clienteEncontrado = true;
			} else {
				i++;
			}
		}

		return clienteEncontrado;
	}

	private Pelicula buscarPelicula(String nombre) {
		int i = 0;
		Pelicula peliculaActual;
		Pelicula peliculaEncontrada = null;

		while (i < peliculas.size() && peliculaEncontrada == null) {
			peliculaActual = peliculas.get(i);

			if (peliculaActual.getNombre().equals(nombre)) {
				peliculaEncontrada = peliculaActual;
			} else {
				i++;
			}
		}

		return peliculaEncontrada;
	}

	public boolean agregarPelicula(String nombre, Tipo tipo) {
		boolean peliculaAgregada = false;
		Pelicula peliculaEncontrada = buscarPelicula(nombre);

		if (peliculaEncontrada == null) {
			Pelicula pelicula = new Pelicula(nombre, tipo);
			peliculaAgregada = peliculas.add(pelicula);
		}

		return peliculaAgregada;
	}

	public ResultadoVerPelicula verPelicula(String dni, String nombrePelicula) {
		ResultadoVerPelicula resultado;
		Cliente cliente = buscarCliente(dni);
		Pelicula pelicula = buscarPelicula(nombrePelicula);

		if (cliente == null) {
			resultado = ResultadoVerPelicula.CLIENTE_INEXISTENTE;
		} else if (pelicula == null) {
			resultado = ResultadoVerPelicula.CONTENIDO_INEXISTENTE;
		} else if (cliente.esDeudor()) {
			resultado = ResultadoVerPelicula.CLIENTE_DEUDOR;
		} else if (pelicula.esPremium() && !cliente.esPremium()) {
			resultado = ResultadoVerPelicula.CONTENIDO_NO_DISPONIBLE;
		} else {
			cliente.agregarPelicula(nombrePelicula);
			resultado = ResultadoVerPelicula.OK;
		}

		return resultado;
	}

	public void darDeBaja(String dni) {
		Cliente cliente = buscarCliente(dni);

		if (cliente != null) {
			if (cliente.esDeudor()) {
				listaNegra.add(cliente);
			}

			clientes.remove(cliente);
		}
	}

	public ResultadoAlta darDeAlta(String dni, String nombre, Tipo tipo) {
		ResultadoAlta resultado;
		Cliente cliente = buscarCliente(dni);
		boolean esDeudor = buscarListaNegra(dni);

		if (cliente != null) {
			resultado = ResultadoAlta.CLIENTE_EXISTE;
		} else if (esDeudor) {
			resultado = ResultadoAlta.CLIENTE_DEUDOR;
		} else {
			Cliente clienteNuevo = new Cliente(dni, nombre, tipo);
			clientes.add(clienteNuevo);
			resultado = ResultadoAlta.ALTA_OK;
		}

		return resultado;
	}

	public void depurarListaNegra(double importe) {
		ArrayList<Cliente> clientesAEliminar = new ArrayList<>();

		for (Cliente cliente : listaNegra) {
			if (cliente.getSaldoAPagar() <= importe) {
				clientesAEliminar.add(cliente);
			}
		}

		listaNegra.removeAll(clientesAEliminar);

		// Java Lambda Expression
		// listaNegra.removeIf(cliente -> cliente.getSaldoAPagar() <= importe);
	}

	public boolean actualizarSaldo(String dni, double importe) {
		boolean saldoActualizado = false;
		Cliente cliente = buscarCliente(dni);

		if (cliente != null) {
			cliente.setSaldoAPagar(importe);
			saldoActualizado = true;
		}

		return saldoActualizado;
	}

	public void mostrarClientes() {

		if (!clientes.isEmpty()) {
			System.out.println("\nClientes:");
			for (Cliente cliente : clientes) {
				System.out.println("- " + cliente);
			}
		} else {
			System.out.println("No hay clientes");
		}
	}

	public void mostrarListaNegra() {

		if (!listaNegra.isEmpty()) {
			System.out.println("\nLista negra:");
			for (Cliente cliente : listaNegra) {
				System.out.println(cliente);
			}
		} else {
			System.out.println("Lista negra vacía");
		}
	}

	public void mostrarPeliculas() {
		System.out.println("\nPelículas:");
		for (Pelicula pelicula : peliculas) {
			System.out.println("- " + pelicula);
		}
	}
}
