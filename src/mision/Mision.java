package mision;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import batalla.Batalla;
import ejercito.Ejercito;
import mapa.Bando;
import mapa.Distancia;
import mapa.Mapa;
import mapa.Poblado;
import mapa.Camino;
import unidades.*;

public class Mision {

	private Mapa mapa;
	private int sobrevivientes;
	private int diasTranscurridos;

	/**
	 * Se crea la mision pasandole un archivo y comienza a leerla.
	 */
	public Mision(String archivo) throws IOException, FormatException {
		mapa = Mapa.obtenerMapa();
		leerMision(archivo);
	}

	/**
	 * Comieza a leer la mision con el archivo que se le pasa como parametro.
	 */
	public void leerMision(String archivo) throws IOException, FormatException {

		FileReader mision = new FileReader(archivo);
		BufferedReader lector = new BufferedReader(mision);

		int nPoblados = leerCantidadDePoblados(lector.readLine());

		for (int i = 0; i < nPoblados; i++) {
			leerPoblado(lector.readLine());
		}

		leerInicioYDestino(lector.readLine());

		String siguienteLinea = lector.readLine();
		while (siguienteLinea != null) {
			leerCaminos(siguienteLinea);
			siguienteLinea = lector.readLine();
		}

		if (lector != null)
			lector.close();
	}

	public int obtenerSobrevivientes() {
		return sobrevivientes;
	}

	public int obtenerDiasTranscurridos() {
		return diasTranscurridos;
	}

	public boolean esFactible() {

		HashMap<String, Distancia> caminoMasCorto = obtenerCaminoMasCorto(
				Mapa.obtenerMapa().obtenerNombrePobladoInicial());

		Stack<String> recorrido = new Stack<String>();

		HashMap<String, Poblado> poblados = Mapa.obtenerMapa().obtenerPoblados();

		String nombrePobladoFinal = Mapa.obtenerMapa().obtenerNombrePobladoFinal();

		Poblado pobladoInicial = Mapa.obtenerMapa().obtenerPobladoInicial();

		recorrido.add(nombrePobladoFinal);

		while (!caminoMasCorto.get(nombrePobladoFinal).obtenerNombrePoblado().equals(pobladoInicial.obtenerNombre())) {

			recorrido.add(caminoMasCorto.get(nombrePobladoFinal).obtenerNombrePoblado());
			nombrePobladoFinal = recorrido.peek();
		}

		Ejercito ejercitoPropio = pobladoInicial.obtenerEjercito();

		Poblado poblado;

		while (!recorrido.isEmpty() && !ejercitoPropio.estaDesmayado()) {

			poblado = poblados.get(recorrido.pop());

			diasTranscurridos(caminoMasCorto.get(poblado.obtenerNombre()).obtenerDistancia());

			if (poblado.obtenerBando() == Bando.ALIADO) {

				int cantidadDeHabitantes = poblado.obtenerCantidadHabitantes();

				for (int i = 0; i < cantidadDeHabitantes / 2; i++) {
					ejercitoPropio.agregarAliadosAlEjercito(poblado.obtenerEjercito().extraerPrimeraUnidad());

				}

				ejercitoPropio.descansar();

			} else if (poblado.obtenerBando() == Bando.ENEMIGO) {

				Ejercito ejercitoEnemigo = poblado.obtenerEjercito();

				Batalla batalla = new Batalla(ejercitoPropio, ejercitoEnemigo);

				batalla.iniciar();

			}
		}

		if (ejercitoPropio.estaDesmayado()) {
			return false;
		}

		sobrevivieron(ejercitoPropio.cantidadUnidades());
		return true;
	}

	public HashMap<String, Distancia> obtenerCaminoMasCorto(String inicio) {
		
		HashMap<String, Boolean> visitados = new HashMap<String, Boolean>();
		HashMap<String, Integer> distancias = new HashMap<String, Integer>();
		HashMap<String, Distancia> camino = new HashMap<String, Distancia>();
		PriorityQueue<Distancia> cola = new PriorityQueue<Distancia>();
		for (String vertice : Mapa.obtenerMapa().obtenerPoblados().keySet()) {
			camino.put(vertice, null);
			distancias.put(vertice, Integer.MAX_VALUE);
			visitados.put(vertice, Boolean.FALSE);
		}
		distancias.put(inicio, 0);
		cola.add(new Distancia(inicio, 0));
		
		while (!cola.isEmpty()) {
			
			Distancia distancia = cola.poll();
			
			if (!visitados.get(distancia.obtenerNombrePoblado())) {
				
				visitados.put(distancia.obtenerNombrePoblado(), Boolean.TRUE);
				
				for (Map.Entry<String, Camino> arista : Mapa.obtenerMapa().obtenerPoblados()
						.get(distancia.obtenerNombrePoblado()).obtenerListaDeCaminos().entrySet()) {
					
					if (!visitados.get(arista.getKey())) {
						
						int nuevaDistancia = distancia.obtenerDistancia() + arista.getValue().obtenerDias();
						
						if (nuevaDistancia < distancias.get(arista.getKey())) {
							
							distancias.put(arista.getKey(), nuevaDistancia);
							
							camino.put(arista.getKey(),
									new Distancia(distancia.obtenerNombrePoblado(), nuevaDistancia));
							
							cola.add(new Distancia(arista.getKey(), distancias.get(arista.getKey())));
						}
					}
				}
			}
		}
		return camino;
	}

	private void sobrevivieron(int cantidadUnidades) {
		sobrevivientes = cantidadUnidades;
	}

	private void diasTranscurridos(int dias) {
		diasTranscurridos = dias;
	}

	private int leerCantidadDePoblados(String linea) throws NumberFormatException, FormatException {
		try {
			int cantidadPoblados = Integer.parseInt(linea.trim());
			if (cantidadPoblados <= 0)
				throw new FormatException("La cantidad de poblados de la mision no es valida.");
			return cantidadPoblados;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("La cantidad de pueblos debe ser un numero.");
		}
	}

	private void leerPoblado(String linea) throws FormatException {

		String[] datosPoblados = linea.split(" ");

		validarLineaDePoblado(datosPoblados);
		int cantDeHabitantes = Integer.parseInt(datosPoblados[1]);
		String nombre = datosPoblados[0];

		Bando bando = obtenerBando(datosPoblados[3]);

		Ejercito ejercito = new Ejercito();

		for (int i = 0; i < cantDeHabitantes; i++) {

			ejercito.agregarAlEjercito(obtenerUnidad(datosPoblados[2]));

		}

		crearPoblado(nombre, ejercito, bando);
	}

	private void validarLineaDePoblado(String[] datosPoblados) throws FormatException {

		if (datosPoblados.length != 4) {
			throw new FormatException(
					"Las líneas que describen un poblado deben contener exactamente 4 datos sepadados entre sí por un espacio en blanco.");
		}
		if ((obtenerUnidad(datosPoblados[2]) == null)) {
			throw new FormatException("el nombre de la raza no existe.");
		}
		if (obtenerBando(datosPoblados[3]) == null) {
			throw new FormatException("el nombre del bando no existe.");
		}
	}

	private void crearPoblado(String nombre, Ejercito ejercito, Bando bando) {
		mapa.agregarPoblado(nombre, ejercito, bando);
	}

	private void leerInicioYDestino(String linea) throws FormatException {
		String[] datos = linea.split(" ");
		validarInicioYDestino(datos);
		mapa.establecerPobladoInicial(datos[0]);
		mapa.establecerNombrePobladoFinal(datos[2]);
	}

	/**
	 * Valida los datos de poblados de inicio y destino.
	 */
	private void validarInicioYDestino(String[] datos) throws FormatException {
		if (datos.length != 3)
			throw new FormatException("Los datos de poblado de inicio y destino son incorrectos.");
	}

	/**
	 * Lee los caminos que se pasan en la linea como parametro.
	 */
	private void leerCaminos(String siguienteLinea) throws NumberFormatException, FormatException {
		String[] datosCaminos = siguienteLinea.split(" ");

		validarCamino(datosCaminos);
		String inicio = datosCaminos[0];
		String destino = datosCaminos[1];
		int dias = Integer.parseInt(datosCaminos[2]);

		crearCamino(inicio, destino, dias);
	}

	private void validarCamino(String[] datosCaminos) throws FormatException, NumberFormatException {
		if (datosCaminos.length != 3)
			throw new FormatException(
					"La linea del camino debe poseer el poblado inicial, el poblado destino, y los dias de viaje que hay entre esos poblados.");

		if (Integer.parseInt(datosCaminos[2]) < 0)
			throw new NumberFormatException("El numero de dias debe ser mayor o igual que 0.");

	}

	/**
	 * Crea un camino en el mapa pasandole el poblado inicio y el poblado destino.
	 */
	private void crearCamino(String inicio, String destino, int dias) {
		mapa.agregarCamino(inicio, destino, dias);
	}

	private Bando obtenerBando(String nombre) throws FormatException {
		switch (nombre.toLowerCase()) {
		case "propio":
			return Bando.PROPIO;
		case "aliado":
			return Bando.ALIADO;
		case "enemigo":
			return Bando.ENEMIGO;
		default:
			throw new FormatException("El bando " + nombre + " no existe.");
		}
	}

	private Unidad obtenerUnidad(String raza) throws FormatException {
		switch (raza.toLowerCase()) {
		case "nortaichian":
			return new Nortaichian();
		case "radaiteran":
			return new Radaiteran();
		case "reralopes":
			return new Reralope();
		case "wrives":
			return new Wrive();
		}
		throw new FormatException("La raza " + raza + " no existe.");
	}
}
